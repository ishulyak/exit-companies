package com.uawar.exit.mapper;

import com.uawar.exit.airtable.AirtableCompany;
import com.uawar.exit.repository.Company;
import com.uawar.exit.util.Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class, imports = {Utils.class})
public interface AirtableCompanyMapper extends BaseMapper<AirtableCompany, AirtableCompany, Company> {

    @Override
    @Mapping(expression = "java(Utils.parseDate(airtableCompany.getAnnouncementDate()))", target = "announcementDate")
    Company toEntity(AirtableCompany airtableCompany);

    @Override
    @Mappings({
            @Mapping(expression = "java(Utils.parseDate(airtableCompany.getAnnouncementDate()))", target = "announcementDate"),
//            @Mapping(source = "airtableCompany.hQCountry", target = "hQCountry")
    })
    Company toEntity(AirtableCompany airtableCompany, String id);

    @Override
    @Mapping(expression = "java(company.getAnnouncementDate().toString())", target = "announcementDate")
    AirtableCompany toDto(Company company);

}
