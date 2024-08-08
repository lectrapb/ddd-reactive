package com.apps.mooc;


import com.apps.mooc.backend.command.FakeCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.shared.domain.UseCase;


import java.util.HashMap;


@SpringBootApplication
@ComponentScan( includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
                value = {"com.apps", "tv.codely.mooc", "tv.codely.shared"})
public class MoocBackendApplication {

    public static HashMap<String, Class<?>>commands(){
        return new HashMap<String, Class<?>>(){{

            put("Fake", FakeCommand.class);
            put("another_fake", String.class);
        }};
    }
}
