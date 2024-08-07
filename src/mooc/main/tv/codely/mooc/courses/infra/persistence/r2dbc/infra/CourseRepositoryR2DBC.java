package tv.codely.mooc.courses.infra.persistence.r2dbc.infra;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CourseRepository extends R2dbcRepository<CourseRepository, String> {
}
