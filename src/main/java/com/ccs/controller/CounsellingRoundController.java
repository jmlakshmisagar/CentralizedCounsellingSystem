package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<CounsellingRoundResponse>> create(
            @Valid @RequestBody CounsellingRoundRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Counselling round created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CounsellingRoundResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling rounds fetched successfully",
                        service.getAll()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CounsellingRoundResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling round fetched successfully",
                        service.getById(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CounsellingRoundResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody CounsellingRoundRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling round updated successfully",
                        service.update(id, request)
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling round deleted successfully"
                ));
    }
}