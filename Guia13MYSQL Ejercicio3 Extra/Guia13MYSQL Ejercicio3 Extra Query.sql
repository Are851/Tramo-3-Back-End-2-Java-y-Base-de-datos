#Importar el script de la base de datos llamada “pokemondb.sql” y ejecutarlo para crear todas
#las tablas e insertar los registros en las mismas. A continuación, generar el modelo de entidad
#relación y reorganizar las tablas para mayor claridad de sus relaciones. Deberá obtener un
#diagrama de entidad de relación similar al que se muestra a continuación:
#A continuación, se deben realizar las siguientes consultas:
#1. Mostrar el nombre de todos los pokemon.
select nombre from pokemon;
#2. Mostrar los pokemon que pesen menos de 10k.
select nombre,peso from pokemon;
select nombre, peso from pokemon where peso<10;
#3. Mostrar los pokemon de tipo agua.
select * from pokemon_tipo;
select * from tipo;
select * from pokemon_tipo;
SELECT p.* FROM pokemon p JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex61
JOIN tipo t ON pt.id_tipo = t.id_tipo WHERE t.nombre = 'agua';
#4. Mostrar los pokemon de tipo agua, fuego o tierra ordenados por tipo.
SELECT p.*, t.nombre FROM pokemon p JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo t ON pt.id_tipo = t.id_tipo WHERE t.nombre IN ('agua', 'fuego', 'tierra')
ORDER BY t.nombre;
#5. Mostrar los pokemon que son de tipo fuego y volador.
SELECT p.*, t.nombre FROM pokemon p JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo t ON pt.id_tipo = t.id_tipo WHERE t.nombre IN ('volador', 'fuego')
ORDER BY t.nombre;
#6. Mostrar los pokemon con una estadística base de ps mayor que 200.
select * from estadisticas_base where ps>200;
SELECT p.*, eb.* FROM pokemon p JOIN estadisticas_base eb ON p.numero_pokedex = eb.numero_pokedex
WHERE eb.ps > 200;
#7. Mostrar los datos (nombre, peso, altura) de la prevolución de Arbok.
SELECT p.nombre preevolucion, p.peso, p.altura,arbok.nombre evolucionado FROM pokemon p JOIN evoluciona_de e ON p.numero_pokedex = e.pokemon_origen
JOIN pokemon arbok ON arbok.numero_pokedex = e.pokemon_evolucionado WHERE arbok.nombre = 'Arbok';
#8. Mostrar aquellos pokemon que evolucionan por intercambio.
select * from pokemon_forma_evolucion;
select * from forma_evolucion;
select * from tipo_evolucion;
SELECT p.* , te.tipo_evolucion FROM pokemon p JOIN tipo_evolucion te ON p.numero_pokedex = te.id_tipo_evolucion
WHERE te.tipo_evolucion = 'intercambio';
select p.*,p.nombre a_ver, t.tipo_evolucion gaston from pokemon p, pokemon_forma_evolucion pf, forma_evolucion f, tipo_evolucion t
where pf.numero_pokedex=p.numero_pokedex 
and pf.id_forma_evolucion=f.id_forma_evolucion 
and f.tipo_evolucion=t.id_tipo_evolucion 
and  t.tipo_evolucion='intercambio';
#9. Mostrar el nombre del movimiento con más prioridad
SELECT nombre FROM movimiento ORDER BY prioridad DESC LIMIT 1;
#10. Mostrar el pokemon más pesado.
SELECT nombre, peso FROM pokemon ORDER BY peso DESC LIMIT 1;
#11. Mostrar el nombre y tipo del ataque con más potencia.
select * from movimiento;
SELECT nombre, tipo, potencia FROM movimiento join tipo_ataque ORDER BY potencia DESC LIMIT 1;
#12. Mostrar el número de movimientos de cada tipo.
Select * from movimiento;
select * from efecto_secundario;
SELECT   tipo.id_tipo, COUNT(movimiento.id_movimiento) AS cantidad 
FROM tipo join pokemon p JOIN movimiento ON tipo.id_tipo = movimiento.id_tipo GROUP BY tipo.id_tipo;
SELECT tipo.id_tipo, COUNT(movimiento.id_movimiento) AS cantidad
FROM tipo JOIN movimiento ON tipo.id_tipo = movimiento.id_tipo
GROUP BY tipo.id_tipo;
SELECT tipo.id_tipo, COUNT(movimiento.id_movimiento) AS cantidad, tipo.nombre AS tipo_pokemon
FROM tipo
JOIN movimiento ON tipo.id_tipo = movimiento.id_tipo
GROUP BY tipo.id_tipo, tipo.nombre;
#13. Mostrar todos los movimientos que pueden envenenar.
select * from movimiento;
select * from movimiento_efecto_secundario;
SELECT * FROM movimiento  where descripcion like '%enven%';
SELECT * FROM efecto_secundario efs where efs.efecto_secundario LIKE '%enven%';

