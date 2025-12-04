create database if not exists nhan_vien;
use nhan_vien;

create table department(
	department_number tinyint auto_increment primary key,
    department_name nvarchar(30) not null
);

create table employee_table(
	employee_number smallint auto_increment primary key,
    employee_name nvarchar(30) not null,
    department_number tinyint not null,
    foreign key (department_number) references department(department_number)
);