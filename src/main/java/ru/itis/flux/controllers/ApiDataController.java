package ru.itis.flux.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.itis.flux.entries.DataSample;
import ru.itis.flux.services.ApiDataService;

@RestController
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @RequestMapping(value = "/records",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE,
            method = RequestMethod.GET)
    public Flux<DataSample> getAll(){
        return apiDataService.getAll();
    }
}
