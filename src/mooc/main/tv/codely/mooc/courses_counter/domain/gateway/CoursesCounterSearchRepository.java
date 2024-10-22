package tv.codely.mooc.courses_counter.domain.gateway;

import reactor.core.publisher.Mono;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;

import java.util.Optional;

public interface CoursesCounterSearchRepository {

    Mono<Optional<CoursesCounter>> search();
}
