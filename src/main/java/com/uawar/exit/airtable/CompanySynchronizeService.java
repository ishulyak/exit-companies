package com.uawar.exit.airtable;

import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.dto.CompanyResponseDto;
import com.uawar.exit.mapper.CompanyMapper;
import com.uawar.exit.repository.Company;
import com.uawar.exit.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.http.client.HttpResponseException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanySynchronizeService {
    private final AirtableDataService dataService;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final CompanyUpdateMapper companyUpdateMapper;

    public List<CompanyResponseDto> sync() throws AirtableException, HttpResponseException {
        final List<Company> newCompanies = dataService.fetch();
        final List<Company> currentCompanies = companyRepository.findAll();
        final List<Company> updatedCompanies = updateCompanies(currentCompanies, newCompanies);
        final List<Company> savedCompanies = companyRepository.saveAll(updatedCompanies);

        return companyMapper.toDto(savedCompanies);
    }

    private List<Company> updateCompanies(final List<Company> currentCompanies, final List<Company> newCompanies) {
        final Map<String, Company> companyMap = newCompanies.stream().collect(Collectors.toMap(Company::getCompany, Function.identity()));
        currentCompanies.forEach(currentCompany ->
                Optional.ofNullable(companyMap.get(currentCompany.getCompany()))
                        .ifPresent(newCompany -> {
                            updateCompany(currentCompany, newCompany);
                            companyMap.remove(newCompany.getCompany());
                        }));
        if (CollectionUtils.isNotEmpty(companyMap.values())) {
            currentCompanies.addAll(companyMap.values());
        }

        return currentCompanies;
    }

    private void updateCompany(final Company currentCompany, final Company newCompany) {
        companyUpdateMapper.update(newCompany, currentCompany);
    }
}
