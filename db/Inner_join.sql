CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publish_year INT,
    author_id INT REFERENCES authors(id)
);

INSERT INTO authors (name, birth_date) VALUES
('Лев Толстой', '1828-09-09'),
('Федор Достоевский', '1821-11-11'),
('Александр Пушкин', '1799-06-06');

INSERT INTO books (title, publish_year, author_id) VALUES
('Война и мир', 1869, 1),
('Анна Каренина', 1877, 1),
('Преступление и наказание', 1866, 2),
('Братья Карамазовы', 1880, 2),
('Евгений Онегин', 1833, 3),
('Руслан и Людмила', 1820, 3);
INSERT INTO books (title, publish_year) VALUES ('Маленький принц', 1942);

select p.name, pp.title, pp.publish_year
from books as pp join authors as p on pp.author_id = p.id;

select p.name as Автор, pp.title as Название, pp.publish_year as Дата
from books as pp join authors as p on pp.author_id = p.id;

select p.name as "Автор произведения", pp.title as Название, pp.publish_year as "Дата публикации"
from books as pp join authors as p on pp.author_id = p.id;

