package com.ccs.controller;

import com.ccs.dto.request.CandidatePreferenceRequest;
import com.ccs.dto.response.CandidatePreferenceResponse;
import com.ccs.service.CandidatePreferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate-preferences")
@RequiredArgsConstructor
public class CandidatePreferenceController {

    private final CandidatePreferenceService service;

    @PostMapping
    public ResponseEntity<CandidatePreferenceResponse> create(
            @Valid @RequestBody CandidatePreferenceRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CandidatePreferenceResponse>> getAll() {

        return ResponseEntity.ok(
                service.getAll()
        );
    }

}