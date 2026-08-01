package com.ccs.mapper;

import com.ccs.dto.request.ReservationCategoryRequest;
import com.ccs.dto.response.ReservationCategoryResponse;
import com.ccs.entity.ReservationCategory;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ReservationCategoryMapper {

    ReservationCategory toEntity(ReservationCategoryRequest request);

    ReservationCategoryResponse toResponse(ReservationCategory entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(
            ReservationCategoryRequest request,
            @MappingTarget ReservationCategory entity
    );

}