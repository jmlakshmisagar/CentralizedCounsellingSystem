package com.ccs.repository;

import com.ccs.entity.ReservationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationCategoryRepository extends JpaRepository<ReservationCategory, Long> {

    Optional<ReservationCategory> findByCategoryCode(String categoryCode);

    boolean existsByCategoryCode(String categoryCode);

}