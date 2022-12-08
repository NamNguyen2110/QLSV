-- /* ==================== CREATE TABLES ====================*/
-- -- create table 1: Student
-- DROP TABLE IF EXISTS Student;
CREATE TABLE Course
(
    id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name    NVARCHAR(50) NOT NULL
);
/* ==================== INSERT DATA INTO TABLES ====================*/
-- Insert data into table 3: Account
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