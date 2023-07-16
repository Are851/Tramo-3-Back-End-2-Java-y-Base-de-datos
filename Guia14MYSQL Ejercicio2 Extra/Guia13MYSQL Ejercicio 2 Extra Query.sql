#Consultas sobre una tabla
#1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
SELECT codigo_oficina, ciudad
FROM oficina;
#2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
select ciudad, telefono from cliente;
#3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un
#código de jefe igual a 7.
select nombre, apellido1, apellido2 from empleado where codigo_jefe=7;
#4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
SELECT e.puesto, e.nombre, e.apellido1, e.apellido2, e.email
FROM empleado e
WHERE e.codigo_jefe IS NULL;
#5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean 
#representantes de ventas
select * from empleado;
select * from empleado where puesto like 'Representante Ventas';
#6. Devuelve un listado con el nombre de los todos los clientes españoles.
select * from cliente where pais like 'spain';
#7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.
select estado from pedido;
-- para que aparezca una sola vez cada estado en diferentes filas
SELECT estado FROM pedido GROUP BY estado;
-- para concatenar los distintos estados en una sola fila separados por comas.
SELECT GROUP_CONCAT(DISTINCT estado SEPARATOR ', ') AS estados
FROM pedido;
#8. Devuelve un listado con el código de cliente de aquellos clientes 
#que realizaron algún pago en 2008. 
#Tenga en cuenta que deberá eliminar aquellos códigos de cliente que aparezcan 
#repetidos. Resuelva la consulta:
#o Utilizando la función YEAR de MySQL.
SELECT  codigo_cliente FROM pago WHERE YEAR (fecha_pago) = 2008;
#o Utilizando la función DATE_FORMAT de MySQL.
SELECT codigo_cliente FROM pago WHERE DATE_FORMAT(fecha_pago, '%Y') = '2008';
#o Sin utilizar ninguna de las funciones anteriores.
SELECT codigo_cliente
FROM pago
WHERE fecha_pago
LIKE '2008%';

#9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de 
#entrega de los pedidos que no han sido entregados a tiempo.
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega, estado
FROM pedido
WHERE estado = 'Entregado' AND fecha_entrega > fecha_esperada;
#10. Devuelve un listado con el código de pedido, código de cliente, 
#fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega 
#ha sido al menos dos días antes de la fecha esperada.
#o Utilizando la función ADDDATE de MySQL.

SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE ADDDATE(fecha_entrega, 2) <= fecha_esperada;


#o Utilizando la función DATEDIFF de MySQL.
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE DATEDIFF(fecha_entrega, fecha_entrega) <= 2;

#11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
SELECT *
FROM pedido
WHERE estado = 'Rechazado' AND YEAR(fecha_pedido) = 2009;
#12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de 
#cualquier año.
SELECT *
FROM pedido
WHERE MONTH(fecha_entrega) = 1;

#13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal. 
#Ordene el resultado de mayor a menor.
SELECT *
FROM pago
WHERE YEAR(fecha_pago) = 2008 AND forma_pago = 'Paypal'
ORDER BY total DESC;

#14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en 
#cuenta que no deben aparecer formas de pago repetidas.
SELECT DISTINCT forma_pago
FROM pago;
#15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que 
#tienen más de 100 unidades en stock. El listado deberá estar ordenado por su precio de 
#venta, mostrando en primer lugar los de mayor precio.
SELECT *
FROM producto
WHERE gama = 'Ornamentales' AND cantidad_en_stock > 100
ORDER BY precio_venta DESC;
#16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo 
#representante de ventas tenga el código de empleado 11 o 30.
SELECT *
FROM cliente
WHERE ciudad = 'Madrid' AND codigo_empleado_rep_ventas IN (11, 30);
#Consultas multitabla (Composición interna)ç
/*
Las consultas se deben resolver con INNER JOIN.
1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante 
de ventas.*/
SELECT c.nombre_cliente cliente ,  e.nombre nombreempleado , e.apellido1 aprllidoempleado
FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado;
SELECT c.nombre_cliente cliente ,(SELECT CONCAT(e.nombre, ' ', e.apellido1)) AS representante_ventas
FROM cliente c
INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado;
-- sin join
SELECT c.nombre_cliente, 
  (SELECT CONCAT(e.nombre, ' ', e.apellido1) 
   FROM empleado e 
   WHERE e.codigo_empleado = c.codigo_empleado_rep_ventas) AS representante_ventas
