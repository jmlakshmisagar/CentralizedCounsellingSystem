package com.ccs.allocation.service;

import com.ccs.allocation.dto.AllocationSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatAllocationServiceImpl implements SeatAllocationService {

    @Override
    public AllocationSummary allocate(Long counsellingRoundId) {

        log.info("Starting seat allocation for round {}", counsellingRoundId);

        return AllocationSummary.builder()
                .counsellingRoundId(counsellingRoundId)
                .build();
    }

}