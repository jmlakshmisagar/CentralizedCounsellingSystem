package com.ccs.service;

import com.ccs.dto.request.CounsellingRoundRequest;
import com.ccs.dto.response.CounsellingRoundResponse;
import com.ccs.entity.CounsellingRound;
import com.ccs.entity.CounsellingSession;
import com.ccs.mapper.CounsellingRoundMapper;
import com.ccs.repository.CounsellingRoundRepository;
import com.ccs.repository.CounsellingSessionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounsellingRoundService {

    private final CounsellingRoundRepository repository;
    private final CounsellingSessionRepository sessionRepository;
    private final CounsellingRoundMapper mapper;

    public CounsellingRoundResponse create(
            CounsellingRoundRequest request) {

        CounsellingSession session =
                sessionRepository.findById(request.getCounsellingSessionId())
                        .orElseThrow(() ->
                                new EntityNotFoundException("Session not found"));

        CounsellingRound round = CounsellingRound.builder()
                .counsellingSession(session)
                .roundNumber(request.getRoundNumber())
                .roundName(request.getRoundName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(request.getStatus())
                .build();

        return mapper.toResponse(repository.save(round));
    }

    public List<CounsellingRoundResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

}