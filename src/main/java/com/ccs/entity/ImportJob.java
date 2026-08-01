package com.ccs.entity;

import com.ccs.common.BaseEntity;
import com.ccs.enums.ImportStatus;
import com.ccs.enums.ImportType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "import_job",
        indexes = {
                @Index(
                        name = "idx_import_job_status",
                        columnList = "status"
                ),
                @Index(
                        name = "idx_import_job_type",
                        columnList = "importType"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImportJob extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImportType importType;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private Integer totalRecords;

    @Column(nullable = false)
    private Integer successRecords;

    @Column(nullable = false)
    private Integer failedRecords;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImportStatus status;

    @Column(length = 1000)
    private String errorMessage;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

}