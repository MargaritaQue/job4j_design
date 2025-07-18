create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('fish_Акула-молот', 10950, '1828-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('mammal_Красная панда', 7300, '1821-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('reptile_Галапагосский игуана', 9125, '1825-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('mammal_Белый медведь', 13140, '1774-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('fish_Морской конек', 2190, '1758-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('fish_Карась', 2400, null);

select * from fauna where name LIKE '%fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';