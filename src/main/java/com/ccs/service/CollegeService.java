package com.ccs.service;

import com.ccs.dto.request.CollegeRequest;
import com.ccs.dto.response.CollegeResponse;
import com.ccs.entity.College;
import com.ccs.exception.DuplicateResourceException;
import com.ccs.exception.ResourceNotFoundException;
import com.ccs.mapper.CollegeMapper;
import com.ccs.repository.CollegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CollegeService {

    private final CollegeRepository repository;
    private final CollegeMapper mapper;

    @Transactional
    public CollegeResponse create(CollegeRequest request) {

        log.info("Creating college with code {}", request.getCollegeCode());

        if (repository.existsByCollegeCode(request.getCollegeCode())) {
            throw new DuplicateResourceException(
                    "College already exists with code : " + request.getCollegeCode());
        }

        College college = mapper.toEntity(request);

        College saved = repository.save(college);

        log.info("College created successfully. Id={}", saved.getId());

        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CollegeResponse> getAll() {

        log.info("Fetching all colleges");

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CollegeResponse getById(Long id) {

        log.info("Fetching college {}", id);

        College college = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "College not found with id : " + id));

        return mapper.toResponse(college);
    }

    @Transactional
    public CollegeResponse update(Long id, CollegeRequest request) {

        log.info("Updating college {}", id);

        College college = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "College not found with id : " + id));

        mapper.updateEntity(request, college);

        College updated = repository.save(college);

        log.info("College updated successfully {}", id);

        return mapper.toResponse(updated);
    }

    @Transactional
    public void delete(Long id) {

        log.info("Deleting college {}", id);

        College college = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "College not found with id : " + id));

        repository.delete(college);

        log.info("College deleted successfully {}", id);
    }
}