show tables;

create table recycling (
	userID varchar(20) not null,  /*사용자아이디*/
	name varchar(20) not null,  /*이름*/
	address varchar(20),       /*주소*/
	product varchar(20) not null, /*상품분류*/
	count int not null,				/* 수량 */
	points int default 10,                /*적립포인트*/
	createdAt datetime default now()  /*등록일*/
);


desc recycling;

select * from recycling;

alter table recycling change column userID varchar(20);
alter table recycling change column points default 10;

delete from recycling;

drop table recycling;