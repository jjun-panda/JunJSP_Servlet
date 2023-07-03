drop table design

create table design(
SEQ number primary key,
NAME varchar2(50) not null,
TYPE varchar2(20) not null,
AUTHOR varchar2(10) not null,
CONTENT varchar2(1024),
REGDATE date,
CNT number default 0
);

drop sequence design_seq;

-- sequence 생성
create sequence design_seq
start with 1 
increment by 1
maxvalue 99999
nocache
nocycle
noorder;

-- 내용 입력
insert into design(SEQ, NAME, TYPE, AUTHOR, CONTENT, REGDATE, CNT)
values (design_seq.nextval, '디자인은 무엇인가?', '디자인일반', '김포샵', '디자인역사부터 공부해보자!', sysdate, 0);
insert into design(SEQ, NAME, TYPE, AUTHOR, CONTENT, REGDATE, CNT)
values (design_seq.nextval, '디자인 종류를 알아보자!', '디자인일반', '김조교', '디자인 종류는 0가지로 나누어져 있다.', sysdate, 0);
insert into design(SEQ, NAME, TYPE, AUTHOR, CONTENT, REGDATE, CNT)
values (design_seq.nextval, '현대디자인의 관점은??', '디자인철학', '김포샵', '과거와 달리 한국 디자인은 OOO이었다는 속설이었다.', sysdate, 0);


-- 데이터 수정
update design set NAME = '황교수 디자인을 파해보자', TYPE = '디자인일반', AUTHOR = '황교수', CONTENT = '황교수는 000년 00월에 OO에서 출생했다.'
where SEQ = 2;

-- 삭제 기능
delete design where seq = 4;

-- 검색 기능
select * from design where seq = 1;

-- 내용 확인
select * from design; 

commit