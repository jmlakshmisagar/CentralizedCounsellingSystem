package com.ccs.service;

import com.ccs.dto.request.ReservationCategoryRequest;
import com.ccs.dto.response.ReservationCategoryResponse;
import com.ccs.entity.ReservationCategory;
import com.ccs.mapper.ReservationCategoryMapper;
import com.ccs.repository.ReservationCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationCategoryService {

    private final ReservationCategoryRepository repository;
    private final ReservationCategoryMapper mapper;

    public ReservationCategoryResponse create(ReservationCategoryRequest request) {

        if (repository.existsByCategoryCode(request.getCategoryCode())) {
            throw new IllegalArgumentException(
                    "Reservation Category already exists : " + request.getCategoryCode());
        }

        ReservationCategory category = mapper.toEntity(request);

        return mapper.toResponse(repository.save(category));
    }

    public List<ReservationCategoryResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public ReservationCategoryResponse getById(Long id) {

        ReservationCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Reservation Category not found"));

        return mapper.toResponse(category);
    }

    public ReservationCategoryResponse update(
            Long id,
            ReservationCategoryRequest request) {

        ReservationCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Reservation Category not found"));

        mapper.updateEntity(request, category);

        return mapper.toResponse(repository.save(category));
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Reservation Category not found");
        }

        repository.deleteById(id);
    }

}