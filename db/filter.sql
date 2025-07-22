create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expired_date timestamp,
	price float
);

insert into type(name) values ('СЫР'), ('МЯСО'), ('МОЛОКО');
insert into product(name, type_id, expired_date, price) values
('Сыр моцарелла', 1, '2025-08-20', 300);
insert into product(name, type_id, expired_date, price) values
('Сыр плавленный', 1, '2025-07-18', 250);
insert into product(name, type_id, expired_date, price) values
('Говядина', 2, '2025-05-02', 700);
insert into product(name, type_id, expired_date, price) values
('Свинина', 2, '2025-08-02', 600);
insert into product(name, type_id, expired_date, price) values
('Молоко 3,2%', 3, '2025-01-02', 100);
insert into product(name, type_id, expired_date, price) values
('Мороженое', 3, '2025-01-02', 60);
insert into product(name, type_id, expired_date, price) values
('Жадина', 2, '2025-05-02', 700);

select p.*
from product p
join type t
on p.type_id = t.id
where t.name = 'СЫР'

select * from product where name like '%Мороженое%';
select * from product where expired_date < CURRENT_DATE;
select * from product where price = (select max(price) from product);

select t.name as имя_типа, count(p.type_id) as количество
from type t
join product as p
on t.id = p.type_id
group by t.name;

select p.*
from product p
join type t
on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name as имя_типа, count(p.type_id) as количество
from type t
join product as p
on t.id = p.type_id
group by t.name
having count(p.type_id) < 10;

select p.name, t.name
from type t
join product as p
on t.id = p.type_id
group by p.name, t.name;












