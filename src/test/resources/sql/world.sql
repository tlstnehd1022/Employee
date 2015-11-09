select * from city;

select * from country;

select count(*) from country;

drop table member;

create table member(
	id int auto_increment,
	email varchar(255),
	name varchar(255),
	password varchar(255),
	register_date date,
	constraint pk_id primary key(id)

);

insert into member
(email, name, password, register_date)
values
('xxx@yyy', '홍길동', '1234', '2015/11/11');

select * from member