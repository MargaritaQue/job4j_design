insert into users(name) values ('Ivan', 1);
insert into users(name) values ('Alex', 2);

insert into roles(name, users_id) VALUES ('Администратор системы', 1);
insert into roles(name, users_id) VALUES ('	Специалист поддержки', 2);

insert into rules(name) values ('Создавать новые заявки');
insert into rules(name) values ('Просматривать заявки');
insert into rules(name) values ('Удалять заявки');

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (1, 2);
insert into roles_rules(roles_id, rules_id) values (1, 3);
insert into roles_rules(roles_id, rules_id) values (2, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);

insert into items(name) values ('Техническая проблема', 1, 1, 1, 2);
insert into items(name) values ('Запрос на обслуживание', 2, 2, 1, 1);

insert into comments(name) values ('Ошибки в программном обеспечении, сбои оборудования');
insert into comments(name) values ('Требование провести техническое обслуживание или ремонт');

insert into attachs(name) values ('error_screenshot.png');
insert into attachs(name) values ('log.txt');

insert into categories(name) values ('IT Support');
insert into categories(name) values ('Финансовые заявки');

insert into states(name) values ('В работе');
insert into states(name) values ('Закрыта');
