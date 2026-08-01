package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CandidatePreferenceStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "candidate_preference",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "candidate_id",
                                "preference_order"
                        }
                )
        }
)
public class CandidatePreference extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "preference_order", nullable = false)
    private Integer preferenceOrder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidatePreferenceStatus status;

}