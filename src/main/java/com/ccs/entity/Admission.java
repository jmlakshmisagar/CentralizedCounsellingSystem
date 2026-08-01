package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.AdmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(
        name = "admission",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_admission_allocation",
                        columnNames = "seat_allocation_id"
                )
        },
        indexes = {
                @Index(
                        name = "idx_admission_candidate",
                        columnList = "candidate_id"
                ),
                @Index(
                        name = "idx_admission_status",
                        columnList = "status"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Admission extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_allocation_id", nullable = false)
    private SeatAllocation seatAllocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "document_verified")
    private Boolean documentVerified;

    @Column(name = "fee_paid")
    private Boolean feePaid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdmissionStatus status;

}