package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.ReservationCategoryStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "reservation_category",
        indexes = {
                @Index(
                        name = "idx_reservation_category_code",
                        columnList = "category_code"
                )
        }
)
public class ReservationCategory extends BaseEntity {

    @Column(name = "category_code", nullable = false, unique = true, length = 10)
    private String categoryCode;

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationCategoryStatus status;

}