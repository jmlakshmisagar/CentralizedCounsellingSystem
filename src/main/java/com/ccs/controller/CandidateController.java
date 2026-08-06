package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
import com.ccs.dto.request.CandidateRequest;
import com.ccs.dto.response.CandidateResponse;
import com.ccs.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CandidateResponse>> create(
            @Valid @RequestBody CandidateRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Candidate created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CandidateResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Candidates fetched successfully",
                        service.getAll()
                )
        );
    }
}