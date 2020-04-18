package ru.itis.flux.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.flux.entries.ApiDataRecord;
import ru.itis.flux.entries.DataSample;

import java.util.Arrays;

@Component
public class Covid19ApiClientWebClientImpl implements ApiFreeDataClient {

    private WebClient client;

    public Covid19ApiClientWebClientImpl(@Value("${weather.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .baseUrl(url)
                .build();
    }

    @Override
    public Flux<DataSample> getAll() {
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(ApiDataRecord[].class))
                .flatMapIterable(Arrays::asList)
                .map(record ->
                        DataSample.builder()
//                                .country(record.getCountryCode())
//                                .dateTime(record.getDate())
//                                .from("Covid19Api")
//                                .recovered(record.getRecovered())
                                .build());
    }
}
