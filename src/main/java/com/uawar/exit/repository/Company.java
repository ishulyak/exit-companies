package com.uawar.exit.repository;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Document(collection = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
@ToString(callSuper = true)
public class Company extends BaseAuditingEntity {
    @Indexed
    @Field("announcementDate")
    Instant announcementDate;
    @Indexed
    @Field("businessSector")
    String businessSector;
    @Indexed
    @Field("company")
    String company;
    @Field("details")
    String details;
    @Indexed
    @Field("country")
    String country;
    @Field("linkToStatementSource")
    String linkToStatementSource;
    @Field("numberOfEmployees")
    Integer numberOfEmployees;
    @Field("numberOfStores")
    Integer numberOfStores;
    @Field("officialStatementOnWebsite")
    String officialStatementOnWebsite;
    @Field("reviewed")
    String reviewed;
    @Field("salesFromRussia")
    String salesFromRussia;
    @Indexed
    @Field("status")
    String status;
    @Field("strengthOfLanguage")
    String strengthOfLanguage;
    @Field("topPriority")
    String topPriority;
    @Field("wordingsFromStatement")
    String wordingsFromStatement;
}
