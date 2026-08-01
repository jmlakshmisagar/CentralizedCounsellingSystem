package com.ccs.repository;

import com.ccs.entity.ReservationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationCategoryRepository
        extends JpaRepository<ReservationCategory, Long> {

}