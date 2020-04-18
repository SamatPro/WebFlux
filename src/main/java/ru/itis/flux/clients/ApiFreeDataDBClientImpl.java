package ru.itis.flux.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.flux.entries.ApiDataResponse;
import ru.itis.flux.entries.DataSample;
import ru.itis.flux.services.PeopleService;

@Component
public class ApiFreeDataDBClientImpl implements ApiFreeDataClient {

    private WebClient client;

    @Autowired
    private PeopleService peopleService;


    public ApiFreeDataDBClientImpl() {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .build();
    }

    @Override
    public Flux<DataSample> getAll() {
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(ApiDataResponse.class))
                .flatMapIterable(ApiDataResponse::getData)
                .map(record ->
                        DataSample.builder()
//                                .country(record.getCountryCode())
//                                .dateTime(record.getDate())
//                                .from("TheVirusTracker")
//                                .recovered(Integer.parseInt(record.getRecovered()))
                                .build());
    }
}