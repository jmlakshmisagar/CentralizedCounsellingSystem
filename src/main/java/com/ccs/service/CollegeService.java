package com.ccs.service;

import com.ccs.dto.request.CollegeRequest;
import com.ccs.dto.response.CollegeResponse;
import com.ccs.entity.College;
import com.ccs.mapper.CollegeMapper;
import com.ccs.repository.CollegeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollegeService {

    private final CollegeRepository repository;
    private final CollegeMapper mapper;

    public CollegeResponse create(CollegeRequest request) {

        if (repository.existsByCollegeCode(request.getCollegeCode())) {
            throw new IllegalArgumentException(
                    "College already exists with code : " + request.getCollegeCode()
            );
        }

        College college = mapper.toEntity(request);

        College saved = repository.save(college);

        return mapper.toResponse(saved);
    }

    public List<CollegeResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CollegeResponse getById(Long id) {

        College college = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("College not found"));

        return mapper.toResponse(college);
    }

    public CollegeResponse update(Long id, CollegeRequest request) {

        College college = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("College not found"));

        mapper.updateEntity(request, college);

        College updated = repository.save(college);

        return mapper.toResponse(updated);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("College not found");
        }

        repository.deleteById(id);
    }

}