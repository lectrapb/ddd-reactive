package tv.codely.mooc.courses_counter.infra.persistence.infra;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses_counter.infra.persistence.domain.CoursesCounterData;

@Repository
public interface CoursesCounterRepositoryR2DBC extends R2dbcRepository<CoursesCounterData, String> {
}
