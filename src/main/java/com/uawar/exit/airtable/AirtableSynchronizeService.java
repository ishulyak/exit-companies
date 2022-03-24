package com.uawar.exit.airtable;

import com.sybit.airtable.Base;
import com.sybit.airtable.Table;
import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.dto.CompanyResponseDto;
import com.uawar.exit.mapper.AirtableCompanyMapper;
import com.uawar.exit.mapper.CompanyMapper;
import com.uawar.exit.repository.Company;
import com.uawar.exit.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.apache.http.client.HttpResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AirtableSynchronizeService {
    private final Base base;
    private final CompanyRepository companyRepository;
    private final AirtableCompanyMapper airtableCompanyMapper;
    private final CompanyMapper companyMapper;

    public List<CompanyResponseDto> sync() throws AirtableException, HttpResponseException {
        String tableName = "Businesses Out of Russia - Full Database";
        Table<AirtableCompany> table = base.table(tableName, AirtableCompany.class);

        final List<AirtableCompany> airtableCompanies = table.select();
        final List<Company> companies = airtableCompanyMapper.toEntity(airtableCompanies);
        companyRepository.deleteAll();
        final List<Company> savedCompanies = companyRepository.saveAll(companies);

        return companyMapper.toDto(savedCompanies);
    }
}
