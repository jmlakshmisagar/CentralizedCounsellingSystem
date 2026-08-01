package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.PreferenceStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "candidate_preference",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_candidate_priority",
                        columnNames = {
                                "candidate_id",
                                "priority"
                        }
                ),
                @UniqueConstraint(
                        name = "uk_candidate_college_course",
                        columnNames = {
                                "candidate_id",
                                "college_course_id"
                        }
                )
        },
        indexes = {
                @Index(
                        name = "idx_candidate_preference_candidate",
                        columnList = "candidate_id"
                ),
                @Index(
                        name = "idx_candidate_preference_college_course",
                        columnList = "college_course_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidatePreference extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_course_id", nullable = false)
    private CollegeCourse collegeCourse;

    @Column(nullable = false)
    private Integer priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PreferenceStatus status;

}