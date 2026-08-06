package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.AdmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "admission",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "candidate_id",
                                "counselling_round_id"
                        }
                )
        },
        indexes = {
                @Index(name = "idx_admission_candidate", columnList = "candidate_id"),
                @Index(name = "idx_admission_round", columnList = "counselling_round_id")
        }
)
public class Admission extends BaseEntity {

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
    @JoinColumn(name = "counselling_round_id", nullable = false)
    private CounsellingRound counsellingRound;

    @Column(nullable = false)
    private Integer allottedRank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdmissionStatus status;

    @Column(nullable = false)
    private LocalDateTime allottedAt;

}