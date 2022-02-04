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
    dni CHAR(8) NOT NULL,
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
    date_of_birth DATE NOT NULL,
    dni CHAR(8) NOT NULL,
    direction VARCHAR(50) NOT NULL,
    code_representative INT(5) NOT NULL,
    PRIMARY KEY(code_student),
    FOREIGN KEY (code_representative) REFERENCES representative(code_representative)
);

DROP TABLE IF EXISTS account;
CREATE TABLE account(
    code_account INT(10) AUTO_INCREMENT,
    _password CHAR(60) NOT NULL,
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
    date_payment DATE NOT NULL,
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
    code_account INT(10) NOT NULL,
    PRIMARY KEY(code_register),
    FOREIGN KEY (code_account) REFERENCES account(code_account)
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

DROP TABLE IF EXISTS classroom_vacancy;
CREATE TABLE classroom_vacancy(
    code_vacancy TINYINT(2) AUTO_INCREMENT,
    quantity TINYINT(2) NOT NULL,
    code_classroom INT(3) NOT NULL,
    PRIMARY KEY (code_vacancy),
    FOREIGN KEY (code_classroom) REFERENCES classroom(code_classroom)
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
    date_enrolemnt DATE NOT NULL,
    repeater BIT NOT NULL,
    code_payment INT(10) NOT NULL,
    code_classroom INT(3) NOT NULL,
    code_type_school TINYINT(1) NULL,
    PRIMARY KEY (code_enrollment),
    FOREIGN KEY (code_payment) REFERENCES payment(code_payment),
    FOREIGN KEY (code_classroom) REFERENCES classroom(code_classroom)
);

DROP TABLE IF EXISTS history_detail_student;
CREATE TABLE history_detail_student(
    code_history_detail_student INT(6) AUTO_INCREMENT,
    _repeat BIT NOT NULL,
    code_student INT(6) NOT NULL,
    PRIMARY KEY (code_history_detail_student),
    FOREIGN KEY (code_student) REFERENCES student(code_student)
);

-- INSERT DATA

INSERT INTO bank (_name) VALUES ('BBVA');
INSERT INTO bank (_name) VALUES ('BCP');

INSERT INTO grade (name_grade) VALUES ('PRIMERO');
INSERT INTO grade (name_grade) VALUES ('SEGUNDO');
INSERT INTO grade (name_grade) VALUES ('TERCERO');
INSERT INTO grade (name_grade) VALUES ('CUARTO');
INSERT INTO grade (name_grade) VALUES ('QUINTO');

INSERT INTO course (name_course,code_grade) VALUES ('Matemática - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Comunicación - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Idioma extranjero - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Educación por el Arte - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencias Sociales - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Persona, Familia y Relaciones Humanas - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Física - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Religiosa - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencia, Tecnología y Ambiente - Primer año','1');
INSERT INTO course (name_course,code_grade) VALUES ('Educación para el Trabajo - Primer año','1');

INSERT INTO course (name_course,code_grade) VALUES ('Matemática - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Comunicación - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Idioma extranjero - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Educación por el Arte - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencias Sociales - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Persona, Familia y Relaciones Humanas - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Física - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Religiosa - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencia, Tecnología y Ambiente - Segundo año','2');
INSERT INTO course (name_course,code_grade) VALUES ('Educación para el Trabajo - Segundo año','2');

INSERT INTO course (name_course,code_grade) VALUES ('Matemática - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Comunicación - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Idioma extranjero - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Educación por el Arte - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencias Sociales - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Persona, Familia y Relaciones Humanas - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Física - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Religiosa - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencia, Tecnología y Ambiente - Tercer año','3');
INSERT INTO course (name_course,code_grade) VALUES ('Educación para el Trabajo - Tercer año','3');

INSERT INTO course (name_course,code_grade) VALUES ('Matemática - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Comunicación - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Idioma extranjero - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Educación por el Arte - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencias Sociales - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Persona, Familia y Relaciones Humanas - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Física - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Religiosa - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencia, Tecnología y Ambiente - Cuarto año','4');
INSERT INTO course (name_course,code_grade) VALUES ('Educación para el Trabajo - Cuarto año','4');

INSERT INTO course (name_course,code_grade) VALUES ('Matemática - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Comunicación - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Idioma extranjero - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Educación por el Arte - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencias Sociales - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Persona, Familia y Relaciones Humanas - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Física - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Educación Religiosa - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Ciencia, Tecnología y Ambiente - Quinto año','5');
INSERT INTO course (name_course,code_grade) VALUES ('Educación para el Trabajo - Quinto año','5');


INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Luis Javier','Hernandez','Guerrero');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Cesia Dolly','Martinez','Vera');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Sul Ki','Ham','Orellana');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ida Zuleyma','Bertolotti','Salcedo');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Lucia Jeanet','Mantari','Misaico');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jose Mauricio','Quintana','Bernaola');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Johnny Alexis','Castillo','Mayuri');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Juana Almendra','Peña','Espino');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Luis Alonso','De los Rios','Hernandez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Felix David','Cordova','Aparcana');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jose Aldahir','Lengua','Muñoz');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Aldahir Jhunior','Solis','Gutiérrez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Genesis Fabiola','Villagaray','Pecho');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Joseph Andre','Vizarreta','Vasquez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Rodrigo Roberto','Martinez','Miranda');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Sthepanie Yennifer','Pizarro','Paredes');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Billy Andrew','Suarez','Matias');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ebony Sthepanie','Jimenez','Ormeño');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Rosa Angela','Ipanaque','Carrasco');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Nagelly Geovanni','Osorio','Ramos');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jose Daniel','Layseca','Guevara');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Fritcia Pamela','Roque','Espinoza');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jesus Manuel','Varillas','Asencios');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ivonne Sharon','Alvarez','Perez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ariana Dessire','Gutierrez','Tasayco');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Abel Fernando','Castañeda','Bertolotti');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Luis Anthony','Cordova','Perez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Rodrigo Esthefano','Marquina','Huamani');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ismael Alejandro','Mendoza','Gonzales');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Miguel Angel','Hiaroto','Espinoza');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Evelyn','Santos','Ramos');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Cesar William','Miranda','Tisoc');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Maily','Takayama','Alderete');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Carlos Alezander','Salvador','Almeyda');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Daniela Fernanda','Astorga','Bendezu');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Anibal Nehemias','Yauricasa','Ramos');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Shirley Katerin','Velasco','Taipe');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Rosa Lizbeth','Poma','Perales');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Cielo Luisa','Suarez','Saco');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Julio Cesar','Uribe','Cañedo');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Angel Gabriel','Gomez','Avalos');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Alvaro Nevari','Jurado','Hernandez');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Gino Kenny','Cruz','Marca');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jens Andres','Castro','Diaz');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Marlo Cristiam','Achamizo','Pedraza');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Maria Angelica','Quispe','Campos');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Jean Pierre','Soto','Contreras');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Ismael Asmir','Garcia','Antonio');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Isidora Natividad','Cayo','Quijua');
INSERT INTO teacher (_name,father_surname,mother_surname) VALUES('Antny Wilder','Pacheco','Pariona');

