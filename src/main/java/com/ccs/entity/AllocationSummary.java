package com.ccs.entity;

import com.ccs.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "allocation_summary",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_allocation_summary_round",
                        columnNames = "round_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocationSummary extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id", nullable = false)
    private CounsellingRound counsellingRound;

    @Column(nullable = false)
    private Integer totalCandidates;

    @Column(nullable = false)
    private Integer allocatedCandidates;

    @Column(nullable = false)
    private Integer unallocatedCandidates;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer allocatedSeats;

    @Column(nullable = false)
    private Integer remainingSeats;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal allocationPercentage;

}