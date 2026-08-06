package com.ccs.mapper;

import com.ccs.dto.request.CounsellingRoundRequest;
import com.ccs.dto.response.CounsellingRoundResponse;
import com.ccs.entity.CounsellingRound;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CounsellingRoundMapper {

    @Mapping(source = "counsellingSession.id", target = "counsellingSessionId")
    @Mapping(source = "counsellingSession.sessionName", target = "sessionName")
    CounsellingRoundResponse toResponse(CounsellingRound entity);

    @Mapping(target = "counsellingSession", ignore = true)
    CounsellingRound toEntity(CounsellingRoundRequest request);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    @Mapping(target = "counsellingSession", ignore = true)
    void updateEntity(
            CounsellingRoundRequest request,
            @MappingTarget CounsellingRound entity
    );

}