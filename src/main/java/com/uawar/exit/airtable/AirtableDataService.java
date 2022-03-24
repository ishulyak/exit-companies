package com.uawar.exit.airtable;

import com.sybit.airtable.Base;
import com.sybit.airtable.Table;
import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.data.DataService;
import com.uawar.exit.mapper.AirtableCompanyMapper;
import com.uawar.exit.repository.Company;
import lombok.AllArgsConstructor;
import org.apache.http.client.HttpResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirtableDataService implements DataService {
    private final Base base;
    private final AirtableCompanyMapper airtableCompanyMapper;

    @Override
    public List<Company> fetch() throws AirtableException, HttpResponseException {
        String tableName = "Businesses Out of Russia - Full Database";
        Table<AirtableCompany> table = base.table(tableName, AirtableCompany.class);

        final List<AirtableCompany> airtableCompanies = table.select();

        return airtableCompanyMapper.toEntity(airtableCompanies);
    }
}
