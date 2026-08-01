package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.PreferenceAction;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "preference_history",
        indexes = {
                @Index(
                        name = "idx_preference_history_candidate",
                        columnList = "candidate_id"
                ),
                @Index(
                        name = "idx_preference_history_round",
                        columnList = "round_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenceHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_course_id", nullable = false)
    private CollegeCourse collegeCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id", nullable = false)
    private CounsellingRound counsellingRound;

    @Column(nullable = false)
    private Integer priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PreferenceAction action;

    @Column(length = 100)
    private String changedBy;

}