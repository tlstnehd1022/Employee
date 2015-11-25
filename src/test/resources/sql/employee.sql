select * from dept;

select * from emp;

select * from emp;

select * from member;





drop table member;

create table member(
	id int,
	email varchar(255),
	name varchar(255),
	password varchar(255),
	register_date date,
	constraint pk_id primary key(id)

);


create sequence member_id_seq


-- Create
insert into member
(id, email, name, password, register_date)
values
(member_id_seq.nextval, 'xxx@yyy', '홍길동', '1234', '2015/11/11');

-- Read
select * from member;

-- Update
update member
	set name = '홍순이',
		password = '9876'
	where id = 3

-- Delete
delete from member where id = '1';


--
-- city
--
drop table city;

create table city (
  id			numeric(11),
  name 			char(50),
  countrycode 	char(3),
  district 		char(30),
  population 	numeric(11),
  constraint city_pk_id primary key(id)
)

select * from city

delete from city;

insert into city
( 
  id,
  name,
  countrycode,
  district,
  population
)
values
(
	1,
	'seoul',
	'KOR',
	'Asia',
	99998
);


  select deptno,
      	 dname,
      	 loc
      	
    from dept 

    
 select *
 from city
 order by countrycode asc, name asc
 
 select rownum, c.*
 from city c
-- where rownum >= 11
-- and rownum <=20
 order by countrycode asc, name asc
 
 select out.*
   from (
   		select rownum rn,
   			   c.* 
   		  from (
   		  		select *
   		  		  from city 
   		  		 order by countrycode asc, 
   		  		 		  name asc
   		  	   ) c
   		) out
 where rn >=11
 and rn < 20
 
 select * from city order by countrycode asc, name asc
 
 
 
 create table country (
 	code			char(3),
 	name			char(52),
    continent 		char(50),
	region 			char(26),
	surfacearea 	numeric(10,2),
	indepyear 		numeric(6),
	population 		numeric(11),
	lifeexpectancy 	numeric(3,1),
	gnp				numeric(10,2),
	gnpold 			numeric(10,2),
	localname 		char(45),
	governmentform 	char(45),
	headofstate 	char(60),
	capital 		numeric(11),
	code2 			char(2),
	constraint pk_country_code primary key (code)
 )
 
 
 create table country (
  code	 			char(3) not null default '',
--  name 				char(52) not null default '',
--  continent 		enum('asia','europe','north america','africa','oceania','antarctica','south america') not null default 'asia',
--  region 			char(26) not null default '',
--  surfacearea 		numeric(10,2) not null default '0.00',
--  indepyear 		numeric(6) default null,
--  population 		numeric(11) not null default '0',
--  lifeexpectancy 	numeric(3,1) default null,
--  gnp 				numeric(10,2) default null,
--  gnpold 			numeric(10,2) default null,
--  localname 		char(45) not null default '',
--  governmentform 	char(45) not null default '',
--  headofstate 		char(60) default null,
--  capital 			numeric(11) default null,
--  code2 			char(2) not null default '',
  primary key (code)
) 