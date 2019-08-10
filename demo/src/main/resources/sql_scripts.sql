drop Table employee;

create Table employee
(
emp_id bigint(20) NOT NULL AUTO_INCREMENT,
emp_user_name VARCHAR(30) NOT NULL,
emp_first_name VARCHAR(50) NOT NULL,
emp_second_name VARCHAR(50) NOT NULL,
emp_password VARCHAR(255) NOT NULL,
emp_contact_no VARCHAR(30),
emp_mail_id VARCHAR(50),
emp_status VARCHAR(10),
emp_dob date,
emp_is_enabled boolean,
emp_created_by VARCHAR(10),
emp_created_date date,
emp_updated_by VARCHAR(10),
emp_updated_date date,
CONSTRAINT employee_pk PRIMARY KEY (emp_id),
CONSTRAINT employee_uk UNIQUE (emp_user_name)
);

insert into employee (emp_user_name, emp_first_name, emp_second_name, emp_password, emp_contact_no, emp_mail_id, emp_status, emp_dob, emp_is_enabled, emp_created_by, emp_created_date) Values('51314542', 'Nandhagopal', 'Thangavelu', '$2a$10$BGanh8GG83H3Husm9sLSLugWxu123M.gu1jYXwfTsNuGBLhDIoOMi', '93374742', 'tnandhagopal@gmail.com', 'NEW',DATE('1986-06-21'), true,'ADMIN',CURRENT_TIMESTAMP( ));

insert into employee (emp_user_name, emp_first_name, emp_second_name, emp_password, emp_contact_no, emp_mail_id, emp_status, emp_dob, emp_is_enabled, emp_created_by, emp_created_date) Values('51314543', 'Adhavan', 'Nandhagopal', '$2a$10$kyCFNCmS0dWSCc2HKGK0AO4gcDwOiW30D6zxbqpyn1s6FUBNRmoUS', '12345678', 'adhavannandhagopal@gmail.com', 'NEW',DATE('2017-01-01'), true,'ADMIN',CURRENT_TIMESTAMP( ));


select * from employee;


drop table project;

CREATE table project(
pro_id bigint(20) NOT NULL AUTO_INCREMENT,
pro_code VARCHAR(10) NOT NULL,
pro_name VARCHAR(50)  NOT NULL,
pro_created_by VARCHAR(10),
pro_created_date date,
pro_updated_by VARCHAR(10),
pro_updated_date date,
CONSTRAINT project_pk PRIMARY KEY (pro_id),
CONSTRAINT project_uk UNIQUE (pro_code)
);

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('ABC1001', 'JAVA Development', 'ADMIN', CURRENT_TIMESTAMP( ));

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('ABC1002', 'JAVA Testing', 'ADMIN', CURRENT_TIMESTAMP( ));

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('ABC1003', 'Oracle Development', 'ADMIN', CURRENT_TIMESTAMP( ));

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('XYZ1001', 'Oracle Testing', 'ADMIN', CURRENT_TIMESTAMP( ));

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('SQW1001', 'Perl Development', 'ADMIN', CURRENT_TIMESTAMP( ));

insert into project(pro_code, pro_name, pro_created_by, pro_created_date) Values('RTS1001', 'Perl Testing', 'ADMIN', CURRENT_TIMESTAMP( ));


drop table Employee_Project;

create table Employee_Project(
ep_id bigint(20) NOT NULL AUTO_INCREMENT,
ep_emp_id bigint(20) NOT NULL,
ep_pro_id bigint(20) NOT NULL,
ep_start_date date NOT NULL,
ep_end_date date NOT NULL,
ep_created_by VARCHAR(10),
ep_created_date date,
ep_updated_by VARCHAR(10),
ep_updated_date date,
CONSTRAINT ep_pk PRIMARY KEY (ep_id),
CONSTRAINT ep_uk UNIQUE (ep_emp_id, ep_pro_id),
CONSTRAINT ep_emp_fk FOREIGN KEY (ep_emp_id) REFERENCES employee(emp_id),
CONSTRAINT ep_pro_fk FOREIGN KEY (ep_pro_id) REFERENCES project(pro_id)
);

insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314542'), (select pro_id from project where pro_code = 'ABC1001' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());

insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314542'), (select pro_id from project where pro_code = 'ABC1003' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());


insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314542'), (select pro_id from project where pro_code = 'ABC1002' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());


insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314543'), (select pro_id from project where pro_code = 'RTS1001' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());


insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314543'), (select pro_id from project where pro_code = 'XYZ1001' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());


insert into Employee_Project(ep_emp_id, ep_pro_id, ep_start_date, ep_end_date, ep_created_by, ep_created_date) values((select emp_id from employee where emp_user_name='51314543'), (select pro_id from project where pro_code = 'SQW1001' ),DATE('2018-06-21'), DATE('2020-06-21'),  'ADMIN', CURRENT_TIMESTAMP());


drop table Employee_Time_Sheet;

create table Employee_Time_Sheet(
	ets_id bigint(20) NOT NULL AUTO_INCREMENT,
	ets_ep_id bigint(20) NOT NULL,
	ets_date date NOT NULL,
	ets_time int,
	ets_created_by VARCHAR(10),
	ets_created_date date,
	ets_updated_by VARCHAR(10),
	ets_updated_date date,
	CONSTRAINT ets_pk PRIMARY KEY (ets_id),
	CONSTRAINT ets_uk UNIQUE (ets_ep_id, ets_date),
	CONSTRAINT ets_ep_fk FOREIGN KEY (ets_ep_id) REFERENCES Employee_Project(ep_id)	
);


insert into Employee_Time_Sheet(ets_ep_id, ets_date, ets_time, ets_created_by, ets_created_date) values((select ep_id from employee, employee_project, project where emp_user_name='51314542' and ep_emp_id = emp_id and pro_id = ep_pro_id and pro_code ='ABC1001'), DATE('2019-05-01'),8, 'ADMIN', CURRENT_TIMESTAMP());


drop table Employee_Leave;

create table Employee_Leave(
el_id bigint(20) NOT NULL AUTO_INCREMENT,
el_emp_id bigint(20) NOT NULL,
el_date date NOT NULL,
el_status VARCHAR(10),
el_created_by VARCHAR(10),
el_created_date date,
el_updated_by VARCHAR(10),
el_updated_date date,
CONSTRAINT el_pk PRIMARY KEY (el_id),
CONSTRAINT el_uk UNIQUE (el_emp_id, el_date),
CONSTRAINT el_emp_fk FOREIGN KEY (el_emp_id) REFERENCES employee(emp_id)
);

drop table Role;

create table Role(
role_id bigint(20) NOT NULL AUTO_INCREMENT,
role_name VARCHAR(10),
role_created_by VARCHAR(10),
role_created_date date,
role_updated_by VARCHAR(10),
role_updated_date date,
CONSTRAINT role_pk PRIMARY KEY (role_id),
CONSTRAINT role_uk UNIQUE (role_name)
);

insert into Role (role_name, role_created_by, role_created_date) values('USER','ADMIN',CURRENT_TIMESTAMP());
insert into Role (role_name, role_created_by, role_created_date) values('ADMIN','ADMIN',CURRENT_TIMESTAMP());

drop table Employee_role;

create table Employee_role(
er_id bigint(20) NOT NULL AUTO_INCREMENT,
er_emp_id bigint(20) NOT NULL,
er_role_id bigint(20) NOT NULL,
er_created_by VARCHAR(10),
er_created_date date,
er_updated_by VARCHAR(10),
er_updated_date date,
CONSTRAINT er_pk PRIMARY KEY (er_id),
CONSTRAINT er_uk UNIQUE (er_emp_id, er_role_id),
CONSTRAINT er_emp_fk FOREIGN KEY (er_emp_id) REFERENCES employee(emp_id),
CONSTRAINT er_role_fk FOREIGN KEY (er_role_id) REFERENCES Role(role_id)
);

insert into Employee_role (er_emp_id, er_role_id, er_created_by, er_created_date) Values((select emp_id from employee where emp_user_name='51314542'), (select role_id from role where role_name='USER'),'ADMIN',CURRENT_TIMESTAMP());

insert into Employee_role (er_emp_id, er_role_id, er_created_by, er_created_date) Values((select emp_id from employee where emp_user_name='51314542'), (select role_id from role where role_name='ADMIN'),'ADMIN',CURRENT_TIMESTAMP());

insert into Employee_role (er_emp_id, er_role_id, er_created_by, er_created_date) Values((select emp_id from employee where emp_user_name='51314543'), (select role_id from role where role_name='USER'),'ADMIN',CURRENT_TIMESTAMP());


select COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME, REFERENCED_TABLE_NAME from information_schema.KEY_COLUMN_USAGE where TABLE_NAME = 'EMPLOYEE_ROLE';