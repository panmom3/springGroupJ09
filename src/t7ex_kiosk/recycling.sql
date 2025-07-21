show tables;

create table recycling (
	userID varchar(20) not null auto_increment primary key,  /*사용자아이디*/
	name varchar(20) not null,  /*이름*/
	phoneNumber varchar(20),		/*전화번호*/
	address varchar(20),       /*주소*/
	product varchar(20) not null, /*상품분류*/
	points int,                /*적립포인트*/
	count int not null,
	createdAt datetime default now()  /*등록일*/
	);
)

desc recycling;