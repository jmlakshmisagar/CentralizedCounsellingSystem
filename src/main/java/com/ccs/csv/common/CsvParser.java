package com.ccs.csv.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CsvParser<T> {

    List<T> parse(MultipartFile file) throws IOException;

}