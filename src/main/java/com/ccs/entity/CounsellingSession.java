package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.SessionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "counselling_session",
        indexes = {
                @Index(
                        name = "idx_session_year",
                        columnList = "session_year"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CounsellingSession extends BaseEntity {

    @Column(name = "session_year", nullable = false, unique = true)
    private Integer sessionYear;

    @Column(name = "session_name", nullable = false, length = 100)
    private String sessionName;

    @Column(name = "start_date", nullable = false)
    private java.time.LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private java.time.LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionStatus status;

}