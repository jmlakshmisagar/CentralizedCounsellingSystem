package com.ccs.controller;

import com.ccs.dto.request.CounsellingRoundRequest;
import com.ccs.dto.response.CounsellingRoundResponse;
import com.ccs.service.CounsellingRoundService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counselling-rounds")
@RequiredArgsConstructor
public class CounsellingRoundController {

    private final CounsellingRoundService service;

    @PostMapping
    public ResponseEntity<CounsellingRoundResponse> create(
            @Valid @RequestBody CounsellingRoundRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CounsellingRoundResponse>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

}