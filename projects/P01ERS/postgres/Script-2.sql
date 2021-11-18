drop table if exists ERS_REIMBURSEMENT;
drop table if exists ERS_REIMBURSEMENT_STATUS;
drop table if exists ERS_REIMBURSEMENT_TYPES;
drop table if exists ERS_Users; 
drop table if exists ERS_USER_ROLES;

create table if not exists ERS_REIMBURSEMENT(
	REIMB_ID Serial primary key,
	REIMB_AMOUNT INTEGER not null,
	REIMB_SUBMITTED TIMESTAMP not null,
	REIMB_RESOLVED TIMESTAMP not null,
	REIMB_DESCRIPTION VARCHAR(250),
	REIMB_AUTHOR INTEGER references ERS_USERS(ERS_USER_ID) not null, 
	REIMB_RESOLVER INTEGER references ERS_USERS(ERS_USER_ID) not null, 
	REIMB_STATUS_ID INTEGER references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID) not null, 
	REMI_TYPE_ID INTEGER references ERS_REIMBURSEMENT_TYPES(REIMB_TYPE_ID) not null 
);

create table if not exists ERS_REIMBURSEMENT_STATUS(
REIMB_STATUS_ID serial primary key not null,
REIMB_STATUS varchar(10) not null
);


create table if not exists ERS_REIMBURSEMENT_TYPES(
REIMB_TYPE_ID serial primary key not null,
REIMB_TYPE varchar(20) not null
);

create table if not exists ERS_Users(
	ERS_USER_ID Serial primary key not null,
	ERS_USERNAME VARCHAR(50) unique not null,
	ERS_PASSWORD VARCHAR(50) not null,
	USER_FIRST_NAME VARCHAR(50) not null,
	USER_LAST_NAME VARCHAR(100) not null,
	USER_EMAIL VARCHAR(150) unique not null,
	USER_ROLE_ID INTEGER references ERS_USER_ROLES(ERS_USER_ROLE_ID) 
);

insert into ERS_Users (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL) values ('Kriley12', 'pass', 'Kendrick', 'Riley', 'kriley2424@gmail.com');

create table if not exists ERS_USER_ROLES(
ERS_USER_ROLE_ID serial not null primary key,
USER_ROLE varchar(20) not null
);

