package com.uawar.exit.airtable;

import com.uawar.exit.repository.Company;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class)
public interface CompanyUpdateMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(Company dto, @MappingTarget Company entity);
}
