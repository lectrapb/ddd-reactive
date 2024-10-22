package tv.codely.mooc.courses_counter.domain;

import lombok.Getter;
import tv.codely.mooc.courses.domain.value.CourseId;
import tv.codely.mooc.courses_counter.domain.value.CoursesCounterId;
import tv.codely.mooc.courses_counter.domain.value.CoursesCounterTotal;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CoursesCounter {

    private final CoursesCounterId id;
    private CoursesCounterTotal total;
    private List<CourseId> existingCourses;

    public CoursesCounter(CoursesCounterId id, CoursesCounterTotal total, List<CourseId> existingCourses) {
        this.id = id;
        this.total = total;
        this.existingCourses = existingCourses;
    }

    public static CoursesCounter initialize(String id) {
        return new CoursesCounter(new CoursesCounterId(id), CoursesCounterTotal.initialize(),
                new ArrayList<>());
    }
    public boolean hasIncremented(CourseId id) {
        return existingCourses.contains(id);
    }

    public void increment(CourseId id) {
        total = total.increment();
        existingCourses.add(id);
    }

}
