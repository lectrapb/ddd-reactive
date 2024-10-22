package tv.codely.mooc.courses_counter.infra.persistence.domain;

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
@Table(name = "courses_counter", schema = "public")
public class CoursesCounterData {

    @Column("courses_counter_id")
    private String  id;
    @Column("courses_counter_total")
    private Long total;
}
