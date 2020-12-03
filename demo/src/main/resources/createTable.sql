create table students(
                         id serial primary key ,
                         name varchar(32),
                         idcard varchar(32),
                         ethaccount varchar(64),
                         undergraduate1 integer,
                         undergraduate2 integer,
                         undergraduate3 integer,
                         undergraduate4 integer,
                         undergraduate5 integer,
                         undergraduate6 integer,
                         systemaccount varchar(64),
                         systempassword varchar(64),
                         score integer default 0,
                         ethpassword varchar(64),
                         universityandmajor integer


);

create table university(

                           id serial primary key ,
                           name varchar(32),
                           idcode varchar(32),
                           ethaccount varchar(64),
                           ethpassword varchar(64),
                           systemaccount varchar(64),
                           systempassword varchar(64)


);

create table major(
                      id serial primary key ,
                      code integer,
                      name varchar(64)


);

create table university_major(
                                 id serial primary key ,
                                 universityid integer,
                                 majorid integer,
                                 studentnum integer,
                                 score integer



);


create table examInstitute(
                              id serial primary key,
                              ethaccount varchar(64),
                              systemaccount varchar(64),
                              systempassword varchar(64),
                              ethpassword varchar(64)
)
;
create table admitted(
                         student integer,
                         university integer
)