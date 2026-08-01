package com.ccs.repository;

import com.ccs.entity.ImportJob;
import com.ccs.enums.ImportStatus;
import com.ccs.enums.ImportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImportJobRepository
        extends JpaRepository<ImportJob, Long> {

    List<ImportJob> findByStatus(ImportStatus status);

    List<ImportJob> findByImportType(ImportType importType);

}