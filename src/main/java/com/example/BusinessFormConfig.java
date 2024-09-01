package com.example;

// MongoDB imports
// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

// Firestore imports
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;

import java.util.List;
import java.util.Map;

@Document(collectionName = "testCollection")
public class BusinessFormConfig {

    @DocumentId
    private String id;
    private String formName;
    private String formCode;
    private String linkForm;
    private String linkFormPath;
    private Map<String, Map<String, Object>> linkTables;
    private String tableName;
    private String usage;
    private String status;
    private List<Map<String, Object>> columns;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getLinkForm() {
        return linkForm;
    }

    public void setLinkForm(String linkForm) {
        this.linkForm = linkForm;
    }

    public String getLinkFormPath() {
        return linkFormPath;
    }

    public void setLinkFormPath(String linkFormPath) {
        this.linkFormPath = linkFormPath;
    }

    public Map<String, Map<String, Object>> getLinkTables() {
        return linkTables;
    }

    public void setLinkTables(Map<String, Map<String, Object>> linkTables) {
        this.linkTables = linkTables;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Map<String, Object>> getColumns() {
        return columns;
    }

    public void setColumns(List<Map<String, Object>> columns) {
        this.columns = columns;
    }

}