drop table design

create table design(
	NUM number primary key,
	AUTHOR varchar2(100) not null,
	TYPE varchar2(100) not null,
	TITLE varchar2(500) not null,
	CONTENT varchar2(4000),
	PASSWORD varchar2(12) not null,
	WRITEDATE date default sysdate,
	READCNT number default 0,
	REP_ROOT number default 0,
	REP_STEP number default 0,
	REP_INDENT number default 0
);

drop sequence design_num;

-- sequence 생성
create sequence design_num
start with 1 
increment by 1
maxvalue 99999
nocache
nocycle
noorder;

-- 내용 입력
insert into design(NUM, AUTHOR, TYPE, TITLE, CONTENT, PASSWORD)
values (design_num.nextval, '김포샵', '디자인일반', '디자인은 무엇인가?', '디자인역사부터 공부해보자!', 'abc1234');
insert into design(NUM, AUTHOR, TYPE, TITLE, CONTENT, PASSWORD)
values (design_num.nextval, '김조교', '디자인일반', '디자인 종류를 알아보자!', '디자인 종류는 0가지로 나누어져 있다.', 'abc1234');
insert into design(NUM, AUTHOR, TYPE, TITLE, CONTENT, PASSWORD)
values (design_num.nextval, '김포샵', '디자인철학', '현대디자인의 관점은??', '과거와 달리 한국 디자인은 OOO이었다는 속설이었다.', 'abc1234');


-- 데이터 수정
update design set TYPE = '디자인일반', TITLE = '황교수 디자인을 파해보자', CONTENT = '황교수는 000년 00월에 OO에서 출생했다.'
where NUM = 2;

-- 삭제 기능
delete design where NUM = 4;

-- 검색 기능
select * from design where NUM = 1;

-- 내용 확인
select * from design; 

commit