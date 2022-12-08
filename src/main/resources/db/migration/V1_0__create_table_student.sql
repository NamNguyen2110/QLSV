-- /* ==================== CREATE TABLES ====================*/
-- -- create table 1: Student
-- DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
    id        INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    full_name NVARCHAR(50) NOT NULL,
    address   NVARCHAR(50) NOT NULL
);
/* ==================== INSERT DATA INTO TABLES ====================*/
-- Insert data into table 3: Account
INSERT INTO Student (full_name, address)
VALUES ('Nguyễn Minh Anh', 'Hà Nội');
INSERT INTO Student (full_name, address)
VALUES ('Hoàng Trọng Nho', 'Hà Nam');
INSERT INTO Student (full_name, address)
VALUES ('Nguyễn Thị Lan Anh', 'Sóc Sơn');
INSERT INTO Student (full_name, address)
VALUES ('Nguyễn Văn Nam', 'Nam Định');