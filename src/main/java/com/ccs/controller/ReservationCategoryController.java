package com.ccs.controller;

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
    public ResponseEntity<ReservationCategoryResponse> create(
            @Valid @RequestBody ReservationCategoryRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ReservationCategoryResponse>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationCategoryResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationCategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ReservationCategoryRequest request) {

        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}