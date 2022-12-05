-- create database
DROP DATABASE IF EXISTS QLSV;
CREATE DATABASE QLSV;
USE QLSV;

/* ==================== CREATE TABLES ====================*/
-- create table 1: Hop dong lao dong
DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
    Id        INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_name NVARCHAR(50) NOT NULL,
    Address   NVARCHAR(50) NOT NULL
);
/* ==================== INSERT DATA INTO TABLES ====================*/
-- Insert data into table 3: Account
INSERT INTO Student (Full_name, Address)
VALUES ('Nguyễn Minh Anh', 'Hà Nội');
INSERT INTO Student (Full_name, Address)
VALUES ('Hoàng Trọng Nho', 'Hà Nam');
INSERT INTO Student (Full_name, Address)
VALUES ('Nguyễn Thị Lan Anh', 'Sóc Sơn');
INSERT INTO Student (Full_name, Address)
VALUES ('Nguyễn Văn Nam', 'Nam Định');