FROM cliente c;
#2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus 
#representantes de ventas.
SELECT c.nombre_cliente cliente,(SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_ventas
FROM cliente c
JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
JOIN pago p ON c.codigo_cliente = p.codigo_cliente;
-- sin join
SELECT c.nombre_cliente,
  (SELECT CONCAT(e.nombre, ' ', e.apellido1)
   FROM empleado e
   WHERE e.codigo_empleado = c.codigo_empleado_rep_ventas) AS representante_ventas
FROM cliente c WHERE c.codigo_cliente IN (SELECT codigo_cliente FROM pago);
#3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de 
#sus representantes de ventas.
SELECT c.nombre_cliente, (SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_ventas
FROM cliente c
JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago);
-- sin join
SELECT c.nombre_cliente,
  (SELECT CONCAT(e.nombre, ' ', e.apellido1)
   FROM empleado e
   WHERE e.codigo_empleado = c.codigo_empleado_rep_ventas) AS representante_ventas
FROM cliente c
WHERE c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago);
#4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes 
#junto con la ciudad de la oficina a la que pertenece el representante.
SELECT c.nombre_cliente, (SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_ventas , o.ciudad
FROM cliente c, empleado e, oficina o
WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado
  AND e.codigo_oficina = o.codigo_oficina
  AND c.codigo_cliente IN (SELECT codigo_cliente FROM pago);
#5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus 
#representantes junto con la ciudad de la oficina a la que pertenece el representante.
SELECT c.nombre_cliente, (SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_ventas, o.ciudad
FROM cliente c, empleado e, oficina o
WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado
  AND e.codigo_oficina = o.codigo_oficina
  AND c.codigo_cliente NOT IN (SELECT codigo_cliente FROM pago);
#6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
SELECT o.linea_direccion1, o.linea_direccion2, o.ciudad, o.pais,  c.ciudad
FROM cliente c, empleado e, oficina o 
  WHERE e.codigo_oficina = o.codigo_oficina and c.codigo_empleado_rep_ventas=e.codigo_empleado
    AND  c.ciudad = 'Fuenlabrada';
#7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad 
#de la oficina a la que pertenece el representante.
SELECT c.nombre_cliente, (SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_ventas, o.ciudad
FROM cliente c, empleado e, oficina o
WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado
  AND e.codigo_oficina = o.codigo_oficina;
  -- con join
SELECT c.nombre_cliente, (SELECT CONCAT(e.nombre, ' ', e.apellido1)) representante_venta, o.ciudad FROM cliente c
JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
JOIN oficina o ON e.codigo_oficina = o.codigo_oficina;
#8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
SELECT  (SELECT CONCAT(e.nombre, ' ', e.apellido1, ' ',e.apellido2)) AS empleado,
(SELECT CONCAT(j.nombre, ' ', j.apellido1,  ' ',j.apellido2))AS jefe FROM empleado e
JOIN empleado j ON e.codigo_jefe = j.codigo_empleado;
-- sin join
SELECT CONCAT(e.nombre, ' ', e.apellido1, ' ',e.apellido2) AS empleado,  
(SELECT CONCAT(j.nombre, ' ', j.apellido1,  ' ',j.apellido2) FROM empleado j WHERE codigo_empleado = e.codigo_jefe) jefe
 FROM empleado e;
  #8. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los 
#representantes de ventas de algún cliente que haya realizado la compra de algún producto 
#de la gama Frutales.
SELECT o.*
FROM oficina o
WHERE o.codigo_oficina NOT IN (
  SELECT e.codigo_oficina
  FROM empleado e
  JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
  JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
  JOIN detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido
  JOIN producto pr ON dp.codigo_producto = pr.codigo_producto
  JOIN gama_producto gp ON pr.gama = gp.gama
  WHERE gp.gama = 'Frutales'
);
#9. Devuelve un listado con los clientes que han realizado algún pedido, pero no han realizado 
#ningún pago.
SELECT c.*
FROM cliente c
WHERE c.codigo_cliente IN (
  SELECT p.codigo_cliente
  FROM pedido p
)
AND c.codigo_cliente NOT IN (
  SELECT pago.codigo_cliente
  FROM pago
);
#10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el 
#nombre de su jefe asociado.
SELECT e.*, j.nombre AS nombre_jefe
FROM empleado e
LEFT JOIN empleado j ON e.codigo_jefe = j.codigo_empleado
WHERE e.codigo_empleado NOT IN (
  SELECT DISTINCT codigo_empleado_rep_ventas
  FROM cliente
);
#Consultas resumen
#1. ¿Cuántos empleados hay en la compañía?
SELECT COUNT(*) AS total_empleados FROM empleado;
#2. ¿Cuántos clientes tiene cada país?
SELECT pais, COUNT(*) AS total_clientes
FROM cliente GROUP BY pais;
#3. ¿Cuál fue el pago medio en 2009?
SELECT AVG(total) AS pago_medio_2009
FROM pago
WHERE YEAR(fecha_pago) = 2009;
#4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el 
#número de pedidos.
SELECT estado, COUNT(*) AS total_pedidos
FROM pedido
GROUP BY estado
ORDER BY total_pedidos DESC;
#5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.
SELECT MAX(precio_venta) AS precio_mas_caro, MIN(precio_venta) AS precio_mas_barato
FROM producto;
#6. Calcula el número de clientes que tiene la empresa.
SELECT COUNT(*) AS numero_clientes
FROM cliente;
#7. ¿Cuántos clientes tiene la ciudad de Madrid?
SELECT COUNT(*) AS numero_clientes
FROM cliente
WHERE ciudad = 'Madrid';
#8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
SELECT ciudad, COUNT(*) AS numero_clientes
FROM cliente
WHERE ciudad LIKE 'M%'
GROUP BY ciudad;
#9. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende 
#cada uno.
SELECT e.nombre, e.apellido1, COUNT(c.codigo_cliente) AS numero_clientes
FROM empleado e
LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas
WHERE e.puesto = 'Representante de Ventas'
GROUP BY e.codigo_empleado, e.nombre, e.apellido1;
#10. Calcula el número de clientes que no tiene asignado representante de ventas.
SELECT COUNT(c.codigo_cliente) AS numero_clientes_sin_representante
FROM cliente c
LEFT JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE e.codigo_empleado IS NULL;
#11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado 
#deberá mostrar el nombre y los apellidos de cada cliente.
SELECT c.nombre_cliente, c.nombre_contacto, c.apellido_contacto,
       MIN(p.fecha_pago) AS primera_fecha_pago,
       MAX(p.fecha_pago) AS ultima_fecha_pago
FROM cliente c
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
GROUP BY c.codigo_cliente, c.nombre_cliente, c.nombre_contacto, c.apellido_contacto;
#12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.
SELECT codigo_pedido, COUNT(DISTINCT codigo_producto) AS numero_productos_diferentes
FROM detalle_pedido GROUP BY codigo_pedido;
#13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de 
#los pedidos.
SELECT codigo_pedido, SUM(cantidad) AS cantidad_total FROM detalle_pedido GROUP BY codigo_pedido;
#14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que 
#se han vendido de cada uno. El listado deberá estar ordenado por el número total de 
#unidades vendidas.
SELECT p.codigo_producto, p.nombre, SUM(dp.cantidad) AS total_unidades_vendidas
FROM producto p
JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
GROUP BY p.codigo_producto, p.nombre
ORDER BY total_unidades_vendidas DESC
LIMIT 20;
#15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el 
#IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el 
#número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base 
#imponible, y el total la suma de los dos campos anteriores.
SELECT
    SUM(dp.cantidad * pr.precio_venta) AS base_imponible,
    SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva,
    SUM(dp.cantidad * pr.precio_venta) + (SUM(dp.cantidad * pr.precio_venta) * 0.21) AS total_facturado
FROM detalle_pedido dp
JOIN producto pr ON dp.codigo_producto = pr.codigo_producto;
#16. La misma información que en la pregunta anterior, pero agrupada por código de producto.
SELECT
    dp.codigo_producto,
    SUM(dp.cantidad * pr.precio_venta) AS base_imponible,
    SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva,
    SUM(dp.cantidad * pr.precio_venta) + (SUM(dp.cantidad * pr.precio_venta) * 0.21) AS total_facturado
FROM detalle_pedido dp
JOIN producto pr ON dp.codigo_producto = pr.codigo_producto
GROUP BY dp.codigo_producto;
#17. La misma información que en la pregunta anterior, pero agrupada por código de producto 
#filtrada por los códigos que empiecen por OR.
SELECT
    dp.codigo_producto,
    SUM(dp.cantidad * pr.precio_venta) AS base_imponible,
    SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva,
    SUM(dp.cantidad * pr.precio_venta) + (SUM(dp.cantidad * pr.precio_venta) * 0.21) AS total_facturado
FROM detalle_pedido dp
JOIN producto pr ON dp.codigo_producto = pr.codigo_producto
WHERE dp.codigo_producto LIKE 'OR%'
GROUP BY dp.codigo_producto;
#18. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se 
#mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% 
#IVA)
SELECT
    pr.nombre AS nombre_producto,
    SUM(dp.cantidad) AS unidades_vendidas,
    SUM(dp.cantidad * pr.precio_venta) AS total_facturado,
    SUM(dp.cantidad * pr.precio_venta * 1.21) AS total_facturado_iva
FROM detalle_pedido dp
JOIN producto pr ON dp.codigo_producto = pr.codigo_producto
GROUP BY pr.nombre
HAVING total_facturado > 3000;
#Subconsultas con operadores básicos de comparación
#1. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT nombre_cliente FROM cliente
ORDER BY limite_credito DESC LIMIT 1;
#2. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT nombre
FROM producto
ORDER BY precio_venta DESC
LIMIT 1;
#3. Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta 
#que tendrá que calcular cuál es el número total de unidades que se han vendido de cada 
#producto a partir de los datos de la tabla detalle_pedido. Una vez que sepa cuál es el código 
#del producto, puede obtener su nombre fácilmente.)
SELECT pr.nombre
FROM producto pr
JOIN detalle_pedido dp ON pr.codigo_producto = dp.codigo_producto
GROUP BY pr.codigo_producto
ORDER BY SUM(dp.cantidad) DESC
LIMIT 1;
#4. Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar 
#INNER JOIN).
SELECT c.nombre_cliente
FROM cliente c
WHERE c.limite_credito > (
    SELECT SUM(p.total)
    FROM pago p
    WHERE p.codigo_cliente = c.codigo_cliente
);
#5. Devuelve el producto que más unidades tiene en stock.
SELECT codigo_producto, nombre, cantidad_en_stock
FROM producto
WHERE cantidad_en_stock = (
    SELECT MAX(cantidad_en_stock)
    FROM producto
);
#6. Devuelve el producto que menos unidades tiene en stock.
SELECT codigo_producto, nombre, cantidad_en_stock
FROM producto
WHERE cantidad_en_stock = (
    SELECT MIN(cantidad_en_stock)
    FROM producto
);
#7. Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto
SELECT e.nombre, e.apellido1, e.apellido2, e.email
FROM empleado e
WHERE e.codigo_jefe = (
    SELECT codigo_empleado
    FROM empleado
    WHERE nombre = 'Alberto'
);
#Soria.
#Subconsultas con ALL y ANY
-- La función ANY se utiliza para comparar un valor con múltiples valores en una subconsulta y
-- devuelve verdadero si al menos uno de los valores cumple con la condición.
-- La función ALL se utiliza para comparar un valor con múltiples valores en una subconsulta
-- y devuelve verdadero si todos los valores cumplen con la condición.
#1. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT nombre_cliente
FROM cliente
WHERE limite_credito = (
    SELECT MAX(limite_credito)
    FROM cliente
);
SELECT nombre_cliente
FROM cliente
WHERE limite_credito >= ALL (
    SELECT limite_credito
    FROM cliente
);
#2. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT nombre_producto
FROM productos
WHERE precio_venta = (
    SELECT MAX(precio_venta)
    FROM productos
);
SELECT nombre_producto
FROM productos
WHERE precio_venta >= ANY (
    SELECT precio_venta
    FROM productos
);

#3. Devuelve el producto que menos unidades tiene en stock.
SELECT nombre
FROM producto
WHERE precio_venta >= ALL (
    SELECT precio_venta
    FROM producto
);
#Subconsultas con IN y NOT IN
#1. Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún 
#cliente.
SELECT nombre, apellido1, puesto
FROM empleado
WHERE codigo_empleado NOT IN (
    SELECT codigo_empleado_rep_ventas
    FROM cliente
);
SELECT nombre, apellido1, puesto
FROM empleado
WHERE NOT EXISTS (
    SELECT *
    FROM cliente
    WHERE codigo_empleado_rep_ventas = empleado.codigo_empleado
);
#2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT codigo_cliente, nombre_cliente
FROM cliente
WHERE codigo_cliente NOT IN (
    SELECT codigo_cliente
    FROM pago
);
SELECT c.codigo_cliente, c.nombre_cliente
FROM cliente c
LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
WHERE p.codigo_cliente IS NULL;
#3. Devuelve un listado que muestre solamente los clientes que sí han realizado algun pago.
SELECT codigo_cliente, nombre_cliente
FROM cliente
WHERE codigo_cliente IN (
    SELECT codigo_cliente
    FROM pago
);
#4. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT codigo_producto, nombre
FROM producto
WHERE codigo_producto NOT IN (
    SELECT codigo_producto
    FROM detalle_pedido
);
#5. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que 
#no sean representante de ventas de ningún cliente.
SELECT e.nombre, e.apellido1, e.puesto, o.telefono
FROM empleado e
JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE e.codigo_empleado NOT IN (
    SELECT codigo_empleado_rep_ventas
    FROM cliente
    WHERE codigo_empleado_rep_ventas IS NOT NULL
);
SELECT e.nombre, e.apellido1, e.puesto, o.telefono
FROM empleado e
JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE NOT EXISTS (
    SELECT 1
    FROM cliente c
    WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado
);
#Subconsultas con EXISTS y NOT EXISTS
-- La cláusula EXISTS es una cláusula utilizada en SQL para verificar la existencia de registros en una subconsulta.
-- La sintaxis básica de la cláusula EXISTS es la siguiente:
-- SELECT columnas FROM tabla WHERE EXISTS (subconsulta)
-- La subconsulta en la cláusula EXISTS puede ser cualquier consulta SQL válida,
-- y su resultado debe ser una o más filas. Si la subconsulta devuelve al menos una fila,
-- la cláusula EXISTS se evalúa como verdadera y se seleccionan las filas de la consulta principal.
--  Si la subconsulta no devuelve ninguna fila, la cláusula EXISTS se evalúa como falsa y no se seleccionan
-- filas en la consulta principal.
#1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún 
#pago.
SELECT c.codigo_cliente, c.nombre_cliente
FROM cliente c
WHERE NOT EXISTS (
    SELECT 1
    FROM pago p
    WHERE p.codigo_cliente = c.codigo_cliente
);
#2. Devuelve un listado que muestre solamente los clientes que sí han realizado algun pago.
SELECT codigo_cliente, nombre_cliente
FROM cliente
WHERE EXISTS (
    SELECT 1
    FROM pago
    WHERE cliente.codigo_cliente = pago.codigo_cliente
);
#3. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT codigo_producto, nombre
FROM producto p
WHERE NOT EXISTS (
    SELECT 1
    FROM detalle_pedido dp
    WHERE dp.codigo_producto = p.codigo_producto
);
#4. Devuelve un listado de los productos que han aparecido en un pedido alguna vez
SELECT p.nombre
FROM producto p
WHERE EXISTS (
    SELECT *
    FROM detalle_pedido dp
    WHERE dp.codigo_producto = p.codigo_producto
);