package com.ccs.entity;

import com.ccs.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "cutoff",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_cutoff",
                        columnNames = {
                                "college_course_id",
                                "reservation_category_id",
                                "round_id"
                        }
                )
        },
        indexes = {
                @Index(
                        name = "idx_cutoff_college_course",
                        columnList = "college_course_id"
                ),
                @Index(
                        name = "idx_cutoff_category",
                        columnList = "reservation_category_id"
                ),
                @Index(
                        name = "idx_cutoff_round",
                        columnList = "round_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cutoff extends BaseEntity {

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
    private Integer cutoffRank;

    @Column(nullable = false)
    private Integer cutoffMarks;

}