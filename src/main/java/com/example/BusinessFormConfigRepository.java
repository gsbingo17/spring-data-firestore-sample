package com.example;

// MongoDB imports
// import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

// Firestore imports
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
// public interface BusinessFormConfigRepository extends ReactiveMongoRepository<BusinessFormConfig, String> {
public interface BusinessFormConfigRepository extends FirestoreReactiveRepository<BusinessFormConfig> {
    Flux<BusinessFormConfig> findByFormName(String formName);
    Flux<BusinessFormConfig> findByFormCode(String formCode);
    Flux<BusinessFormConfig> findByFormNameAndFormCode(String formName, String formCode);

}
