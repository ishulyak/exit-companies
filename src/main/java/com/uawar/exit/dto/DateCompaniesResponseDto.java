package com.uawar.exit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;
import java.util.List;

@Value
@Jacksonized
@Builder
public class DateCompaniesResponseDto {
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone = "UTC")
    @JsonProperty("announcementDate")
    Instant announcementDate;
    @JsonProperty("companies")
    List<CompanyResponseDto> companies;
}
