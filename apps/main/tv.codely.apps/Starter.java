package tv.codely.apps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.shared.domain.UseCase;

@SpringBootApplication
@ComponentScan( includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
        value = {"tv.codely", "tv.codely.mooc", "tv.codely.shared"})
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

   // @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            /*
            System.out.println("Let's  hi inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
             */

        };
    }
}
