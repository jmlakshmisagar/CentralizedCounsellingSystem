package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.SeatMatrixSnapshotType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "seat_matrix_history",
        indexes = {
                @Index(
                        name = "idx_history_round",
                        columnList = "round_id"
                ),
                @Index(
                        name = "idx_history_seat_matrix",
                        columnList = "seat_matrix_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatMatrixHistory extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_matrix_id", nullable = false)
    private SeatMatrix seatMatrix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id", nullable = false)
    private CounsellingRound counsellingRound;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatMatrixSnapshotType snapshotType;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Integer allocatedSeats;

}