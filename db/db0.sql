create table users(
	id serial primary key,
	name varchar(255),
	age integer,
	height real,
	married boolean
);
insert into users(name, age, height, married) values('Margarita', 25, 177.0, false);
update users set age = 24;
delete from users;
