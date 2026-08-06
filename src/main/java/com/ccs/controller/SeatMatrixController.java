package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<SeatMatrixResponse>> create(
            @Valid @RequestBody SeatMatrixRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Seat matrix created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SeatMatrixResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Seat matrix fetched successfully",
                        service.getAll()
                )
        );
    }
}