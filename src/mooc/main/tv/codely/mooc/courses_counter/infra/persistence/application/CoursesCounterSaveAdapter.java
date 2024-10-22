package tv.codely.mooc.courses_counter.infra.persistence.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;
import tv.codely.mooc.courses_counter.domain.gateway.CoursesCounterSaveRepository;
import tv.codely.mooc.courses_counter.infra.persistence.domain.CoursesCounterData;
import tv.codely.mooc.courses_counter.infra.persistence.infra.CoursesCounterRepositoryR2DBC;


@Service
@AllArgsConstructor
public class CoursesCounterSaveAdapter implements CoursesCounterSaveRepository {

    private final CoursesCounterRepositoryR2DBC repository;

    @Override
    public Mono<Void> save(CoursesCounter coursesCounter) {
        var counterData = new CoursesCounterData();
        counterData.setId(coursesCounter.getId().value());
        counterData.setTotal(coursesCounter.getTotal().value());
        return repository.save(counterData)
                .then(Mono.empty());

    }
}
