create table userProfile(
    id serial primary key,
    seria int,
    number int
);

create table users(
    id serial primary key,
    name varchar(255),
    userProfile_id int references userProfile(id) unique
);