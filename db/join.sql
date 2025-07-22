create table departments
(
    id   serial primary key,
    name varchar(255)
);

create table employees
(
    id       serial primary key,
    name     varchar(255),
    departments_id int references departments (id)
);

insert into departments(name)
values ('departments 1');
insert into departments(name)
values ('departments 2');
insert into departments(name)
values ('departments 3');

insert into employees(name, departments_id)
values ('employees 1', 1);
insert into employees(name, departments_id)
values ('employees 2', null);
insert into employees(name, departments_id)
values ('employees 3', 3);
insert into employees(name, departments_id)
values ('employees 4', 3);
insert into employees(name, departments_id)
values ('employees 5', 2);
insert into employees(name, departments_id)
values ('employees 6', null);

select * from employees e
         left join departments d on e.departments_id = d.id;

select * from departments d
         right join employees e on e.departments_id = d.id;

select * from employees e
         full join departments d on e.departments_id = d.id;

select * from employees e
         cross join departments d;

select * from employees e
         left join departments d on e.departments_id = d.id
where d.id is null;

select d.name, e.name
from departments d
left join employees e on d.id = e.departments_id;

select d.name, e.name
from employees e
right join departments d on d.id = e.departments_id;


create table teens(
    id   serial primary key,
    name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender)
values ('Alica', 'W'), ('Maria', 'W'),('Petr', 'M'),('Egor', 'M');

select t1.name, t2.name
from teens t1
join teens t2 on t1.id < t2.id
where t1.gender <> t2.gender;

