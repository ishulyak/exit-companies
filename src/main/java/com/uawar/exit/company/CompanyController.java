package com.uawar.exit.company;

import com.uawar.exit.dto.DateCompaniesResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/company")
    public List<DateCompaniesResponseDto> findAll(final CompanySearchRequest companySearchRequest) {
        return companyService.findAll(companySearchRequest);
    }

    @GetMapping("/business-sectors")
    public List<String> getAllBusinessSectors() {
        return companyService.getAllBusinessSectors();
    }

    @GetMapping("/countries")
    public List<String> getAllCountries() {
        return companyService.getAllCountries();
    }
}
