DROP DATABASE IF EXISTS superheroes;
CREATE DATABASE superheroes CHARACTER SET utf8mb4;
USE superheroes;

CREATE TABLE creador (
id_creador INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
  nombre VARCHAR(20) NOT NULL
);


CREATE TABLE personajes (
  id_personaje INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre_real VARCHAR(20) NOT NULL,
  personaje VARCHAR(20) NOT NULL,
  inteligencia INT(10) NOT NULL,
  fuerza VARCHAR(10) NOT NULL,
  velocidad INT(11) NOT NULL,
  poder INT(11) NOT NULL,
  aparicion INT(11) NOT NULL,
  ocupacion VARCHAR(30) NULL,
  id_creador INT UNSIGNED NOT NULL,
  FOREIGN KEY (id_creador) REFERENCES creador(id_creador)
  );
INSERT INTO creador (nombre) VALUES ('Marvel');
/*
Select from * Tabla, llama a todos los atributos cargados en la base de datos se muestran
*/
select * from creador;
select * from personajes;
/*
insert into tabla (atributo 1, atributo 2) value(s)(atributo 1 val, atributo 2 val)
a)Primero insertar en la tabla “creador” los siguientes datos:
	-marvel
	-dc comics
*/
insert into creador (nombre) value ('Marvel');
insert into creador (nombre) value ('DC comics');
/*
b) Ahora, continuaremos insertando registros en la tabla personaje
*/
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Tony Stark', 'Iron-Man', 170, '600 mil',70, 123, 1963, 'Industrial',1 );
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Bruce Banner', 'Hulk', 160, '600 mil',75, 98, 1962, 'Fisico Nuclear',1 );
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Thor Odinson', 'Thor', 145, 'Infinita',100, 235, 1962, 'Rey de Asgard',1 );
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Peter Parker', 'Spider-Man', 165, '25 mil',80, 74, 1962, 'Fotografo',1 );
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Bruce wayne', 'Bat-Man', 170, '500',32, 47, 1939, 'Hombre de negocios',2 );
insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Bruce wayne', 'Bat-Man', 170, '500',32, 47, 1939, 'Hombre de negocios',2 );


insert into personajes (nombre_real, personaje, inteligencia, fuerza, velocidad, poder, aparicion, ocupacion, id_creador) values ('Clarck kent', 'Superman', 165, 'Infinita',120, 182, 1948, 'Reportero',2 );

update personajes set aparicion=1940 where personaje="Superman";

select * from personajes;

select * from creador;
