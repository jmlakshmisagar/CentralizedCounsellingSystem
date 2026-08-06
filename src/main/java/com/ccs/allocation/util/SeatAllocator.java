package com.ccs.allocation.util;

import com.ccs.entity.Candidate;
import com.ccs.entity.CandidatePreference;
import com.ccs.entity.SeatMatrix;
import org.springframework.stereotype.Component;

@Component
public class SeatAllocator {

    public boolean canAllocate(
            Candidate candidate,
            CandidatePreference preference,
            SeatMatrix seatMatrix) {

        if (candidate == null) {
            return false;
        }

        if (preference == null) {
            return false;
        }

        if (seatMatrix == null) {
            return false;
        }

        return seatMatrix.getAvailableSeats() > 0;
    }

}