drop table blog

create table blog(
id number primary key,
author varchar2(20),
title varchar2(100),
content varchar2(256)
);

drop sequence blog_seq

create sequence blog_seq start with 100 increment by 1;

select blog_seq.nextval from dual;

insert into blog(id, author, title, content)
values(blog_seq.nextval, 'HONG', '블로그 테스트', '블로그 테스트 내용');

insert into blog(id, author, title, content)
values(blog_seq.nextval, 'KIM', 'KIM KIM KIM', 'KIM KIM KIM KIM');

insert into blog(id, author, title, content)
values(blog_seq.nextval, 'LEE', 'LEE LEE LEE', 'LEE LEE LEE LEE');

select * from blog

commit