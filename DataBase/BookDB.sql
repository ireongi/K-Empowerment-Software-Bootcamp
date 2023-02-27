CREATE database bookdb;
use bookdb;

create table book(
id int(11) not null primary key,
title varchar(50) not null,
publisher varchar(30) not null,
author varchar(30) not null
)

select * from book;