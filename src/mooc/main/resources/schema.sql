DROP TABLE IF EXISTS mooc_courses;
DROP TABLE IF EXISTS courses_counter;
DROP TABLE IF EXISTS postgres_reactive_ddd;

CREATE TABLE IF NOT EXISTS mooc_courses (
    course_id VARCHAR(254) PRIMARY KEY,
    course_name VARCHAR(254),
    course_duration VARCHAR(254)
);

CREATE TABLE IF NOT EXISTS courses_counter (
    courses_counter_id VARCHAR(254) PRIMARY KEY,
    courses_counter_total BIGINT
);

