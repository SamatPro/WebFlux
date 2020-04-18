package ru.itis.flux.entries;

import lombok.Data;

import java.util.List;

@Data
public class ApiDataResponse {
    private List<ApiDataRecord> data;
}
