package tv.codely.mooc.courses.domain.value;

import tv.codely.shared.domain.value.Identifier;
import lombok.Getter;


@Getter
public class CourseId extends Identifier {


    public CourseId(String value) {
        super(value);
    }
}
