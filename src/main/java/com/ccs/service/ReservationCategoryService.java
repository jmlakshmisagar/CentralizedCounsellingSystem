package com.ccs.service;

import com.ccs.dto.request.ReservationCategoryRequest;
import com.ccs.dto.response.ReservationCategoryResponse;
import com.ccs.entity.ReservationCategory;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.ReservationCategoryMapper;
import com.ccs.repository.ReservationCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationCategoryService {

    private final ReservationCategoryRepository repository;
    private final ReservationCategoryMapper mapper;

    @Transactional
    public ReservationCategoryResponse create(ReservationCategoryRequest request) {

        log.info("Creating reservation category {}", request.getCategoryCode());

        if (repository.existsByCategoryCode(request.getCategoryCode())) {
            throw new DuplicateResourceException(
                    "Reservation category already exists : " + request.getCategoryCode());
        }

        ReservationCategory category = mapper.toEntity(request);

        ReservationCategory saved = repository.save(category);

        log.info("Reservation category created successfully {}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<ReservationCategoryResponse> getAll() {

        log.info("Fetching all reservation categories");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ReservationCategoryResponse getById(Long id) {

        log.info("Fetching reservation category {}", id);

        ReservationCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation category not found : " + id));

        return mapper.toResponse(category);
    }

    @Transactional
    public ReservationCategoryResponse update(
            Long id,
            ReservationCategoryRequest request) {

        log.info("Updating reservation category {}", id);

        ReservationCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation category not found : " + id));

        mapper.updateEntity(request, category);

        ReservationCategory updated = repository.save(category);

        log.info("Reservation category updated successfully {}", id);

        return mapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {

        log.info("Deleting reservation category {}", id);

        ReservationCategory category = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation category not found : " + id));

        repository.delete(category);

        log.info("Reservation category deleted successfully {}", id);
    }
}