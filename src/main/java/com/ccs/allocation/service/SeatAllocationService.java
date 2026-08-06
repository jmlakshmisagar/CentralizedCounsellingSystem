package com.ccs.allocation.service;

import com.ccs.allocation.dto.AllocationSummary;

public interface SeatAllocationService {

    AllocationSummary allocate(Long counsellingRoundId);

}