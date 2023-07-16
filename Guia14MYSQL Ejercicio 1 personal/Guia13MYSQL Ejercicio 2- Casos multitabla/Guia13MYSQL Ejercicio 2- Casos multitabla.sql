-- Devuelve una lista con el código del producto, nombre del producto, código del fabricante
-- y nombre del fabricante, de todos los productos de la base de datos.
select p.codigo, p.nombre,f.codig, f.nombre from producto p, fabricante f;
-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos
-- los productos de la base de datos. Ordene el resultado por el nombre del fabricante, por
-- orden alfabético.
select p.nombre, p.precio, f.nombre from producto p, fabricante f order by f.nombre asc;
-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto
-- más barato.
select p.nombre, p.precio, f.nombre from producto p, fabricante f order by p.precio asc limit 1;
-- Devuelve una lista de todos los productos del fabricante Lenovo.
select p.nombre, f.nombre from producto p inner join fabricante f on f.nombre = 'lenovo'; 
-- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio
-- mayor que $200.
select p.nombre, f.nombre, precio from producto p,fabricante f where f.nombre = 'Crucial' and precio>200;
-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard.
-- Utilizando el operador IN.
select p.nombre, f.nombre from producto p,fabricante f where f.nombre in ('Asus','Hewlett-Packard');
-- Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos
-- los productos que tengan un precio mayor o igual a $180. Ordene el resultado en primer
-- lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden
-- ascendente)
select p.nombre, p.precio, f.nombre from producto p,fabricante f where 
precio>=180 order by precio asc, f.nombre desc; 

-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
-- Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los
-- productos que tiene cada uno de ellos. El listado deberá mostrar también aquellos
-- fabricantes que no tienen productos asociados.
SELECT f.nombre, p.nombre from fabricante f left join producto p on p.codigo_fabricante = f.codigo;

-- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún
-- producto asociado.
select f.nombre, p.nombre from fabricante f 
left join producto p on p.codigo_fabricante = f.codigo 
where p.codigo_fabricante IS NULL;

-- Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
select p.nombre, f.nombre from producto p,fabricante f where f.nombre = 'lenovo';

-- Devuelve todos los datos de los productos que tienen el mismo precio que el producto
-- más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
select * from producto p,fabricante f where precio = (select max(precio)
from producto where f.nombre = 'lenovo') ;

SELECT * FROM producto 
WHERE precio > (SELECT MAX(precio) FROM producto 
WHERE codigo_fabricante = (SELECT codigo FROM fabricante 
WHERE nombre LIKE '%Lenovo%'));

SELECT f.nombre, p.nombre from fabricante f 
left join producto p 
on p.codigo_fabricante = f.codigo;

-- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT f.nombre, p.nombre from fabricante f 
left join producto p 
on p.codigo_fabricante = f.codigo where p.nombre IS NULL;

-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT f.nombre, p.nombre from fabricante f 
inner join producto p 
on p.codigo_fabricante = f.codigo where f.nombre = 'Lenovo';

SELECT PRODUCTO.nombre FROM PRODUCTO, FABRICANTE 
WHERE FABRICANTE.CODIGO = PRODUCTO.codigo_fabricante 
AND FABRICANTE.NOMBRE = 'LENOVO';

-- Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo.
-- (Sin utilizar INNER JOIN).
select * from producto 
where precio = (select max(precio) from producto 
where codigo_fabricante = (select codigo from fabricante where nombre like '%Lenovo%'));

select * from producto where precio >= 559;

-- 4 Lista todos los productos del fabricante Asus que tienen un precio superior al precio
-- medio de todos sus productos.

select * from fabricante f, producto p 
where f.nombre = 'Asus' and precio > (select avg(precio) from producto
where codigo_fabricante = (select codigo from fabricante where nombre like '%Asus%'));

-- 1. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando IN o NOT IN).

select distinct f.nombre from producto p, fabricante f 
where f.codigo in(select codigo_fabricante from producto where codigo_fabricante is not null);

SELECT f.nombre FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
GROUP BY f.nombre HAVING COUNT(p.codigo)>=1;

-- 2.Devuelve los nombres de los fabricantes que no tienen productos asociados. (Utilizando IN o NOT IN).

select distinct f.nombre from producto p, fabricante f 
where f.codigo not in(select codigo_fabricante from producto where codigo_fabricante is not null);


