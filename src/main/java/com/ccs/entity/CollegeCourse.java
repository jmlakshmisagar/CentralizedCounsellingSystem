package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CollegeCourseStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "college_course",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "college_id",
                                "course_id"
                        }
                )
        }
)
public class CollegeCourse extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private Integer intake;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CollegeCourseStatus status;

}