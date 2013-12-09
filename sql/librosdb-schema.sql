drop database if exists librosdb;
create database librosdb;

use librosdb;

create table users (
        username		varchar(20) not null primary key,
		email		 	varchar(255) not null
);

create table libros (
	titulo 				varchar (40) not null primary key,
	autor 				varchar(80) not null,
	lengua				varchar(100) not null,
	edicion				integer not null,
	fecha_edicion		date,
	fecha_impresion		date,
	editorial			varchar(40) not null
);


create table resenas (	
	titulolibro			varchar (40) not null ,		
	username 			varchar (20) not null,
	name				varchar(70) not null,
	texto				varchar(500) not null,
	fecha_creacion		timestamp,
	foreign key(username) references users(username),
	foreign key(titulolibro) references libros(titulo)
);