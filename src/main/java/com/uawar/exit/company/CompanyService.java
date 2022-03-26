package com.uawar.exit.company;

import com.uawar.exit.dto.CompanyResponseDto;
import com.uawar.exit.dto.DateCompaniesResponseDto;
import com.uawar.exit.mapper.CompanyMapper;
import com.uawar.exit.repository.Company;
import com.uawar.exit.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {
    private final MongoTemplate mongoTemplate;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public List<DateCompaniesResponseDto> findAll(final CompanySearchRequest companySearchRequest) {
        Query query = new Query();

        if (CollectionUtils.isNotEmpty(companySearchRequest.getBusinessSector())) {
            query.addCriteria(Criteria.where("businessSector").in(companySearchRequest.getBusinessSector()));
        }
        if (CollectionUtils.isNotEmpty(companySearchRequest.getCompany())) {
            query.addCriteria(Criteria.where("company").in(companySearchRequest.getCompany()));
        }
        if (CollectionUtils.isNotEmpty(companySearchRequest.getCountry())) {
            query.addCriteria(Criteria.where("country").in(companySearchRequest.getCountry()));
        }

        final List<Company> companies = mongoTemplate.find(query, Company.class);

        final List<CompanyResponseDto> companyResponseDtos = companyMapper.toDto(companies);

        final Map<Instant, List<CompanyResponseDto>> dateToCompaniesMap = companyResponseDtos.stream()
                .filter(companyResponseDto -> companyResponseDto.getAnnouncementDate() != null)
                .collect(Collectors.groupingBy(CompanyResponseDto::getAnnouncementDate));

        dateToCompaniesMap.put(null, companyResponseDtos.stream()
                .filter(companyResponseDto -> companyResponseDto.getAnnouncementDate() == null)
                .collect(Collectors.toList()));

        return dateToCompaniesMap.entrySet().stream()
                .map(e -> DateCompaniesResponseDto.builder()
                        .announcementDate(e.getKey())
                        .companies(e.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    public List<String> getAllBusinessSectors() {
        return companyRepository.findAll().stream()
                .map(Company::getBusinessSector)
                .distinct().collect(Collectors.toList());
    }

    public List<String> getAllCountries() {
        return companyRepository.findAll().stream()
                .map(Company::getCountry)
                .distinct().collect(Collectors.toList());
    }
}
