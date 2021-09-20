package com.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockSymbol {

    private long id;

    private String name;

    @JsonProperty("database_code")
    private String databaseCode;

    private String datasetCode;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDatabaseCode() {
        return databaseCode;
    }

    public String getDatasetCode() {
        return datasetCode;
    }

}
