package com.example;

import java.util.*;

public class BusinessFormConfigGenerator {

  public BusinessFormConfig generate() {
    BusinessFormConfig config = new BusinessFormConfig();

    // Set the properties of the config object
    UUID uuid = UUID.randomUUID();
    config.setFormName(uuid.toString());
    config.setFormCode("Business");
    config.setLinkForm("Form_A");
    config.setLinkFormPath("/path/form");
    config.setTableName("TestTable");
    config.setUsage("");
    config.setStatus("enable");

    // Set the linkTables property
    Map<String, Map<String, Object>> linkTables = new HashMap<>();
    linkTables.put("Form_B", createTableDetails("66893e9b33sss86272ec66gg", "Form_B", "Business","formB", "enable", "enable", createColumns()));
    linkTables.put("Form_C", createTableDetails("668944eb33sss86272ec66ll", "Form_C", "Business", "FormA","enable", "enable", createColumns()));
    linkTables.put("Form_D", createTableDetails("", "Form_D", "Business", "Form_A",  "formD", "", createColumns()));
    config.setLinkTables(linkTables);

    // Set the columns property
    config.setColumns(createColumns());

    return config;
  }

  private Map<String, Object> createTableDetails(String oid, String formName, String formCode, String tableName, String usage, String status, List<Map<String, Object>> columns) {
    Map<String, Object> tableDetails = new HashMap<>();
    if (!oid.isEmpty()) {  // Check if oid is not empty
      tableDetails.put("_id", Collections.singletonMap("$oid", oid));
    }
    tableDetails.put("name", formName);
    tableDetails.put("code", formCode);
    tableDetails.put("tableName", tableName);
    tableDetails.put("usage", usage);
    tableDetails.put("status", status);
    tableDetails.put("columns", columns);
    return tableDetails;
  }
  // Create a list of columns
  private List<Map<String, Object>> createColumns() {
    List<Map<String, Object>> columns = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      Map<String, Object> columnDetails = new HashMap<>();
      columnDetails.put("a" + i, "a" + i);
      columnDetails.put("b" + i, "b" + i);
      columnDetails.put("c" + i, "c" + i);
      columnDetails.put("d" + i, "d" + i);
      columnDetails.put("e" + i, "e" + i);
      columnDetails.put("f" + i, 999 + i);
      columnDetails.put("g" + i, "g" + i);
      columnDetails.put("h" + i, "h" + i);
      columnDetails.put("i" + i, Arrays.asList("A" + i, "B" + i, "C" + i, "D" + i, "E" + i));
      columns.add(columnDetails);
    }
    return columns;
  }
}
