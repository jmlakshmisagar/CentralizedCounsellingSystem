package com.ccs.allocation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllocationSummary {

    private Long counsellingRoundId;

    private String roundName;

    @Builder.Default
    private Integer totalCandidates = 0;

    @Builder.Default
    private Integer allocatedCandidates = 0;

    @Builder.Default
    private Integer notAllocatedCandidates = 0;

    @Builder.Default
    private LocalDateTime completedAt = LocalDateTime.now();

    @Builder.Default
    private List<AllocationResult> allocations = new ArrayList<>();

}