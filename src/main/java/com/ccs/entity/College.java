package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CollegeStatus;
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
        name = "college",
        indexes = {
                @Index(name = "idx_college_code", columnList = "college_code")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class College extends BaseEntity {

    @Column(name = "college_code", nullable = false, unique = true, length = 20)
    private String collegeCode;

    @Column(name = "college_name", nullable = false, length = 250)
    private String collegeName;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String district;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CollegeStatus status;

}