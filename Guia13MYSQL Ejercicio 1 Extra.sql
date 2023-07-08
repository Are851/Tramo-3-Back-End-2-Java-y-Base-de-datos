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
select jugador, round(sum(puntos_por_partido),2) puntos from estadisticas group by jugador order by jugador ;
select jugador, puntos_por_partido from estadisticas where jugador = 5;

-- 11. Mostrar el número de jugadores de cada equipo.
select jugador, round(sum(puntos_por_partido),2) puntos from estadisticas group by jugador order by jugador;
select Nombre_equipo, count(codigo) from jugadores group by Nombre_equipo order by Nombre_equipo;  

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
select jugador, round(sum(puntos_por_partido),2) puntos from estadisticas group by jugador order by jugador;
SELECT jugador, SUM(puntos_por_partido) AS puntos_totales FROM estadisticas GROUP BY jugador ORDER BY puntos_totales DESC LIMIT 1;

-- 13  Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
select e.Nombre, e.conferencia, e.Division, j.altura from  jugadores j,equipos e where e.nombre = j.Nombre_equipo and j.altura = (select max(Altura)from jugadores);
select Altura from jugadores group by altura order by altura desc;

-- 14. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor
-- diferencia de puntos.
select equipo_local, equipo_visitante, abs(puntos_local - puntos_visitante) diferencia, puntos_local,
 puntos_visitante from partidos order by diferencia desc;
 select * ,abs(puntos_local - puntos_visitante) diferencia from partidos
 where( abs(puntos_local - puntos_visitante))= (select max(abs(puntos_local - puntos_visitante)) from partidos);
select equipo_local, equipo_visitante, abs(puntos_local - puntos_visitante) diferencia, puntos_local, puntos_visitante from partidos order by diferencia desc;

-- 15. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante,
-- equipo_ganadorn caso de empate sera null.
SELECT p.codigo, p.equipo_local, p.equipo_visitante, 
    CASE 
        WHEN p.puntos_local > p.puntos_visitante THEN p.equipo_local
        WHEN p.puntos_local < p.puntos_visitante THEN p.equipo_visitante
        ELSE NULL
    END AS equipo_ganador
FROM partidos p;

SELECT codigo, equipo_local, equipo_visitante,
       IF(puntos_local > puntos_visitante, equipo_local,
          IF(puntos_local < puntos_visitante, equipo_visitante, NULL)) AS equipo_ganador
FROM partidos;