package com.ccs.csv.common;

public interface CsvValidator<T> {

    void validate(T dto);

}