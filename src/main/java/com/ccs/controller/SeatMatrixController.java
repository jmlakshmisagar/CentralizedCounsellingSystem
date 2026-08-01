package com.ccs.controller;

import com.ccs.dto.request.SeatMatrixRequest;
import com.ccs.dto.response.SeatMatrixResponse;
import com.ccs.service.SeatMatrixService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seat-matrix")
@RequiredArgsConstructor
public class SeatMatrixController {

    private final SeatMatrixService service;

    @PostMapping
    public ResponseEntity<SeatMatrixResponse> create(
            @Valid @RequestBody SeatMatrixRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<SeatMatrixResponse>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

}