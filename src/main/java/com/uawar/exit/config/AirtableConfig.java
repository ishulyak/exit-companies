package com.uawar.exit.config;

import com.sybit.airtable.Airtable;
import com.sybit.airtable.Base;
import com.sybit.airtable.exception.AirtableException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirtableConfig {
    private final String apiKey;
    private final String baseKey;

    public AirtableConfig(@Value("${airtable.apiKey}") final String apiKey,
            @Value("${airtable.baseKey}") final String baseKey) {
        this.apiKey = apiKey;
        this.baseKey = baseKey;
    }

    @Bean
    public Airtable airtable() throws AirtableException {
        return new Airtable().configure(apiKey);
    }

    @Bean
    public Base base() throws AirtableException {
        return airtable().base(baseKey);
    }
}
