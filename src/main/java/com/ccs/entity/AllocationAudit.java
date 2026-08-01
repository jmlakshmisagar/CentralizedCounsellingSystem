package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.AuditResult;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "allocation_audit",
        indexes = {
                @Index(
                        name = "idx_audit_candidate",
                        columnList = "candidate_id"
                ),
                @Index(
                        name = "idx_audit_round",
                        columnList = "round_id"
                ),
                @Index(
                        name = "idx_audit_college_course",
                        columnList = "college_course_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocationAudit extends BaseEntity {

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
    private Integer preferenceNumber;

    @Column(nullable = false)
    private Integer candidateRank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditResult result;

    @Column(length = 500)
    private String reason;

}