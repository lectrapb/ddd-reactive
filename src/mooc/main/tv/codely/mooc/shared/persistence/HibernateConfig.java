package tv.codely.mooc.shared.persistence;


import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;
import tv.codely.mooc.courses.infra.persistence.r2dbc.infra.CourseRepositoryR2DBC;

import java.time.Duration;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories(basePackageClasses = CourseRepositoryR2DBC.class)
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
    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactoryWrite) {
        return new R2dbcEntityTemplate(connectionFactoryWrite);
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactoryWrite) {
        return new R2dbcTransactionManager(connectionFactoryWrite);
    }

    @Bean
    public TransactionalOperator transactionalOperator(ReactiveTransactionManager transactionManager) {
        return TransactionalOperator.create(transactionManager);
    }


    @Bean
    ConnectionFactoryInitializer initializer(@Qualifier("connectionFactoryWrite")ConnectionFactory connectionFactory){

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);

        var populate = new CompositeDatabasePopulator();
        populate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        populate.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
        initializer.setDatabasePopulator(populate);

        return initializer;
    }


}
