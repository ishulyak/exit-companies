
package com.uawar.exit.airtable;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AirtableCompany {
    @SerializedName("Announcement Date")
    private String announcementDate;
    @SerializedName("Business Sector")
    private String businessSector;
    @SerializedName("Company")
    private String company;
    @SerializedName("Key actions")
    private String details;
    @SerializedName("HQ Country")
    private String country;
    @SerializedName("Link to Statement/Source")
    private String linkToStatementSource;
    @SerializedName("Number of employees")
    private String numberOfEmployees;
    @SerializedName("Number of stores")
    private String numberOfStores;
    @SerializedName("Official statement on Website?")
    private String officialStatementOnWebsite;
    @SerializedName("Reviewed?")
    private String reviewed;
    @SerializedName("Sales % from Russia")
    private String salesFromRussia;
    @SerializedName("Status")
    private String status;
    @SerializedName("Strength of language")
    private String strengthOfLanguage;
    @SerializedName("Top priority")
    private String topPriority;
    @SerializedName("Wordings from statement")
    private String wordingsFromStatement;
}
