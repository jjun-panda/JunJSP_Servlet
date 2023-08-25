drop table member

-- member 테이블 생성
create table member(
seq number primary key,
name varchar2(20) not null,
height number(3) not null,
weight number(3) not null,
age number(3),
gender char(3) default 'F' check(gender in('M', 'F')) 
);

drop sequence mem_seq;

-- sequence 생성
create sequence mem_seq start with 1 increment by 1;

-- 내용 입력
insert into member(seq, name, height, weight, age)
values (mem_seq.nextval, 'Yoo', 167, 45, 18);
insert into member(seq, name, height, weight, age)
values (mem_seq.nextval, 'Kim', 157, 65, 19);
insert into member(seq, name, height, weight, age, gender)
values (mem_seq.nextval, 'Lee', 171, 75, 22, 'M');
insert into member(seq, name, height, weight, age, gender)
values (mem_seq.nextval, 'Ha', 174, 71, 21, 'M');


-- 데이터 수정
update member set name = 'Hong', height = 170, weight = 75, age = 20, gender = 'M'
where seq = 103;

-- 삭제 기능
delete member where seq = 103;

-- 검색 기능
select * from member where seq = 103;

-- 내용 확인
select * from member; 

commit