-- table
drop table sarma;
create table saram(
seq number not null primary key,
id varchar2(20) not null,
name varchar2(20),
email varchar2(100)
);

-- sequence
drop sequence seq_saram;
create sequence seq_saram;

insert into saram(seq, id, name, email)
values(seq_saram.nextval, 'user01','hong gildong','user01@saram.com');
insert into saram(seq, id, name, email)
values(seq_saram.nextval, 'user02','kim','user02@saram.com');
insert into saram(seq, id, name, email)
values(seq_saram.nextval, 'user03','lee','user03@saram.com');

UPDATE SARAM SET ID='KIM', NAME='김길동', EMAIL='KIM@SARAM.COM' WHERE SEQ=2;

select * from saram;

commit