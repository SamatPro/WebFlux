package ru.itis.flux.clients;

import reactor.core.publisher.Flux;
import ru.itis.flux.entries.DataSample;

public interface ApiFreeDataClient {
    Flux<DataSample> getAll();
}
