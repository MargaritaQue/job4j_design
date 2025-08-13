CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name) VALUES
(1, 'Tech Innovators'),
(2, 'Green Solutions'),
(3, 'HealthCare Inc.'),
(4, 'EduTech'),
(5, 'Finance Corp'),
(6, 'AutoMakers'),
(7, 'Foodies');

INSERT INTO person (id, name, company_id) VALUES
(1, 'Иван Иванов', 1),
(2, 'Мария Петрова', 1),
(3, 'Алексей Смирнов', 2),
(4, 'Ольга Кузнецова', 3),
(5, 'Дмитрий Лебедев', NULL),
(6, 'Сергей Иванов', 4),
(7, 'Елена Кузнецова', 4),
(8, 'Павел Смирнов', 5),
(9, 'Анна Лебедева', 5),
(10, 'Михаил Петров', 6),
(11, 'Оксана Воронова', 6),
(12, 'Дмитрий Сидоров', 7),
(13, 'Наталья Григорьева', 7),
(14, 'Игорь Федоров', NULL),
(15, 'Марина Васильева', NULL);

select p.name, c.name
from person p
left join company c on p.company_id = c.id
where p.company_id != 5 or p.company_id is null;

select
    c.name as company_name,
    count(p.id) as person_count
from
    company c
left join
    person p on p.company_id = c.id
group by
    c.id, c.name
having
    count(p.id) = (
        select max(cnt)
        from (
            select count(p2.id) as cnt
            from company c2
            left join person p2 on p2.company_id = c2.id
            group by c2.id
        ) as counts
    );