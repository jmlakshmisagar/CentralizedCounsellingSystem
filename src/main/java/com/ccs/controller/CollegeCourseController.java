package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
import com.ccs.dto.request.CollegeCourseRequest;
import com.ccs.dto.response.CollegeCourseResponse;
import com.ccs.service.CollegeCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/college-courses")
@RequiredArgsConstructor
public class CollegeCourseController {

    private final CollegeCourseService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CollegeCourseResponse>> create(
            @Valid @RequestBody CollegeCourseRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "College course created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CollegeCourseResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "College courses fetched successfully",
                        service.getAll()
                )
        );
    }
}