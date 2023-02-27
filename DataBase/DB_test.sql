CREATE database dbtest;

USE dbtest;  # 활성 DB 지정

CREATE TABLE 고객 (
   고객아이디  VARCHAR(20)    NOT NULL,
   고객이름    VARCHAR(10)    NOT NULL,
   나이       INT,
   등급       VARCHAR(10)    NOT NULL,
   직업       VARCHAR(20),
   적립금       INT   DEFAULT 0,
   PRIMARY KEY(고객아이디)
);

CREATE TABLE  제품 (
   제품번호   CHAR(3)   NOT NULL,
   제품명     VARCHAR(20),
   재고량     INT,
   단가       INT,
   제조업체   VARCHAR(20),
   PRIMARY KEY(제품번호),
   CHECK (재고량 >= 0 AND 재고량 <=10000)
);

CREATE TABLE  주문 (
	주문번호   CHAR(3) NOT NULL,
	주문고객   VARCHAR(20),
	주문제품   CHAR(3),
	수량       INT,
	배송지     VARCHAR(30),
	주문일자   DATE,
	PRIMARY KEY(주문번호),
	FOREIGN KEY(주문고객)   REFERENCES   고객(고객아이디),
	FOREIGN KEY(주문제품)   REFERENCES   제품(제품번호)
);

CREATE TABLE  배송업체 (
	업체번호   CHAR(3) NOT NULL,
	업체명     VARCHAR(20),
	주소       VARCHAR(100),
	전화번호   VARCHAR(20),
	PRIMARY KEY(업체번호)
);

alter table 고객 add 가입날짜 date; # 항목 추가
select * from 고객;
alter table 고객 drop column 가입날짜; # 항목 삭제

alter table 고객 add constraint chk_age check(나이>=20); # 조건 추가
alter table 고객 drop constraint chk_age; # 조건 삭제

alter table 고객 drop column 가입날짜;

drop table 배송업체;

