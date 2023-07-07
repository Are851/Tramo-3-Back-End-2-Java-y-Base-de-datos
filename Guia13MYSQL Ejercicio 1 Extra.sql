/*Abrir el script de la base de datos llamada “nba.sql” y ejecutarlo para crear todas las tablas e
insertar datos en las mismas. A continuación, generar el modelo de entidad relación. Deberá
obtener un diagrama de entidad relación igual al que se muestra a continuación:*/
-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
select nombre from jugadores order by nombre;
-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200 libras,
-- ordenados por nombre alfabéticamente.
select nombre,posicion,peso from jugadores where posicion = 'c' and peso > 200;
-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
select nombre from equipos order by nombre;
-- 4. Mostrar el nombre de los equipos del este (East).
select nombre,conferencia from equipos where conferencia = 'east';
-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
select nombre, ciudad from equipos where ciudad like 'c%';
-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT Nombre, Nombre_equipo FROM jugadores ORDER BY Nombre_equipo;
-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
select nombre from jugadores where nombre_equipo = 'Raptors' order by nombre;
-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
select Puntos_por_partido, jugador,j.nombre from estadisticas e, jugadores j where e.jugador = j.codigo and e.jugador = (select codigo from jugadores where nombre = 'pau gasol');
SELECT e.Puntos_por_partido, jugador,j.nombre FROM estadisticas AS e INNER JOIN jugadores AS j ON e.jugador = j.codigo WHERE j.nombre = 'Pau Gasol';
-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
select Puntos_por_partido, jugador,j.nombre from estadisticas e, jugadores j 
where e.jugador = j.codigo and e.jugador = (select codigo from jugadores 
where nombre = 'pau gasol') and e.temporada = '04/05';
-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.


-- 11. Mostrar el número de jugadores de cada equipo.