package com.ccs.controller;

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
    public ResponseEntity<CandidateResponse> create(
            @Valid @RequestBody CandidateRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

}