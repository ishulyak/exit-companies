package com.uawar.exit.data;

import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.repository.Company;
import org.apache.http.client.HttpResponseException;

import java.util.List;

public interface DataService {
    List<Company> fetch() throws AirtableException, HttpResponseException;
}
