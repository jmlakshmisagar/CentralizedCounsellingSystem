package com.ccs.entity;

import com.ccs.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "seat_matrix",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_seat_matrix",
                        columnNames = {
                                "college_course_id",
                                "reservation_category_id",
                                "round_id"
                        }
                )
        },
        indexes = {
                @Index(
                        name = "idx_seat_matrix_college_course",
                        columnList = "college_course_id"
                ),
                @Index(
                        name = "idx_seat_matrix_category",
                        columnList = "reservation_category_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatMatrix extends BaseEntity {

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
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Integer allocatedSeats;

}