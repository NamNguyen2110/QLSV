-- /* ==================== CREATE TABLES ====================*/
-- -- create table 2: Course
-- DROP TABLE IF EXISTS Course;
CREATE TABLE Course
(
    id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name    NVARCHAR(50) NOT NULL
);
/* ==================== INSERT DATA INTO TABLES ====================*/
-- Insert data into table 2: Course
INSERT INTO Course (name)
VALUES ('Toán');
INSERT INTO Course (name)
VALUES ('Văn');
INSERT INTO Course (name)
VALUES ('Anh');
INSERT INTO Course (name)
VALUES ('Lý');
INSERT INTO Course (name)
VALUES ('Hóa');