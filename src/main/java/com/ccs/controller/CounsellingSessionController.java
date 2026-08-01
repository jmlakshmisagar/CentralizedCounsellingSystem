package com.ccs.controller;

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
    public ResponseEntity<CounsellingSessionResponse> create(
            @Valid @RequestBody CounsellingSessionRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CounsellingSessionResponse>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CounsellingSessionResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }

}