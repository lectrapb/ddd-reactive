package tv.codely.mooc.courses.infra.persistence.r2dbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mooc_courses", schema = "public")
public class CourseModel {

    @Column("course_id")
    private String id;
    @Column("course_name")
    private String name;
    @Column("course_duration")
    private String duration;
}
