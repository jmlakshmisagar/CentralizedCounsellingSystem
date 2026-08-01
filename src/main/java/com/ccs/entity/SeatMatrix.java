package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.SeatMatrixStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "seat_matrix",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "college_course_id",
                                "reservation_category_id"
                        }
                )
        }
)
public class SeatMatrix extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_course_id", nullable = false)
    private CollegeCourse collegeCourse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_category_id", nullable = false)
    private ReservationCategory reservationCategory;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer filledSeats;

    @Column(nullable = false)
    private Integer availableSeats;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatMatrixStatus status;

}