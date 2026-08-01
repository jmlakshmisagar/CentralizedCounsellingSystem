package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CandidateStatus;
import com.ccs.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "candidate",
        indexes = {
                @Index(name = "idx_candidate_application_number", columnList = "application_number"),
                @Index(name = "idx_candidate_rank", columnList = "rank")
        }
)
public class Candidate extends BaseEntity {

    @Column(name = "application_number", nullable = false, unique = true)
    private Long applicationNumber;

    @Column(nullable = false, length = 150)
    private String candidateName;

    @Column(nullable = false)
    private Integer rank;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_category_id", nullable = false)
    private ReservationCategory reservationCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false, length = 15)
    private String mobileNumber;

    @Column(nullable = false, length = 150)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidateStatus status;

}