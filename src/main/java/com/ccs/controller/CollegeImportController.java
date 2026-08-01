package com.ccs.controller;

import com.ccs.csv.college.CollegeImportService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/import/college")
@RequiredArgsConstructor
public class CollegeImportController {

    private final CollegeImportService importService;

    @PostMapping
    public ResponseEntity<String> importCollege(
            @RequestParam("file") MultipartFile file)
            throws IOException, CsvValidationException {

        importService.importColleges(file);

        return ResponseEntity.ok("College CSV Imported Successfully");
    }

}