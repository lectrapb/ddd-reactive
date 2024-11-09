package tv.codely.mooc.courses.application.create;

import lombok.AllArgsConstructor;
import tv.codely.mooc.courses.domain.CreateCourseRequest;
import tv.codely.shared.domain.UseCase;
import tv.codely.shared.domain.bus.command.CommandHandler;

@UseCase
@AllArgsConstructor
public class CourseCreatorCommandHandler implements CommandHandler<CourseCreateCommand> {

    private final CourseCreator creator;

    @Override
    public void handle(CourseCreateCommand command) {

        var requestCreateCourse = new CreateCourseRequest(command.id(), command.name(), command.duration());
        creator.create(requestCreateCourse);
    }
}
