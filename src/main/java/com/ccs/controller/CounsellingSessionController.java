package com.ccs.controller;

import com.ccs.common.response.ApiResponse;
import com.ccs.dto.request.CounsellingSessionRequest;
import com.ccs.dto.response.CounsellingSessionResponse;
import com.ccs.service.CounsellingSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counselling-sessions")
@RequiredArgsConstructor
public class CounsellingSessionController {

    private final CounsellingSessionService service;

    @PostMapping
    public ResponseEntity<ApiResponse<CounsellingSessionResponse>> create(
            @Valid @RequestBody CounsellingSessionRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Counselling session created successfully",
                        service.create(request)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CounsellingSessionResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling sessions fetched successfully",
                        service.getAll()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CounsellingSessionResponse>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Counselling session fetched successfully",
                        service.getById(id)
                )
        );
    }

}