package com.uawar.exit.company;

import com.sybit.airtable.exception.AirtableException;
import com.uawar.exit.airtable.AirtableSynchronizeService;
import com.uawar.exit.dto.CompanyResponseDto;
import lombok.AllArgsConstructor;
import org.apache.http.client.HttpResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AirtableCompanyController {
    private final AirtableSynchronizeService airtableSynchronizeService;

    @GetMapping("/sync")
    public List<CompanyResponseDto> sync() throws AirtableException, HttpResponseException {
        return airtableSynchronizeService.sync();
    }
}
