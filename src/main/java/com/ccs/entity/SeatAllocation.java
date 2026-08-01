package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.AllocationStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "seat_allocation",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_candidate_round",
                        columnNames = {
                                "candidate_id",
                                "round_id"
                        }
                )
        },
        indexes = {
                @Index(
                        name = "idx_allocation_candidate",
                        columnList = "candidate_id"
                ),
                @Index(
                        name = "idx_allocation_college_course",
                        columnList = "college_course_id"
                ),
                @Index(
                        name = "idx_allocation_round",
                        columnList = "round_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatAllocation extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_course_id", nullable = false)
    private CollegeCourse collegeCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_category_id", nullable = false)
    private ReservationCategory reservationCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id", nullable = false)
    private CounsellingRound counsellingRound;

    @Column(nullable = false)
    private Integer allottedPreference;

    @Column(nullable = false)
    private Integer allottedRank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllocationStatus status;

}