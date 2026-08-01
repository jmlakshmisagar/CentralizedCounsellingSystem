package com.ccs.csv.common;

import org.springframework.web.multipart.MultipartFile;

public interface CsvImportService {

    void importCsv(MultipartFile file) throws Exception;

}