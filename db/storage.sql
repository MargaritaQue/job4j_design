create table car_bodies(
	id   serial primary key,
    name varchar(255)
);

create table car_engines(
	id   serial primary key,
    name varchar(255)
);

create table car_transmissions(
	id   serial primary key,
    name varchar(255)
);

create table cars(
	id   serial primary key,
    name varchar(255),
	body_id int references car_bodies (id),
	engine_id int references car_engines (id),
	transmission_id int references car_transmissions (id)
);

insert into car_bodies (name) values
('Sedan'),
('Hatchback'),
('SUV'),
('Coupe'),
('СЕДАН');

insert into car_engines (name) values
('Petrol 1.6L'),
('Diesel 2.0L'),
('Electric 100kW'),
('Hybrid 1.8L'),
('ГИБРИД');

insert into car_transmissions (name) values
('Manual'),
('Automatic'),
('CVT'),
('ЦВТ');

insert into cars (name, body_id, engine_id, transmission_id) values
('Model A', 1, 1, 2),
('Model B', 2, 2, 1),
('Model C', 3, 3, 3),
('Model D', 4, 4, 2);

insert into cars (name, body_id, engine_id, transmission_id) values
('Model E', null, 4, 2);

insert into cars (name, body_id, engine_id) values
('Model F', 4, 2);

select c.id,
	c.name as car_name,
    cb.name as body_name,
    ce.name as engine_name,
    ct.name as transmission_name
from
    cars c
left join
    car_bodies cb on c.body_id = cb.id
left join
    car_engines ce on c.engine_id = ce.id
left join
    car_transmissions ct on c.transmission_id = ct.id;

select cb.id, cb.name
from car_bodies cb
left join cars c on cb.id = c.body_id
where c.body_id is null;

select cb.name
from car_bodies cb
left join cars c on cb.id = c.body_id
where c.body_id is null;

select ce.name
from car_engines ce
left join cars c on ce.id = c.engine_id
where c.engine_id is null;

select ct.name
from car_transmissions ct
left join cars c on ct.id = c.transmission_id
where c.transmission_id is null;







