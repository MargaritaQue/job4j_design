create table books(
    id serial primary key,
    name varchar(255)
);

create table publishers(
    id serial primary key,
    name varchar(255)
);

create table books_publishers(
    id serial primary key,
    books_id int references books(id),
    publishers_id int references publishers(id)
);
