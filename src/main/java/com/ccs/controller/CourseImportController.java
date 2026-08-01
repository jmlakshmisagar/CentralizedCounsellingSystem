package com.ccs.controller;

import com.ccs.csv.service.CourseImportService;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/import/course")
@RequiredArgsConstructor
public class CourseImportController {

    private final CourseImportService courseImportService;

    @PostMapping
    public ResponseEntity<String> importCourse(
            @RequestParam("file") MultipartFile file)
            throws IOException, CsvValidationException {

        courseImportService.importCourses(file);

        return ResponseEntity.ok("Course CSV Imported Successfully");
    }

}