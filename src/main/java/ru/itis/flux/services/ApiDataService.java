package ru.itis.flux.services;

import reactor.core.publisher.Flux;
import ru.itis.flux.entries.DataSample;

public interface ApiDataService {
    Flux<DataSample> getAll();

}
