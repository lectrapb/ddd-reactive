package com.apps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
//@ComponentScan({"com.apps","tv.codely.mooc"})
public class Starter1 {

    public static void main(String[] args) {
        SpringApplication.run(Starter1.class, args);
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
