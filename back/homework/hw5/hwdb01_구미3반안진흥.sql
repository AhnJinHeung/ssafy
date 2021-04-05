use ssafyweb;

DROP TABLE `product_info`;

create table `product_info` (
`code` varchar(30) NOT NULL,
`pname` varchar(30) NOT NULL,
`price` int NOT NULL,
`discription` varchar(100) default NULL,
PRIMARY KEY (`code`)
);

insert into product_info values
('A1', 'aaaa', 1000, '상품 1번 입니다.'),
('B1', 'bbbb', 2000, '상품 2번 입니다.'),
('C1', 'cccc', 4000, '상품 3번 입니다.'),
('D1', 'dddd', 3000, '상품 4번 입니다.'),
('F1', 'ffff', 5000, '상품 5번 입니다.');

select * from product_info;

update product_info set `pname`='삼성 노트북' where `code`='A1';
update product_info set `pname`='엘지 노트북' where `code`='B1';
update product_info set `pname`='레노버 노트북' where `code`='C1';
update product_info set `pname`='삼성 TV' where `code`='D1';
update product_info set `pname`='엘지 TV' where `code`='F1';

select `code` as '상품 코드', `pname` as '상품명', `price` * 0.85 as '세일 가격', `discription` as '상품 설명'
from product_info;

update product_info
set `price`=`price`*0.8
where `pname`
like '%TV%';

select * from product_info;

select sum(`price`) as '총 금액'
from product_info;