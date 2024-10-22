package tv.codely.mooc.courses.infra.persistence.r2dbc.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.infra.persistence.r2dbc.infra.CourseRepositoryR2DBC;

import java.util.Optional;

@Service
@AllArgsConstructor
public class postgreSqlCourseCreateRepository implements CourseRepository {

    private final CourseRepositoryR2DBC repository;
    private final TransactionalOperator transaction;


    @Override
    public Mono<Void> save(Course course) {
        return transaction.execute(status ->
                repository.save(MapperCourse.toModel(course))
                        .then()
                        .onErrorResume(error -> {
                            status.setRollbackOnly();
                            return Mono.error(new RuntimeException("Error al guardar el curso", error));
                        })
        ).then();
    }

    @Override
    public Mono<Optional<Course>> findById(String id) {
        return repository.findById(id)
                .flatMap(courseModel -> {
                    var result = Optional.ofNullable(courseModel)
                            .map(MapperCourse::toEntity);
                    return Mono.just(result);
                })
                .defaultIfEmpty(Optional.empty());
    }

}
