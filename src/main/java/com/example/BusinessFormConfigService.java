package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessFormConfigService {

    @Autowired
    private BusinessFormConfigRepository repository;

    // Create
    public BusinessFormConfig create(BusinessFormConfig config) {
        return repository.save(config).block();
    }

    // Read
    public Mono<BusinessFormConfig> findById(String id) {
        return repository.findById(id);
    }

    public Flux<BusinessFormConfig> findByFormName(String formName) {
        return repository.findByFormName(formName);
    }

    public Flux<BusinessFormConfig> findByFormCode(String formCode) {
        return repository.findByFormCode(formCode);
    }
    public Flux<BusinessFormConfig> findByFormNameAndFormCode(String formName, String formCode) {
        return repository.findByFormNameAndFormCode(formName, formCode);
    }

    // Update (Illustrative - adjust based on your specific update needs)
    public List<BusinessFormConfig> updateStatusByFormName(String formName, String newStatus) {
        Flux<BusinessFormConfig> configs = repository.findByFormName(formName);
        List<BusinessFormConfig> configsList = configs.collectList().block();
        for (BusinessFormConfig config : configsList) {
            config.setStatus(newStatus);
            repository.save(config).block();
        }
        return configsList;
    }
    public BusinessFormConfig updateList(String id, Map<String, Object> updates) {
        Mono<BusinessFormConfig> monoConfig = findById(id);
        BusinessFormConfig existingConfig = monoConfig.block();
        if (existingConfig != null) {
            // Update top-level fields directly (e.g., formName)
            if (updates.containsKey("formName")) {
                existingConfig.setFormName((String) updates.get("formName"));
            }

            // Handle updates within 'linkTables' (add new entries)
            if (updates.containsKey("linkTables")) {
                Map<String, Map<String, Object>> newLinkTables = (Map<String, Map<String, Object>>) updates.get("linkTables");
                existingConfig.getLinkTables().putAll(newLinkTables); // Simple merge for illustration
            }

            // Handle updates within 'columns' (replace entire list)
            if (updates.containsKey("columns")) {
                List<Map<String, Object>> newColumns = (List<Map<String, Object>>) updates.get("columns");
                existingConfig.setColumns(newColumns); // Replace entire list for illustration
            }

            return repository.save(existingConfig).block();
        } else {
            return null; // Or throw an exception, depending on your error handling
        }
    }

    // Delete
    public void deleteById(String id) {
        repository.deleteById(id).block();
    }
}