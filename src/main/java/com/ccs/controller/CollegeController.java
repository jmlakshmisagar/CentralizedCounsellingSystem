package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
import com.ccs.dto.request.CollegeRequest;
import com.ccs.dto.response.CollegeResponse;
import com.ccs.service.CollegeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CollegeResponse>> create(
            @Valid @RequestBody CollegeRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "College created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CollegeResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Colleges fetched successfully",
                        service.getAll()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CollegeResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "College fetched successfully",
                        service.getById(id)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CollegeResponse>> update(
            @PathVariable Long id,
            @Valid @RequestBody CollegeRequest request) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "College updated successfully",
                        service.update(id, request)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok(
                ApiResponse.success("College deleted successfully")
        );
    }
}