INSERT INTO course_teacher(code_teacher,code_course) VALUES ('1','1');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('2','2');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('3','3');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('4','4');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('5','5');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('6','6');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('7','7');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('8','8');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('9','9');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('10','10');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('11','11');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('12','12');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('13','13');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('14','14');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('15','15');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('16','16');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('17','17');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('18','18');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('19','19');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('20','20');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('21','21');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('22','22');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('23','23');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('24','24');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('25','25');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('26','26');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('27','27');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('28','28');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('29','29');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('30','30');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('31','31');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('32','32');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('33','33');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('34','34');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('35','35');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('36','36');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('37','37');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('38','38');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('39','39');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('40','40');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('41','41');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('42','42');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('43','43');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('44','44');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('45','45');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('46','46');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('47','47');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('48','48');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('49','49');
INSERT INTO course_teacher(code_teacher,code_course) VALUES ('50','50');

INSERT INTO shift (category) VALUES ('MAÑANA');
INSERT INTO shift (category) VALUES ('TARDE');

INSERT INTO section (letter,code_shift) VALUES ('A','1');
INSERT INTO section (letter,code_shift) VALUES ('B','1');
INSERT INTO section (letter,code_shift) VALUES ('C','1');
INSERT INTO section (letter,code_shift) VALUES ('D','1');
INSERT INTO section (letter,code_shift) VALUES ('E','2');
INSERT INTO section (letter,code_shift) VALUES ('F','2');
INSERT INTO section (letter,code_shift) VALUES ('G','2');
INSERT INTO section (letter,code_shift) VALUES ('H','2');

INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('1','1','1');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('2','1','2');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('3','1','3');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('4','1','4');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('5','1','5');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('6','1','6');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('7','1','7');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('8','1','8');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('1','2','11');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('2','2','12');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('3','2','13');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('4','2','14');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('5','2','15');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('6','2','16');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('7','2','17');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('8','2','18');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('1','3','21');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('2','3','22');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('3','3','23');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('4','3','24');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('5','3','25');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('6','3','26');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('7','3','27');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('8','3','28');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('1','4','31');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('2','4','32');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('3','4','33');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('4','4','34');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('5','4','35');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('6','4','36');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('7','4','37');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('8','4','38');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('1','5','41');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('2','5','42');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('3','5','43');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('4','5','44');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('5','5','45');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('6','5','46');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('7','5','47');
INSERT INTO classroom(code_section,code_grade,code_teacher) VALUES('8','5','50');

INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','1');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','2');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','3');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','4');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','5');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','6');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','7');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','8');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','9');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','10');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','11');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','12');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','13');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','14');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','15');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','16');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','17');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','18');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','19');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','20');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','21');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','22');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','23');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','24');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','25');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','26');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','27');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','28');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','29');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','30');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','31');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','32');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','33');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','34');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','35');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','36');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','37');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','38');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','39');
INSERT INTO classroom_vacancy(quantity,code_classroom) VALUES('35','40');

INSERT INTO type_school(type_s) VALUES ('Estatal');
INSERT INTO type_school(type_s) VALUES ('Particular');

INSERT INTO representative(_name,father_surname,mother_surname,dni,email,phone) VALUES('Juan Pablo','Carlos','Setien','78945612','juan_pablo@gmail.com','987654321');
INSERT INTO representative(_name,father_surname,mother_surname,dni,email,phone) VALUES('Doris Sofia','Huarcaya','Valverde','78945613','doris_valverde@gmail.com','987654322');
INSERT INTO representative(_name,father_surname,mother_surname,dni,email,phone) VALUES('Freddy','Gonzales','Hoo','78945614','Hoo_freddy@gmail.com','987654323');


INSERT INTO student(_name,father_surname,mother_surname,date_of_birth,dni,direction,code_representative) VALUES('Luis Aldair','Eto','Lucas','2008-01-20','77665501','Av. San Carlos #222','1');
INSERT INTO student(_name,father_surname,mother_surname,date_of_birth,dni,direction,code_representative) VALUES('Neymar Junior','Pele','Messi','2009-03-20','77665502','Av. San Miguel #152','2');
INSERT INTO student(_name,father_surname,mother_surname,date_of_birth,dni,direction,code_representative) VALUES('Leonel Jose','Zidane','Robinho','2008-02-14','77665503','Av. San Pollitos #265','3');

INSERT INTO account(_password,code_student) VALUES('$2a$10$JmACanPS43pCL7ogvywlFOrGQyyUBivP6QIf1ly.GOpn/lq05tfWi','1'); -- Contralumno1
INSERT INTO account(_password,code_student) VALUES('$2a$10$M0uQXWkKGRyTlUEbKyV3XuStDaEpWeemF2iufG1E3gFS53Kf0JOtq','2'); -- Elcrack123
INSERT INTO account(_password,code_student) VALUES('$2a$10$M0uQXWkKGRyTlUEbKyV3XuStDaEpWeemF2iufG1E3gFS53Kf0JOtq','3'); -- Pirata123


-- Procedures

DROP PROCEDURE IF EXISTS sp_verify_account_student;
DELIMITER //
CREATE PROCEDURE sp_verify_account_student(
    IN __dni_student CHAR(8)
)
BEGIN
    DECLARE __password CHAR(60);
    SET __password = (  SELECT _password 
                        FROM student 
                        INNER JOIN account ON student.code_student = account.code_student 
                        WHERE student.dni = __dni_student );  
    IF __password IS NULL THEN
        SELECT 'NOT FOUND' AS 'ERROR';
    ELSE
        SELECT __password;
    END IF;
END//

DROP PROCEDURE IF EXISTS sp_get_detail_classroom;
DELIMITER //
CREATE PROCEDURE sp_get_detail_classroom(
    IN __code_grade TINYINT(1)
)
BEGIN
    SELECT  classroom.code_grade,
            section.code_section,
            section.letter, 
            classroom_vacancy.quantity, 
            shift.category 
            FROM shift
                INNER JOIN section
            ON shift.code_shift = section.code_shift
                INNER JOIN classroom
            ON section.code_section = classroom.code_section
                INNER JOIN classroom_vacancy
            ON classroom.code_classroom = classroom_vacancy.code_classroom
                WHERE classroom.code_grade = __code_grade;
END//

DROP PROCEDURE IF EXISTS sp_get_detail_student;
DELIMITER //
CREATE PROCEDURE sp_get_detail_student(
    IN __dni_student CHAR(8)
)
BEGIN
    SELECT  code_student, 
            _name,
            father_surname,
            mother_surname
    FROM student
    WHERE student.dni = __dni_student;
END//
