package com.uawar.exit.mapper;

import com.uawar.exit.dto.CompanyRequestDto;
import com.uawar.exit.dto.CompanyResponseDto;
import com.uawar.exit.repository.Company;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class)
public interface CompanyMapper extends BaseMapper<CompanyRequestDto, CompanyResponseDto, Company> {

}
