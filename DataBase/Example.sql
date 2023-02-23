create database sampledb;
use sampledb;

create table student
( name varchar(10) not null , 
dept varchar(20) not null, 
id varchar(7) not null,
primary key(id) ) 

engine = innoDB default character set = utf8;

insert into student(name, dept, id) values('홍길동', '체육학과', '1111111');

select * from student;

insert into student(name, dept, id) values('최고봉', '멀티미디어', '0792012');

insert into student(name, dept, id) values('이기자', '경제학과', '1233211');

select * from student;

update student set dept = '건축공학' where id = '0792012';

delete from student where name = '최고봉';
select * from student;

delete from student where id = '1111111';

commit;

select * from student;