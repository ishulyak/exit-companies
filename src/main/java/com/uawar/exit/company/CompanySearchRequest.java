package com.uawar.exit.company;

import lombok.Value;

import java.time.Instant;
import java.util.List;

@Value
public class CompanySearchRequest {
    List<String> company;
    List<String> country;
    List<String> businessSector;
    List<Instant> date;
}
