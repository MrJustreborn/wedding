package de.mjrb.wedding;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class HochzeitConfiguration extends Configuration {
//    @Valid
//    @NotNull
    @JsonProperty("database")
    private final DataSourceFactory database = new DataSourceFactory();
    
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
