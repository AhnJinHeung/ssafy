drop database if exists ssafy_ws_5th;
create database ssafy_ws_5th;
use ssafy_ws_5th;

CREATE TABLE `book` (
  `isbn` char(12) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `describ` text,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
);


CREATE TABLE `user` (
  `id` varchar(50),
  `name` varchar(45) NOT NULL,
  `pass` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

insert into user (id, name, pass) values('ssafy','홍싸피','1234');

select * from user;
commit;