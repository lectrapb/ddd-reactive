package tv.codely.mooc.courses.application.create;

import tv.codely.shared.domain.bus.command.Command;


public record CourseCreateCommand(String id, String name, String duration) implements Command {

}
