create table customers(
	id   serial primary key,
    name varchar(255),
	city varchar(255)
);

create table categories(
	id   serial primary key,
    name varchar(255)
);

create table products(
	id   serial primary key,
    name varchar(255),
	price float,
	category_id int references categories (id)  
);

create table orders(
	id   serial primary key,
	customer_id int references customers (id),
	order_date date
);

create table order_items(
	order_id int references orders (id),
	product_id int references products (id),
	quantity int
);

insert into categories values
(1, 'Электроника'),
(2, 'Одежда'),
(3, 'Книги');

insert into products values
(1, 'Смартфон', 15000, 1),
(2, 'Ноутбук', 40000, 1),
(3, 'Футболка', 500, 2),
(4, 'Книга "SQL для начинающих"', 700, 3),
(5, 'Планшет', 20000, 1);

insert into customers values
(1, 'Иван Иванов', 'Москва'),
(2, 'Петр Петров', 'Санкт-Петербург'),
(3, 'Мария Смирнова', 'Москва');

insert into orders values
(1, 1, '2024-01-15'),
(2, 1, '2024-02-10'),
(3, 2, '2024-01-20'),
(4, 3, '2024-02-05');

insert into order_items values
(1, 1, 1),
(1, 3, 2),
(2, 2, 1), 
(3, 4, 3), 
(4, 5, 1);

create view customer_category_spending as
select 
    c.id as customer_id,
    c.name as customer_name,
    c.city,
    cat.name as category_name,
    sum(oi.quantity * p.price) as total_spent
from customers c
join orders o on c.id = o.customer_id
join order_items oi on o.id = oi.order_id
join products p on oi.product_id = p.id
join categories cat on p.category_id = cat.id
group by c.id, c.name, c.city, cat.name;

select customer_id, customer_name, total_spent
from customer_category_spending
where city = 'Москва'
  and category_name = 'Электроника'
  and total_spent > 10000;



