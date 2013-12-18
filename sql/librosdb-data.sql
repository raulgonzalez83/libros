source librosdb-schema.sql;
insert into users values('alicia','Alicia', 'alicia@acme.com');
insert into users values('blas','Blas', 'blas@acme.com');
insert into users values('test','test', 'test@acme.com');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro1', 'autor1', 'ingles',3,'03-05-21','03-06-21','editorial1');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro2', 'autor2', 'castellano',1,'03-04-21','02-05-21','editorial2');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro3', 'autor3', 'catalan',7,'02-07-20','04-09-11','editorial3');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro4', 'autor4', 'ingles',5,'03-05-21','03-06-21','editorial4');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro5', 'autor5', 'castellano',6,'04-05-22','08-09-25','editorial5');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro6', 'autor6', 'castellano',9,'03-05-21','03-06-05','editorial4');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro7', 'autor3', 'ingles',10,'03-05-21','03-06-11','editorial2');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro8', 'autor2', 'castellano',11,'03-05-02','03-06-23','editorial1');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro9', 'autor9', 'ingles',2,'03-05-09','03-06-04','editorial5');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro10', 'autor10', 'ingles',1,'09-05-01','03-06-01','editorial1');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro11', 'autor11', 'castellano',5,'03-01-02','03-06-22','editorial5');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro12', 'autor5', 'catalan',1,'08-01-18','03-03-25','editorial2');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro13', 'autor2', 'ingles',8,'04-01-16','03-02-20','editorial1');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro14', 'autor11', 'catalan',2,'07-07-14','03-11-28','editorial5');
insert into libros (titulo, autor, lengua, edicion, fecha_edicion, fecha_impresion, editorial) values ('libro15', 'autor15', 'catalan',1,'01-05-11','03-10-17','editorial4');


insert into resenas (idlibro, username,texto) values ('1', 'alicia','Res�a libro0');
insert into resenas (idlibro, username, texto) values ('2', 'blas', 'Res�a libro1');
insert into resenas (idlibro, username, texto) values ('3', 'blas', 'Res�a libro2');
insert into resenas (idlibro, username, texto) values ('4', 'alicia','Res�a libro3');
insert into resenas (idlibro, username,texto) values ('5', 'blas','Res�a libro4');
insert into resenas (idlibro, username,texto) values ('6', 'alicia', 'Res�a libro5');
insert into resenas (idlibro, username,texto) values ('7', 'alicia', 'Res�a libro6');
insert into resenas (idlibro, username,texto) values ('8', 'alicia', 'Res�a libro7');
insert into resenas (idlibro, username,texto) values ('9', 'blas', 'Res�a libro8');
insert into resenas (idlibro, username,texto) values ('10', 'blas', 'Res�a libro9');
insert into resenas (idlibro, username,texto) values ('11', 'alicia', 'Res�a libro10');
insert into resenas (idlibro, username,texto) values ('12', 'blas', 'Res�a libro11');
insert into resenas (idlibro, username,texto) values ('2', 'alicia', 'Res�a libro13');
insert into resenas (idlibro, username,texto) values ('3', 'blas', 'Res�a libro14');
insert into resenas (idlibro, username,texto) values ('15', 'alicia', 'Res�a libro15');
insert into resenas (idlibro, username,texto) values ('5', 'alicia', 'Res�a libro16');
insert into resenas (idlibro, username,texto) values ('10', 'alicia','Res�a libro17');
insert into resenas (idlibro, username,texto) values ('3', 'alicia', 'Res�a libro18');
insert into resenas (idlibro, username,texto) values ('9', 'alicia', 'Res�a libro19');
insert into resenas (idlibro, username,texto) values ('14', 'blas','Res�a libro20');
insert into resenas (idlibro, username,texto) values ('7', 'blas', 'Res�a libro21');
insert into resenas (idlibro, username,texto) values ('8', 'blas', 'Res�a libro22');
insert into resenas (idlibro, username,texto) values ('6', 'blas', 'Res�a libro23');
insert into resenas (idlibro, username,texto) values ('3', 'alicia', 'Res�a libro24');
insert into resenas (idlibro, username,texto) values ('1', 'blas','Res�a libro25');
insert into resenas (idlibro, username,texto) values ('1', 'test', 'Res�a libro');
insert into resenas (idlibro, username,texto) values ('5', 'test', 'Res�a libro');










