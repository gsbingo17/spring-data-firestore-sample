# README.md

## Project Briefing

This is a Java project demonstrating how to switch from Open Source MongoDB to Firestore using Spring Boot, Maven, and Spring Data.

## Prerequisites

- Java 17 or higher
- Maven
- Google Cloud project with Firestore enabled
- Service account with permissions to access Firestore

## Project Overview

This project was initially set up with Open Source MongoDB as the database. However, it has been refactored to use Cloud Firestore instead. The purpose of this repository is to demonstrate how easy it is to make a few changes to the codebase to switch from MongoDB to Firestore, especially when using Spring Data. It also serves as a learning resource for developers looking to understand the code changes involved in such a transition.

## Handling Nested Fields

This project also demonstrates how to deal with nested fields in Firestore documents. Nested fields are fields that contain maps or arrays of data. They are a powerful feature of Firestore that allows you to structure your data in a way that best suits your application's needs.

### Adding a New Element to a Nested Field

Adding a new element to a nested field involves retrieving the document, updating the nested field with the new element, and then saving the document back to Firestore. This project provides examples of how to do this in a Spring Boot application.

### Updating an Element Based on a Condition

Updating an element in a nested field based on a condition involves retrieving the document, iterating over the elements in the nested field until the condition is met, updating the element, and then saving the document back to Firestore. This project provides examples of how to do this in a Spring Boot application.

### Replacing the Whole Nested Field

Replacing the whole nested field involves retrieving the document, replacing the nested field with a new set of data, and then saving the document back to Firestore. This project provides examples of how to do this in a Spring Boot application.

## Setup

1. Clone the repository to your local machine.
2. Navigate to the project directory and comment/uncomment a few specific code lines to explore the transition between the two databases.

## Configuration

The Firestore configuration is located in the `src/main/resources/application.properties` file. You need to set the following properties:

```properties
spring.cloud.gcp.firestore.project-id=your_project_id
spring.cloud.gcp.firestore.database-id=your_database_id
```

Replace `your_project_id` and `your_database_id` with your Firestore project ID and database ID respectively.

## Running the Application

You can run the application using Maven with the following command:

```bash
mvn spring-boot:run
```

## Using the Application

The application provides a repository to interact with Firestore. The repository provides methods to find `BusinessFormConfig` by form name, form code, or both.

## Switching from MongoDB to Firestore

The codebase was initially set up to use MongoDB. However, with a few changes, it was refactored to use Firestore. The changes mainly involved updating the repository interface and the `BusinessFormConfig` class. The MongoDB-specific annotations were replaced with Firestore-specific ones. The MongoDB configuration in the `application.properties` file was also replaced with Firestore configuration.

The use of Spring Data made this transition smoother. Spring Data provides a consistent programming model that supports a wide range of NoSQL databases, including MongoDB and Firestore. This means that the underlying database can be switched with minimal changes to the codebase.

This project serves as a practical guide for developers to learn and understand the code changes involved in switching from MongoDB to Firestore. By studying the codebase, developers can quickly grasp the necessary changes and apply them in their own projects. After going through the project, developers will understand how straightforward the process is.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](https://choosealicense.com/licenses/mit/)
