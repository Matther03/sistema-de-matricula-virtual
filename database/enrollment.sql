USE mysql;

-- BASE DE DATOS
DROP DATABASE IF EXISTS bd_enrollment_vmm;
CREATE DATABASE bd_enrollment_vmm;

USE bd_enrollment_vmm;

-- TABLITAS
DROP TABLE IF EXISTS representative;
CREATE TABLE representative(
    code_representative INT(5) AUTO_INCREMENT,
    _name VARCHAR(50) NOT NULL,
    father_surname VARCHAR(25) NOT NULL,
    mother_surname VARCHAR(25) NOT NULL,
    id_card CHAR(8) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone CHAR(9) NOT NULL,
    PRIMARY KEY(code_representative)
);

DROP TABLE IF EXISTS student;
CREATE TABLE student(
    code_student INT(6) AUTO_INCREMENT,
    _name VARCHAR(50) NOT NULL,
    father_surname VARCHAR(25) NOT NULL,
    mother_surname VARCHAR(25) NOT NULL,
    age TINYINT(2) NOT NULL,
    id_card CHAR(8) NOT NULL,
    direction VARCHAR(50) NOT NULL,
    code_representative INT(5) NOT NULL,
    PRIMARY KEY(code_student),
    FOREIGN KEY (code_representative) REFERENCES representative(code_representative)
);

DROP TABLE IF EXISTS account;
CREATE TABLE account(
    code_account INT(10) AUTO_INCREMENT,
    _password VARCHAR(25) NOT NULL,
    code_student INT(6) NOT NULL,
    PRIMARY KEY(code_account),
    FOREIGN KEY (code_student) REFERENCES student(code_student)
);


DROP TABLE IF EXISTS bank;
CREATE TABLE bank(
    code_bank TINYINT(1) AUTO_INCREMENT,
    _name VARCHAR(50) NOT NULL,
    PRIMARY KEY (code_bank)
);


DROP TABLE IF EXISTS payment;
CREATE TABLE payment(
    code_payment INT(10) AUTO_INCREMENT,
    date_payment DATETIME NOT NULL,
    amount_payment DECIMAL(5,2) NOT NULL,
    code_bank TINYINT(1) NOT NULL,
    code_student INT(6) NOT NULL,
    PRIMARY KEY (code_payment),
    FOREIGN KEY (code_bank) REFERENCES bank(code_bank),
    FOREIGN KEY (code_student) REFERENCES student(code_student)
);

DROP TABLE IF EXISTS register_new_student;
CREATE TABLE register_new_student(
    code_register INT(5) AUTO_INCREMENT,
    code_payment INT(10) NOT NULL,
    PRIMARY KEY(code_register),
    FOREIGN KEY (code_payment) REFERENCES payment(code_payment)
);

DROP TABLE IF EXISTS shift;
CREATE TABLE shift(
    code_shift TINYINT(1) AUTO_INCREMENT,
    category VARCHAR(6) NOT NULL,
    PRIMARY KEY (code_shift)
);


DROP TABLE IF EXISTS section;
CREATE TABLE section(
    code_section TINYINT(2) AUTO_INCREMENT,
    letter CHAR(1) NOT NULL,
    code_shift TINYINT(1) NOT NULL,
    PRIMARY KEY (code_section),
    FOREIGN KEY (code_shift) REFERENCES shift(code_shift)
);

DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher(
    code_teacher INT(5) AUTO_INCREMENT,
    _name VARCHAR(50) NOT NULL,
    father_surname VARCHAR(25) NOT NULL,
    mother_surname VARCHAR(25) NOT NULL,
    PRIMARY KEY(code_teacher)
);

DROP TABLE IF EXISTS grade;
CREATE TABLE grade(
    code_grade TINYINT(1) AUTO_INCREMENT,
    name_grade VARCHAR(10) NOT NULL,
    PRIMARY KEY (code_grade)
);

DROP TABLE IF EXISTS course;
CREATE TABLE course(
    code_course INT(5) AUTO_INCREMENT,
    name_course VARCHAR(50) NOT NULL,
    code_grade TINYINT(1) NOT NULL,
    PRIMARY KEY(code_course),
    FOREIGN KEY (code_grade) REFERENCES grade(code_grade)
);

DROP TABLE IF EXISTS course_teacher;
CREATE TABLE course_teacher(
    code_course_teacher INT(5) AUTO_INCREMENT,
    code_teacher INT(5) NOT NULL,
    code_course INT(5) NOT NULL,
    PRIMARY KEY(code_course_teacher),
    FOREIGN KEY (code_teacher) REFERENCES teacher(code_teacher),
    FOREIGN KEY (code_course) REFERENCES course(code_course)
);

DROP TABLE IF EXISTS classroom;
CREATE TABLE classroom(
    code_classroom INT(3) AUTO_INCREMENT,
    code_section TINYINT(2) NOT NULL,
    code_grade TINYINT(1) NOT NULL,
    code_teacher INT(5) NOT NULL,
    PRIMARY KEY (code_classroom),
    FOREIGN KEY (code_section) REFERENCES section(code_section),
    FOREIGN KEY (code_grade) REFERENCES grade(code_grade),
    FOREIGN KEY (code_teacher) REFERENCES teacher(code_teacher)
);

DROP TABLE IF EXISTS type_school;
CREATE TABLE type_school(
    code_type_school TINYINT(1) AUTO_INCREMENT,
    type_s VARCHAR(8) NOT NULL,
    PRIMARY KEY(code_type_school)
);

DROP TABLE IF EXISTS enrollment;
CREATE TABLE enrollment(
    code_enrollment INT(10) AUTO_INCREMENT,
    date_enrolemnt DATETIME NOT NULL,
    repeater BIT NOT NULL,
    code_payment INT(10) NOT NULL,
    code_classroom INT(3) NOT NULL,
    code_type_school TINYINT(1) NULL,
    name_type_school VARCHAR(50) NULL,
    PRIMARY KEY (code_enrollment),
    FOREIGN KEY (code_payment) REFERENCES payment(code_payment),
    FOREIGN KEY (code_classroom) REFERENCES classroom(code_classroom),
    FOREIGN KEY (code_type_school) REFERENCES type_school(code_type_school)
);

-- INSERT DATA

INSERT INTO banck (_name) VALUES ('BBVA');
INSERT INTO banck (_name) VALUES ('BCP');

INSERT INTO shift (category) VALUES ('MAÑANA');
INSERT INTO shift (category) VALUES ('TARDE');

INSERT INTO grade (name_grade) VALUES ('PRIMERO');
INSERT INTO grade (name_grade) VALUES ('SEGUNDO');
INSERT INTO grade (name_grade) VALUES ('TERCERO');
INSERT INTO grade (name_grade) VALUES ('CUARTO');
INSERT INTO grade (name_grade) VALUES ('QUINTO');

INSERT INTO section (letter,code_shift) VALUES ('A','1');
INSERT INTO section (letter,code_shift) VALUES ('B','1');
INSERT INTO section (letter,code_shift) VALUES ('C','1');
INSERT INTO section (letter,code_shift) VALUES ('D','1');
INSERT INTO section (letter,code_shift) VALUES ('E','2');
INSERT INTO section (letter,code_shift) VALUES ('F','2');
INSERT INTO section (letter,code_shift) VALUES ('G','2');
INSERT INTO section (letter,code_shift) VALUES ('H','2');