DROP TABLE IF EXISTS mooc_courses;
DROP TABLE IF EXISTS postgres_reactive_ddd;

CREATE TABLE IF NOT EXISTS mooc_courses (
    course_id VARCHAR(254) PRIMARY KEY,
    course_name VARCHAR(254),
    course_duration VARCHAR(254)
);
