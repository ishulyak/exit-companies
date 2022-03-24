package com.uawar.exit.airtable;

import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.dto.CompanyResponseDto;
import lombok.AllArgsConstructor;
import org.apache.http.client.HttpResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AirtableCompanyController {
    private final CompanySynchronizeService companySynchronizeService;

    @GetMapping("/sync")
    public List<CompanyResponseDto> sync() throws AirtableException, HttpResponseException {
        return companySynchronizeService.sync();
    }
}
