-- /* ==================== CREATE TABLES ====================*/
-- -- create table 1: Student
-- DROP TABLE IF EXISTS Student;
CREATE TABLE CourseStudent
(
    id_student      INT UNSIGNED REFERENCES Student(id),
    id_course    INT UNSIGNED REFERENCES Course(id),
PRIMARY KEY (id_student, id_course)
);
/* ==================== INSERT DATA INTO TABLES ====================*/
-- Insert data into table 3: Account
INSERT INTO CourseStudent (id_student, id_course)
VALUES (1, 2);
INSERT INTO CourseStudent (id_student, id_course)
VALUES (2, 3);
INSERT INTO CourseStudent (id_student, id_course)
VALUES (2, 4);
INSERT INTO CourseStudent (id_student, id_course)
VALUES (3, 5);
INSERT INTO CourseStudent (id_student, id_course)
VALUES (4, 1);