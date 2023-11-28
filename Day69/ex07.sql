create SEQUENCE book_seq
    start WITH 1001
    increment by 1
    minvalue 1001
    maxvalue 9999
    nocache;
    
create TABLE book (
    idx         number          default book_seq.nextval,
    title       VARCHAR2(50)    not null,
    writer      varchar2(50)    not null,
    publisher   VARCHAR2(50)    not null,
    p_date      date            not null,
    price       number,
    constraint book_idx primary key(idx)
);    

insert into book values (default, '고구려왕조실록', '박영규', '웅진지식하우스', '2004-11-18', 15120);
insert into book values (default, '백제왕조실록', '박영규', '웅진닷컴', '2004-11-18', 15120);
insert into book values (default, '신라왕조실록', '박영규', '웅진지식하우스', '2004-11-18', 16200);
insert into book values (default, '발해고', '홍익', '유득공', '2021-02-19', 13500);

select * from book;

commit;

desc book;