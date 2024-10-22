package tv.codely.mooc.courses_counter.domain.gateway;

import reactor.core.publisher.Mono;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;

public interface CoursesCounterSaveRepository {

    Mono<Void> save(CoursesCounter coursesCounter);
}
