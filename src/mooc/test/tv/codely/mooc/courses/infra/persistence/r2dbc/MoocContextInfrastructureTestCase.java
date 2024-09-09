package tv.codely.mooc.courses.infra.persistence.r2dbc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.mooc.MoocBackendApplication;
import tv.codely.shared.infra.InfrastructureTestCase;

@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public class MoocContextInfrastructureTestCase extends InfrastructureTestCase {
}
