create database sale_management;
use sale_management;
create table customer (
	customer_id int,
    first_name varchar(50),
    date_of_purchase date
);

create table sales (
	sales_id int,
    customer_id int,
    date_of_purchase date
);

create table trainee(
	trainee_id int primary key auto_increment,
    full_name varchar(30),
    birth_date date,
    gender enum("male", "female", "unknown"),
    et_iq int check(et_iq >= 0 & et_iq <= 20),
    et_gmath int check(et_iq >= 0 & et_iq <= 20),
    et_english int check(et_iq >= 0 & et_iq <= 50),
    training_class varchar(10),
    notes text
);

alter table trainee add column vti_account char(50) not null unique key;