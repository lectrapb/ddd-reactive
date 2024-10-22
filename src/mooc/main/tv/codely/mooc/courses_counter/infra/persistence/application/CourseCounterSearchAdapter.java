package tv.codely.mooc.courses_counter.infra.persistence.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses_counter.domain.CoursesCounter;
import tv.codely.mooc.courses_counter.domain.gateway.CoursesCounterSearchRepository;
import tv.codely.mooc.courses_counter.domain.value.CoursesCounterId;
import tv.codely.mooc.courses_counter.domain.value.CoursesCounterTotal;
import tv.codely.mooc.courses_counter.infra.persistence.infra.CoursesCounterRepositoryR2DBC;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseCounterSearchAdapter implements CoursesCounterSearchRepository {

    private final CoursesCounterRepositoryR2DBC repository;

    @Override
    public Mono<Optional<CoursesCounter>> search() {
        return repository.findAll()
                .collectList()
                .map(countersData -> {
                    if (countersData.isEmpty()) {
                        return Optional.empty();
                    }
                    var data = countersData.get(0);
                    return Optional.of(new CoursesCounter(
                            new CoursesCounterId(data.getId()),
                            new CoursesCounterTotal(data.getTotal()),
                            new ArrayList<>()
                    ));
                });
    }
}
