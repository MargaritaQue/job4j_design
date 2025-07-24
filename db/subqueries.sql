CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers values (1, 'Maria', 'Marp', 23, 'Russia');
insert into customers values (2, 'Fedya', 'Carf', 20, 'USA');
insert into customers values (3, 'Petr', 'Ghir', 30, 'Russia');
insert into customers values (4, 'Mark', 'Rarp', 45, 'USA');
insert into customers values (5, 'Alice', 'Frr', 20, 'USA');

select first_name, last_name from customers
where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders values (1, 2, 1);
insert into orders values (2, 3, 2);

select id, first_name, last_name from customers
where id not in (select customer_id from orders);