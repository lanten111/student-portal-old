INSERT into student(idNumber, studentName, surname, email, studentNumber, phoneNumber, course, login)
VALUES ('9506225557852', 'bruce', 'wayne', 'waynbe@gmail.com', '20210633', '075446655', 2, 2);
VALUES ('9406575577852', 'Tony', 'Stack', 'tony@gmail.com', '20210633', '075446655', 2, 2);

insert into course(course_name, course_code, module)
VALUES('Burhcelor of science', 'BSC', 3);

insert into Login(username, password, lastLogin)
VALUES ('20210633', '123', null);

insert into Module( moduleName, moduleCode, moduleTime, lecturer, ModuleMaterials)
VALUES('analytical','ENT101', null , 1, 1);

insert into Lecturer(lecturerName, lecturerSurname)
VALUES ('mfowabo', 'ramaphosa');

insert into ModuleMaterials(moduleGuide, bookName)
VALUES (null, 'analytical book');

-- create table Lecturer
-- (
--     id serial primary key,
--     lecturerName varchar(100),
--     lecturerSurname varchar(100)
-- );
--
-- create table ModuleMaterials
-- (
--     id serial primary key,
--     moduleGuide bytea,
--     bookName varchar(500)
-- );
--
-- create table Module
-- (
--     id serial primary key,
--     moduleId varchar(100),
--     moduleName varchar(100),
--     moduleCode date,
--     lecturer int references Lecturer(id),
--     moduleTime date,
--     ModuleMaterials int references ModuleMaterials(id)
-- );
--
-- create table Course
-- (
--     id serial primary key,
--     courseId varchar(10) not null ,
--     course_name varchar(100) not null ,
--     course_code varchar(10) not null ,
--     module int references Module(id)
-- );
-- create table Login
-- (
--     id serial primary key,
--     username varchar(100),
--     password varchar(100),
--     lastLogin date
-- );
--
-- create table Student
-- (
--     id serial primary key,
--     idNumber varchar(100),
--     studentName varchar(100),
--     surname varchar(100),
--     email varchar(100),
--     studentNumber varchar(10),
--     phoneNumber varchar(10),
--     course int references Course(id),
--     login int references Login(id)
-- );
--
-- select * from student;