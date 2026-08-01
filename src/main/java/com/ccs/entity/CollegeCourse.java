package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.CollegeCourseStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "college_course",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_college_course",
                        columnNames = {
                                "college_id",
                                "course_id",
                                "session_id"
                        }
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollegeCourse extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private CounsellingSession counsellingSession;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CollegeCourseStatus status;

}