package tv.codely.mooc.courses_counter.application.increment;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;
import tv.codely.mooc.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import tv.codely.mooc.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import tv.codely.shared.domain.UseCase;

import java.util.Optional;
import java.util.UUID;

@UseCase
@AllArgsConstructor
public class CoursesCounterIncrementer {

    private final CoursesCounterSaveRepository saveRepository;
    private final CoursesCounterSearchRepository searchRepository;

    public Mono<Void> increment(CourseId id) {
        return searchRepository.search()
                .defaultIfEmpty(Optional.empty())
                .flatMap(optional -> {
                    CoursesCounter counter = null;
                    if (optional.isEmpty()) {
                        counter = CoursesCounter.initialize(UUID.randomUUID().toString());
                    }
                    if (!counter.hasIncremented(id)) {
                        counter.increment(id);
                        return saveRepository.save(counter);
                    }
                    return Mono.empty();
                });


    }
}
