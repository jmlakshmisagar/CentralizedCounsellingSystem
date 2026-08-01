package com.ccs.controller;

import com.ccs.csv.candidate.CandidateImportService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/import/candidate")
@RequiredArgsConstructor
public class CandidateImportController {

    private final CandidateImportService importService;

    @PostMapping
    public ResponseEntity<String> importCandidates(
            @RequestParam("file") MultipartFile file)
            throws IOException, CsvValidationException {

        importService.importCandidates(file);

        return ResponseEntity.ok(
                "Candidate CSV Imported Successfully");

    }

}