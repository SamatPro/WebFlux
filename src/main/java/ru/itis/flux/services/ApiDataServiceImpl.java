package ru.itis.flux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.flux.clients.ApiFreeDataClient;
import ru.itis.flux.entries.DataSample;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiDataServiceImpl implements ApiDataService {

    @Autowired
    private List<ApiFreeDataClient> clients;

    @Override
    public Flux<DataSample> getAll() {
        List<Flux<DataSample>> fluxes =  clients.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(fluxes);
    }

    private Flux<DataSample> getAll(ApiFreeDataClient client) {
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}
