create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values ('Телефон', 3000), ('Планшет', 5000), ('Ноутбук', 10000);
insert into people(name) values ('Антон'), ('Аня'), ('Мария');
insert into devices_people(people_id, device_id) values (1, 1), (1, 2);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (3, 1), (3, 2), (3, 3);

select avg(price) from devices;

select p.name, avg(d.price)
from people as p
join devices_people as dp
on p.id = dp.people_id
join devices d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;




