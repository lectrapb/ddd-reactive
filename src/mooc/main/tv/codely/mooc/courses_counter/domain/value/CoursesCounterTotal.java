package tv.codely.mooc.courses_counter.domain.value;


import tv.codely.shared.domain.LongValueObject;

public class CoursesCounterTotal extends LongValueObject {
    public CoursesCounterTotal(Long value) {
        super(value);
    }

    public static CoursesCounterTotal initialize() {
        return new CoursesCounterTotal(0L);
    }

    public CoursesCounterTotal increment() {
        return new CoursesCounterTotal(value() + 1L);
    }
}
