package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.RoundStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "counselling_round",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "session_id",
                        "round_number"
                })
        }
)
public class CounsellingRound extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private CounsellingSession counsellingSession;

    @Column(nullable = false)
    private Integer roundNumber;

    @Column(nullable = false, length = 100)
    private String roundName;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoundStatus status;

}