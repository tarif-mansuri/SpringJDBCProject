create table person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	 primary key(id)
);

insert into person(id,name,location,birth_date)
values(10001,'Nafees bhai','Calicut',sysdate());
insert into person(id,name,location,birth_date)
values(10002,'Ashiq bhai','Trichy',sysdate());
insert into person(id,name,location,birth_date)
values(10003,'Anees bhai','Surthkal',sysdate());