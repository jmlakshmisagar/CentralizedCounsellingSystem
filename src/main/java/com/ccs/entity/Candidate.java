package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CandidateStatus;
import com.ccs.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "candidate",
        indexes = {
                @Index(name = "idx_candidate_cet", columnList = "cet_number"),
                @Index(name = "idx_candidate_rank", columnList = "candidate_rank")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate extends BaseEntity {

    @Column(name = "cet_number", nullable = false, unique = true)
    private Long cetNumber;

    @Column(name = "candidate_name", nullable = false, length = 150)
    private String candidateName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Double marks;

    @Column(name = "candidate_rank", nullable = false)
    private Integer rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_category_id", nullable = false)
    private ReservationCategory reservationCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private CounsellingSession counsellingSession;

    @Column(nullable = false)
    @Builder.Default
    private Boolean allotted = false;

    @Column(nullable = false)
    @Builder.Default
    private Boolean admitted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidateStatus status;

}