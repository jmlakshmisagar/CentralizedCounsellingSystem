package com.ccs.mapper;

import com.ccs.dto.request.CollegeRequest;
import com.ccs.dto.response.CollegeResponse;
import com.ccs.entity.College;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CollegeMapper {

    College toEntity(CollegeRequest request);

    CollegeResponse toResponse(College entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(
            CollegeRequest request,
            @MappingTarget College entity
    );

}