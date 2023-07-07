-- Lista el nombre de todos los productos que hay en la tabla producto.
select nombre from producto;
-- Lista los nombres y los precios de todos los productos de la tabla producto.
select nombre,precio from producto;
-- Lista todas las columnas de la tabla producto.
select * from producto;
-- Lista los nombres y los precios de todos los productos de la tabla producto, redondeando
-- el valor del precio.
select nombre, round(precio) from producto;
-- Lista el código de los fabricantes que tienen productos en la tabla producto.
select fabricante.codigo from fabricante,producto where fabricante.codigo = producto.codigo_fabricante;
select codigo from fabricante where codigo in (select codigo_fabricante from producto); 
-- Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar
-- los repetidos.
select distinct fabricante.codigo from fabricante,producto where fabricante.codigo = producto.codigo_fabricante;
select distinct codigo_fabricante from producto;
-- Lista los nombres de los fabricantes ordenados de forma ascendente.
select nombre from fabricante order by nombre asc;
-- Lista los nombres de los productos ordenados en primer lugar por el nombre de forma
-- ascendente y en segundo lugar por el precio de forma descendente.
select nombre, precio from producto order by nombre asc, precio desc;
-- Devuelve una lista con las 5 primeras filas de la tabla fabricante.
select * from fabricante limit 5;
-- Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas
-- ORDER BY y LIMIT)
select nombre, precio from producto order by precio asc limit 1;
-- Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER
-- BY y LIMIT)
select nombre, precio from producto order by precio desc limit 1;
-- Lista el nombre de los productos que tienen un precio menor o igual a $120.
select nombre from producto where(precio<=120); 
-- Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador
-- BETWEEN.
select nombre, precio from producto where precio between 60 and 200;
-- Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador
-- IN.
select codigo_fabricante from producto where codigo_fabricante in (1,3,5);
-- Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil
-- en el nombre.
select nombre from producto where nombre like '%Portátil%';
select * from producto;
