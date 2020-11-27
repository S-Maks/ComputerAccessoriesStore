create table Account(
idUser SERIAL primary key,
first_name VARCHAR(50) NOT NULL ,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
username VARCHAR(50) NOT NULL,
password VARCHAR(200) NOT NULL,
created_at DATE NOT NULL ,
role VARCHAR(50) NOT NULL
);

insert into Account (first_name, last_name, email, username, password, created_at, role)
VALUES ('Maks','Titok','admin@mail.ru', 'admin','admin','25-11-2020','ROLE_ADMIN') ;

drop table Account;