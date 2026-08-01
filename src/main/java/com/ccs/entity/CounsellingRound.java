package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.RoundStatus;
import com.ccs.enums.RoundType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "counselling_round",
        indexes = {
                @Index(name = "idx_round_number", columnList = "round_number")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CounsellingRound extends BaseEntity {

    @Column(name = "round_number", nullable = false)
    private Integer roundNumber;

    @Column(name = "round_name", nullable = false, length = 50)
    private String roundName;

    @Enumerated(EnumType.STRING)
    @Column(name = "round_type", nullable = false)
    private RoundType roundType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private CounsellingSession counsellingSession;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoundStatus status;

}