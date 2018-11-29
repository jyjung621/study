show databases;

use opentutorials;

show tables;

drop table board;
drop table member;
drop table moneybook;
drop table category;


create table `opentutorials`.`board` (
	boardNo 	int(8) primary key,
    title 		varchar(200) NOT NULL,
    content 	varchar(4000),
    hits		int(4),
    likeCnt		int(4),
    memberId	varchar(20),
    regDate		date
);

create table `opentutorials`.`member` (
	email		varchar(200) primary key,
    passwd		varchar(20) not null,
    nickname	varchar(40) not null,
    phone		varchar(20),
    grade		varchar(10),
    regDate		date
);

CREATE TABLE `opentutorials`.`moneybook` (
  `bookNo` INT(8) NOT NULL,
  `kinds` INT(2) NOT NULL DEFAULT 0,
  `userId` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `parentBook` VARCHAR(45) NULL,
  `regDate` VARCHAR(45) NULL,
  PRIMARY KEY (`bookNo`, `kinds`, `userId`));

CREATE TABLE `opentutorials`.`category` (
  `categoryNo` INT(8) NOT NULL,
  `kinds` INT(2) NOT NULL DEFAULT 0,
  `userId` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`categoryNo`, `kinds`, `userId`));


commit;



insert into board values (1,'게시글1','게시글1내용1',0,0,'rucy',now());
insert into board values (2,'게시글2','게시글2내용1',0,0,'rucy',now());
insert into board values (3,'게시글3','게시글3내용1',0,0,'rucy',now());
insert into board values (4,'게시글4','게시글4내용1',0,0,'rucy',sysdate());
insert into board values (fn_maxTablenum('board'),'게시글test2','게시글test2내용test2',0,0,'test',sysdate());

insert into member values ('jyjung621@gmail.com', '1234', 'rucy', '01012345678', '1', sysdate());


select * from member;
select * from board order by regDate desc;

delete from board where boardno=5;

insert into board (boardNo, title, content, memberId, regDate) values (5, '게시글5', '게시글5내용1', 'rucy', sysdate());

select sysdate(), now() from dual;

select fn_maxTablenum('board') from dual;show tables
