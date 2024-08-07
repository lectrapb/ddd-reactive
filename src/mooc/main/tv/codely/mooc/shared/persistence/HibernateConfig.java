package tv.codely.mooc.shared;


import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;

import java.time.Duration;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class HibernateConfig {

    @Bean
    public ConnectionFactory connectionFactoryWrite() {

        var options = ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "localhost")
                .option(PORT, 5432)
                .option(USER, "postgres")
                .option(PASSWORD, "postgres")
                .option(DATABASE, "postgres_reactive_ddd")
                .option(CONNECT_TIMEOUT, Duration.ofSeconds(10))
                .option(MAX_SIZE, 40)
                .build();

        return ConnectionFactoryBuilder
                .withOptions(options.mutate())
                .build();
    }


    @Bean
    ConnectionFactoryInitializer initializer(@Qualifier("connectionFactoryWrite")ConnectionFactory connectionFactory){

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

//        var populate = new CompositeDatabasePopulator();
//        populate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
//        populate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
//        initializer.setDatabasePopulator(populate);

        return initializer;
    }


}
