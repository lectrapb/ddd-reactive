package tv.codely.mooc.courses.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.infra.cli.ConsoleCommand;

@ContextConfiguration(classes = MoocBackendApplicationTest.class)
@SpringBootTest
public abstract class CoursesModuleInfrastructureTestCase extends ConsoleCommand {

    public static void main(String[] args) {
        SpringApplication.run( CoursesModuleInfrastructureTestCase.class, args);
    }
    @Autowired
    protected CourseRepository courseRepositoryPostgres;
}
