--liquibase formatted sql

--changeset s.muntyanov:init-commit
create table analytic(
    id serial primary key,
    item_id int8 not null
);

create table analytic_counts(
    item_id int primary key,
    count int
);

create table category (
	id serial primary key,
	"name" varchar(50) NOT NULL
);

create table category_attribute (
    id serial primary key,
    name varchar(50),
    category_id int
);

create table discount(
    id serial primary key,
    name varchar(100),
    value int,
    type varchar(10)
);

create table item (
    id serial primary key,
    price float not null,
    name varchar(100),
    category_id int
);

create table item_discount (
    item_id int,
    discount_id int
);

CREATE TABLE item_attribute (
	item_id int4 NOT NULL,
	value varchar(100) NOT NULL,
	category_attribute_id int4,
	CONSTRAINT item_attribute_pkey PRIMARY KEY (item_id, category_attribute_id)
);
--changeset s.muntyanov:data-generate
--muntyanov
insert into category (name) values ('Смартфон'),('Планшет'),('Наушники');
insert into item (name,price, category_id) select concat ('iphone ',generate_series(1, 14)) as name,
generate_series(1, 14) as price,
 (select id from category where name = 'Смартфон') as category_id;
insert into item (name,price,category_id)select concat ('sumsung s',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Смартфон') as category_id;
insert into item (name,price,category_id)select concat ('sumsung a',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Смартфон') as category_id;
insert into item (name,price,category_id) select concat ('ipad ',generate_series(1, 14)) as name,
generate_series(1, 14) as price,
 (select id from category where name = 'Планшет') as category_id;
insert into item (name,price,category_id)select concat ('xiaomi mipad ',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Планшет') as category_id;
insert into item (name,price,category_id)select concat ('sumsung pad ',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Планшет') as category_id;
insert into item (name,price,category_id) select concat ('air pod ',generate_series(1, 14)) as name,
generate_series(1, 14) as price,
 (select id from category where name = 'Наушники') as category_id;
insert into item (name,price,category_id)select concat ('xiaomi air dot ',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Наушники') as category_id;
insert into item (name,price,category_id)select concat ('sumsung buds ',generate_series(15, 55)) as name,
generate_series(15, 55) as price,
(select id from category where name = 'Наушники') as category_id;

