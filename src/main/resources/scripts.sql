-------------------------------
-- DDL for spittrdb database --
-------------------------------
CREATE DATABASE `spittrdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

---------------------------
-- DDL for spitter table --
---------------------------
create table spitter
(
    id        bigint      not null,
    username  varchar(45) not null,
    password  varchar(45) not null,
    firstName varchar(45) not null,
    lastName  varchar(45) not null,
    email     varchar(45) not null,
    primary key (id, username)
);

---------------------------
-- DDL for spittle table --
---------------------------
create table spittle
(
    id        bigint       not null
        primary key,
    message   varchar(500) not null,
    time      varchar(15)  not null,
    longitude double       not null,
    latitude  double       not null
);