-- muestra todos los ataques principales y secundario que tienen ataques con veneno
select 
	case
		when efs.efecto_secundario LIKE '%ven%'then efs.efecto_secundario
        when mov.descripcion like '%ven%' then mov.nombre
    end as poder
from efecto_secundario efs, movimiento mov where efs.efecto_secundario LIKE '%ven%' or mov.descripcion like '%ven%' ;

-- diferencia entre  ataque principal y secundario
select 
	case
		when efs.efecto_secundario LIKE '%ven%'then 'secundario'
        when mov.descripcion like '%ven%' then 'principal'
    end as tipo_poder,
	case
		when efs.efecto_secundario LIKE '%ven%'then efs.efecto_secundario
        when mov.descripcion like '%ven%' then mov.nombre
    end as poder
from efecto_secundario efs, movimiento mov where efs.efecto_secundario LIKE '%ven%' or mov.descripcion like '%ven%' order by tipo_poder asc ;
-- con descripcion del ataque
SELECT 
    CASE
        WHEN efs.efecto_secundario LIKE '%ven%' THEN 'secundario'
        WHEN mov.descripcion LIKE '%ven%' THEN 'principal'
    END AS tipo_poder,
    CASE
        WHEN efs.efecto_secundario LIKE '%ven%' THEN efs.efecto_secundario
        WHEN mov.descripcion LIKE '%ven%' THEN mov.nombre
    END AS poder,
    mov.descripcion AS descripcion_movimiento,
    mov.nombre AS nombre_ataque
FROM efecto_secundario efs, movimiento mov
WHERE efs.efecto_secundario LIKE '%ven%' OR mov.descripcion LIKE '%ven%'
ORDER BY tipo_poder ASC;
#14. Mostrar todos los movimientos que causan daño, ordenados alfabéticamente por nombre
SELECT *
FROM movimiento
WHERE descripcion like '%causa daño%'
ORDER BY nombre ASC;
#15. Mostrar todos los movimientos que aprende pikachu.
select * from pokemon where nombre like 'pikachu';
SELECT m.nombre AS nombre_movimiento
FROM movimiento m, pokemon_tipo pt, pokemon p where pt.numero_pokedex = p.numero_pokedex
and p.nombre = 'Pikachu';
SELECT m.nombre AS nombre_movimiento
FROM movimiento m, pokemon_tipo pt, pokemon p
WHERE pt.numero_pokedex = p.numero_pokedex
AND p.nombre = 'Pikachu'
AND m.id_tipo = pt.id_tipo;
#16. Mostrar todos los movimientos que aprende pikachu por MT (tipo de aprendizaje).
select * from tipo_forma_aprendizaje;
select * from pokemon_movimiento_forma;

