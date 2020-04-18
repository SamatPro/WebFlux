package ru.itis.flux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.flux.entries.DataSample;
import ru.itis.flux.services.ApiDataService;

@RestController
@RequestMapping("api-data")
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @GetMapping(value = "/records", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<DataSample> getAll(){
        return apiDataService.getAll();
    }
}
