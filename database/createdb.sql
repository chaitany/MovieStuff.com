create table site_users (
	user_id int not NULL,
	password varchar(25) not NULL,
	name varchar(50) not NULL,
	email varchar(50) not NULL,
	primary key (user_id)
);

create table favorite_actor_entires (
	user_id int not NULL,
	actor_name varchar(50) not NULL
);

create table favorite_director_entires (
	user_id int not NULL,
	director_name varchar(50) not NULL
);

create table favorite_producer_entires (
	user_id int not NULL,
	producer_name varchar(50) not NULL
);


insert into site_users values (1, 'passw1111', 'Billy Idol', 'bi@gmail.com');
insert into site_users values (2, 'passwer222', 'Mouse', 'cheese@bmi.net');
insert into site_users values (3, 'pwpwpw333', 'Joan Jet', 'chickrock@hotmail.com');

insert into favorite_actor_entires values (1, 'Tom Hanks');
insert into favorite_actor_entires values (2, 'Betty White');
insert into favorite_actor_entires values (3, 'Bruce Willis');

insert into favorite_director_entires values (1, 'Speilberg');
insert into favorite_director_entires values (2, 'Wes Anderson');
insert into favorite_director_entires values (3, 'Clint Eastwood');

insert into favorite_producer_entires values (1, 'George Lucas');
insert into favorite_producer_entires values (2, 'Aaron Spelling');
insert into favorite_producer_entires values (3, 'Stanely kubrick');
