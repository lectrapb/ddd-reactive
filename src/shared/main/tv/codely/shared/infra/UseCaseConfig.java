package tv.codely.shared.infra;


import tv.codely.shared.domain.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.app", "tv.codely.mooc.courses"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = UseCase.class),
        useDefaultFilters = false)
public class UseCaseConfig {
}

