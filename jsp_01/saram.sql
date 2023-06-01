
select * from DIVISION;

select * from PERSONAL;

create table person(
seq number not null primary key,
id varchar2(20) not null,
name varchar2(20) not null,
age number(3)
);

-- squence 자동증가
create sequence seq_person;
select seq_person.nextval from dual;

insert into person(seq, id, name, age)
values(seq_person.nextval, 'HONG', 'GILDONG', 30);
insert into person(seq, id, name, age)
values(seq_person.nextval, 'KIM', 'GILDONG', 31);

SELECT * FROM PERSON;

COMMIT