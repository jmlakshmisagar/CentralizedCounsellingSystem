package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
import com.ccs.dto.request.ReservationCategoryRequest;
import com.ccs.dto.response.ReservationCategoryResponse;
import com.ccs.service.ReservationCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation-categories")
@RequiredArgsConstructor
public class ReservationCategoryController {

    private final ReservationCategoryService service;

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationCategoryResponse>> create(
            @Valid @RequestBody ReservationCategoryRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Reservation category created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReservationCategoryResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Reservation categories fetched successfully",
                        service.getAll()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationCategoryResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Reservation category fetched successfully",
                        service.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ReservationCategoryResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody ReservationCategoryRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Reservation category updated successfully",
                        service.update(id, request)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                ApiResponse.success("Reservation category deleted successfully")
        );
    }
}