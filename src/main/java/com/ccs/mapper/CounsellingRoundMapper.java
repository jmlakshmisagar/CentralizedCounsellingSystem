package com.ccs.mapper;

import com.ccs.dto.response.CounsellingRoundResponse;
import com.ccs.entity.CounsellingRound;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CounsellingRoundMapper {

    @Mapping(source = "counsellingSession.id", target = "counsellingSessionId")
    @Mapping(source = "counsellingSession.sessionName", target = "sessionName")
    CounsellingRoundResponse toResponse(CounsellingRound entity);

}