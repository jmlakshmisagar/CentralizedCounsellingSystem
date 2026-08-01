package com.ccs.repository;

import com.ccs.entity.SeatMatrixHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatMatrixHistoryRepository
        extends JpaRepository<SeatMatrixHistory, Long> {

    List<SeatMatrixHistory> findByCounsellingRoundId(Long counsellingRoundId);

    List<SeatMatrixHistory> findBySeatMatrixId(Long seatMatrixId);

}