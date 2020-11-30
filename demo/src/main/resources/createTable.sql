create table students(
                         id serial primary key ,
                         name varchar(32),
                         idCard varchar(32),
                         ethAccount varchar(64),
                         advance1 varchar(64),
                         advance2 varchar(64),
                         advance3 varchar(64),
                         undergraduate1 varchar(64),
                         undergraduate2 varchar(64),
                         undergraduate3 varchar(64),
                         undergraduate4 varchar(64),
                         undergraduate5 varchar(64),
                         undergraduate6 varchar(64),
                         password varchar(32),
                         score integer default 0
);

create table university(
                           id serial primary key ,
                           name varchar(32),
                           idCode varchar(32),
                           ethAccount varchar(64),
                           quota integer
);

create table examInstitute(
                              id serial primary key,
                              ethAccount varchar(64)
)
;
create table admitted(
    student integer,
    university integer
)