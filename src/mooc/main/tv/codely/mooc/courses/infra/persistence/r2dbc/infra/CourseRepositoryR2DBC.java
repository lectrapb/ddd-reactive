package tv.codely.mooc.courses.infra.persistence.r2dbc.infra;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses.infra.persistence.r2dbc.domain.CourseModel;

@Repository
public interface CourseRepositoryR2DBC extends R2dbcRepository<CourseModel, String> {
}
