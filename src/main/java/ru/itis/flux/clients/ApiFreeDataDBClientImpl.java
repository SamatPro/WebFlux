package ru.itis.flux.clients;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.flux.entries.DataSample;
import ru.itis.flux.entries.PersonDBRecord;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Component
public class ApiFreeDataDBClientImpl implements ApiFreeDataClient {

    private ConnectionFactory connectionFactory;

    public ApiFreeDataDBClientImpl() {
        ConnectionFactoryOptions options = builder()
                .option(DRIVER, "postgresql")
                .option(PORT, 5432)
                .option(HOST, "localhost")
                .option(USER, "postgres")
                .option(PASSWORD, "postgres")
                .option(DATABASE, "fluxdata")
                .build();
        this.connectionFactory = ConnectionFactories.get(options);
    }

    @Override
    public Flux<DataSample> getAll() {
        DatabaseClient client = DatabaseClient.create(connectionFactory);
        return client.execute("select * from \"user\"").as(PersonDBRecord.class).fetch().all()
                .map(row -> DataSample.builder()
                        .id(row.getId())
                        .title(row.getName())
                        .url(row.getVkcom())
                        .from("DataBase")
                        .build()
        );
    }

}