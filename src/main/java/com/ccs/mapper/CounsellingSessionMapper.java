package com.ccs.mapper;

import com.ccs.dto.request.CounsellingSessionRequest;
import com.ccs.dto.response.CounsellingSessionResponse;
import com.ccs.entity.CounsellingSession;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CounsellingSessionMapper {

    CounsellingSession toEntity(CounsellingSessionRequest request);

    CounsellingSessionResponse toResponse(CounsellingSession entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntity(
            CounsellingSessionRequest request,
            @MappingTarget CounsellingSession entity
    );

}