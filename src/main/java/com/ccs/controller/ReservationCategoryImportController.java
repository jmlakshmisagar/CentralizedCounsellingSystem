package com.ccs.controller;

import com.ccs.csv.reservation.ReservationCategoryImportService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/import/reservation-category")
@RequiredArgsConstructor
public class ReservationCategoryImportController {

    private final ReservationCategoryImportService importService;

    @PostMapping
    public ResponseEntity<String> importReservationCategory(
            @RequestParam("file") MultipartFile file)
            throws IOException, CsvValidationException {

        importService.importCategories(file);

        return ResponseEntity.ok("Reservation Categories Imported Successfully");
    }

}