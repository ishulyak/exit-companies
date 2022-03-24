package com.uawar.exit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.Instant;

@Value
@Jacksonized
@Builder
public class CompanyResponseDto {
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy",timezone = "UTC")
    @JsonProperty("announcementDate")
    Instant announcementDate;
    @JsonProperty("businessSector")
    String businessSector;
    @JsonProperty("company")
    String company;
    @JsonProperty("details")
    String details;
    @JsonProperty("country")
    String country;
    @JsonProperty("linkToStatementSource")
    Integer linkToStatementSource;
    @JsonProperty("numberOfEmployees")
    Integer numberOfEmployees;
    @JsonProperty("numberOfStores")
    String numberOfStores;
    @JsonProperty("officialStatementOnWebsite")
    String officialStatementOnWebsite;
    @JsonProperty("reviewed")
    String reviewed;
    @JsonProperty("salesFromRussia")
    String salesFromRussia;
    @JsonProperty("status")
    String status;
    @JsonProperty("strengthOfLanguage")
    String strengthOfLanguage;
    @JsonProperty("topPriority")
    String topPriority;
    @JsonProperty("wordingsFromStatement")
    String wordingsFromStatement;
}
