create table if not exists table_employees(
	em_id serial primary key,
	em_name varchar(40) not null,
	em_username varchar(30) unique,
	em_password varchar(20) not null,
	em_role varchar(20),
);