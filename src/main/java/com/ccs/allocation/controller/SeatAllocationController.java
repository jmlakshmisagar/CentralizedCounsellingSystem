package com.ccs.allocation.controller;

import com.ccs.allocation.dto.AllocationSummary;
import com.ccs.allocation.service.SeatAllocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seat-allocation")
@RequiredArgsConstructor
public class SeatAllocationController {

    private final SeatAllocationService service;

    @PostMapping("/run/{roundId}")
    public AllocationSummary run(
            @PathVariable Long roundId) {

        return service.allocate(roundId);

    }

}