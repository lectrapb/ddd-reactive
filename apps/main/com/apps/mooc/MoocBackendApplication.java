package com.apps.mooc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.shared.domain.UseCase;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan( includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
                value = {"com.apps", "tv.codely.mooc", "tv.codely.shared"})
public class MoocBackendApplication {

    public static Map<String, Class<?>> commands(){
        return new HashMap<String, Class<?>>(){{

            put("Fake", String.class);
            put("another_fake", String.class);
        }};
    }
}