SELECT m.nombre,tfa.tipo_aprendizaje
FROM movimiento m, tipo_forma_aprendizaje tfa, pokemon_movimiento_forma pmf
WHERE m.id_movimiento = pmf.id_movimiento
AND pmf.id_forma_aprendizaje = tfa.id_tipo_aprendizaje
AND tfa.tipo_aprendizaje = 'MT'
AND pmf.numero_pokedex = (SELECT numero_pokedex FROM pokemon WHERE nombre = 'Pikachu');

#17. Mostrar todos los movimientos de tipo normal que aprende pikachu por nivel.
-- Con Join
SELECT m.nombre FROM movimiento m
JOIN pokemon_movimiento_forma pmf ON m.id_movimiento = pmf.id_movimiento
JOIN forma_aprendizaje fa ON pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
JOIN tipo_forma_aprendizaje tfa ON fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
JOIN pokemon p ON pmf.numero_pokedex = p.numero_pokedex JOIN tipo t ON m.id_tipo = t.id_tipo
WHERE p.nombre = 'Pikachu' AND t.nombre = 'Normal' AND tfa.tipo_aprendizaje = 'Nivel';
-- Sin Join
SELECT m.nombre
FROM movimiento m, pokemon_movimiento_forma pmf, forma_aprendizaje fa, tipo_forma_aprendizaje tfa, tipo t, pokemon p
WHERE m.id_movimiento = pmf.id_movimiento
AND pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
AND fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
AND tfa.tipo_aprendizaje = 'Nivel'
AND m.id_tipo = t.id_tipo
AND p.numero_pokedex = pmf.numero_pokedex
AND p.nombre = 'Pikachu'
AND t.nombre = 'Normal';
#18. Mostrar todos los movimientos de efecto secundario cuya probabilidad sea mayor al 30%.
SELECT m.nombre FROM movimiento m JOIN movimiento_efecto_secundario mes ON m.id_movimiento = mes.id_movimiento
WHERE mes.probabilidad > 0.3;
-- sin join
SELECT nombre FROM movimiento
WHERE id_movimiento IN (
    SELECT id_movimiento
    FROM movimiento_efecto_secundario
    WHERE probabilidad > 0.3
);
#19. Mostrar todos los pokemon que evolucionan por piedra.
SELECT p.nombre FROM pokemon p
JOIN pokemon_forma_evolucion pfe ON p.numero_pokedex = pfe.numero_pokedex
JOIN forma_evolucion fe ON pfe.id_forma_evolucion = fe.id_forma_evolucion
JOIN tipo_evolucion te ON fe.tipo_evolucion = te.id_tipo_evolucion
JOIN piedra pe ON fe.id_forma_evolucion = pe.id_forma_evolucion;
-- sin join
SELECT p.nombre
FROM pokemon p, pokemon_forma_evolucion pfe, forma_evolucion fe, tipo_evolucion te, piedra pe
WHERE p.numero_pokedex = pfe.numero_pokedex
AND pfe.id_forma_evolucion = fe.id_forma_evolucion
AND fe.tipo_evolucion = te.id_tipo_evolucion
AND fe.id_forma_evolucion = pe.id_forma_evolucion;
#20. Mostrar todos los pokemon que no pueden evolucionar.
SELECT p.nombre FROM pokemon p
LEFT JOIN evoluciona_de ed ON p.numero_pokedex = ed.pokemon_origen
WHERE ed.pokemon_evolucionado IS NULL;
-- sin join
SELECT nombre
FROM pokemon
WHERE numero_pokedex NOT IN (
    SELECT pokemon_evolucionado
    FROM evoluciona_de
);
#21. Mostrar la cantidad de los pokemon de cada tipo.
SELECT t.nombre AS tipo, COUNT(*) AS cantidad
FROM tipo t
JOIN pokemon_tipo pt ON t.id_tipo = pt.id_tipo
GROUP BY t.nombre;
--  sin join
SELECT t.nombre AS tipo, (
    SELECT COUNT(*)
    FROM pokemon_tipo pt
    WHERE pt.id_tipo = t.id_tipo
) AS cantidad
FROM tipo t;
