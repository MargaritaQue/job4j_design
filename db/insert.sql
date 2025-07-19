insert into rules(name) values ('Создавать новые заявки');
insert into rules(name) values ('Просматривать заявки');
insert into rules(name) values ('Удалять заявки');

insert into commentss(name) values ('Ошибки в программном обеспечении, сбои оборудования');
insert into commentss(name) values ('Требование провести техническое обслуживание или ремонт');

insert into attachs(name) values ('error_screenshot.png');
insert into attachs(name) values ('log.txt');

insert into roles(name) VALUES ('Администратор системы');
insert into roles(name) VALUES ('	Специалист поддержки');

insert into users(name, roles_id) values ('Ivan', 1);
insert into users(name, roles_id) values ('Alex', 2);

insert into items(name, commentss_id, attachs_id, users_id) values ('Техническая проблема', 1, 1, 1);
insert into items(name, commentss_id, attachs_id, users_id) values ('Запрос на обслуживание', 2, 2, 2);

insert into states(name, items_id) values ('В работе', 1);
insert into states(name, items_id) values ('Закрыта', 2);

insert into categories(name, items_id) values ('IT Support', 1);
insert into categories(name, items_id) values ('IT Support', 2);

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (1, 2);
insert into roles_rules(roles_id, rules_id) values (1, 3);
insert into roles_rules(roles_id, rules_id) values (2, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);
