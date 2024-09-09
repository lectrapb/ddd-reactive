package tv.codely.mooc.courses.infra.persistence.r2dbc;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.courses.domain.CourseRepository;

public abstract class CoursesModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {

    @Autowired
    protected CourseRepository  courseRepositoryPostgres;
}
