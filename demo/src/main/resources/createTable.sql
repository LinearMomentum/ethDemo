create table students(
                         id serial primary key ,
                         name varchar(32),
                         idCard varchar(32),
                         ethAccount varchar(64),
                         ethPassword varchar(64),
                         undergraduate1 varchar(64),
                         undergraduate2 varchar(64),
                         undergraduate3 varchar(64),
                         undergraduate4 varchar(64),
                         undergraduate5 varchar(64),
                         undergraduate6 varchar(64),
                         systemAccount varchar(64),
                         systemPassword varchar(64),
                         score integer default 0,
                         universityAndMajor integer


);

create table university(

                           id serial primary key ,
                           systemAccount varchar(64),
                           systemPassword varchar(64),
                           name varchar(32),
                           idCode varchar(32),
                           ethAccount varchar(64),
                           ethPassword varchar(64)


);

create table major(
                      id serial primary key ,
                      code integer,
                      name varchar(64)


);

create table university_major(
                                 id serial primary key ,
                                 universityId integer,
                                 majorId integer,
                                 studentNum integer,
                                 score integer



);


create table examInstitute(
                              id serial primary key,
                              systemAccount varchar(64),
                              systemPassword varchar(64),
                              ethAccount varchar(64),
                              ethPassword varchar(64)
)
;
create table admitted(
                         student integer,
                         university integer
)