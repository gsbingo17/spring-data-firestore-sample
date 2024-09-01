package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringDataFirestoreSampleApplication implements CommandLineRunner {

    @Autowired
    private BusinessFormConfigService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataFirestoreSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BusinessFormConfigGenerator generator = new BusinessFormConfigGenerator();
        BusinessFormConfig config = generator.generate();

        // Create
        service.create(config);
        System.out.println("Form: " + config.getId() + " created successfully");

        // Read
        Mono<BusinessFormConfig> retrievedConfig = service.findById(config.getId());
        retrievedConfig.subscribe(BusinessFormConfig -> {
            System.out.println("Retrieved Config based on document Id: " + BusinessFormConfig.toString());
        });

        Flux<BusinessFormConfig> retrievedConfigByName = service.findByFormName(config.getFormName());
        retrievedConfigByName.subscribe(BusinessFormConfig -> {
            System.out.println("Retrieved Config based on FormName - Form Name: " + BusinessFormConfig.getFormName());
        });

        // Construct the updates
        Map<String, Object> updates = new HashMap<>();
        // Handle updates within 'linkTables' (add new entries to array of linkTables)
        Map<String, Map<String, Object>> newLinkTables = new HashMap<>();
        Map<String, Object> tableDetails = new HashMap<>();
        tableDetails.put("column1", "value1");
        tableDetails.put("column2", "value2");
        newLinkTables.put("Form_new", tableDetails);
        updates.put("linkTables", newLinkTables);
        service.updateList(config.getId(), updates);
        System.out.println("Updated Config: add a new linkTable entry to an array of linkTables");

        // Handle updates within 'columns' (replace entire array of columns)
        List<Map<String, Object>> newColumns = new ArrayList<>();
        Map<String, Object> columnDetails = new HashMap<>();
        columnDetails.put("columnName", "column1");
        columnDetails.put("columnType", "String");
        newColumns.add(columnDetails);
        updates.put("columns", newColumns);
        service.updateList(config.getId(), updates);
        System.out.println("Updated Config: replaced whole columns array");

        // Handle updates within 'columns' (update a specific column)
        BusinessFormConfig retrievedNewConfig = service.findById(config.getId()).block();
        if (retrievedConfig != null) {
            List<Map<String, Object>> updatedColumns = retrievedNewConfig.getColumns();
            for (Map<String, Object> column : updatedColumns) {
                if (column.containsKey("columnName")) {
                    column.put("columnName", "column_new"); // replace "column1" with the actual new value
                }
            }
            retrievedNewConfig.setColumns(updatedColumns);
            service.create(retrievedNewConfig);
            System.out.println("Updated Config: updated a specific column within columns array");
        }

        // Delete
        // if (retrievedConfig != null) {
        //     service.deleteById(config.getId());
        // }
    }
}
