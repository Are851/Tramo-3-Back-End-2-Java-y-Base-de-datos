#1. Obtener los datos completos de los empleados.
SELECT *
FROM empleados;

#2. Obtener los datos completos de los departamentos.
SELECT *
FROM departamentos;

#3. Listar el nombre de los departamentos.
SELECT nombre_depto
FROM departamentos;

#4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp
FROM empleados;

#5. Listar todas las comisiones.
SELECT comision_emp
FROM empleados;

#6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT *
FROM empleados
WHERE cargo_emp = 'Secretaria';

#7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente.
SELECT *
FROM empleados
WHERE cargo_emp = 'Vendedor'
ORDER BY nombre ASC;

#8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT nombre, cargo_emp, sal_emp
FROM empleados
ORDER BY sal_emp ASC;

#9. Obtener el nombre de o de los jefes que tengan su departamento situado en la ciudad de “Ciudad Real”
SELECT nombre_jefe_depto, ciudad city
FROM departamentos
WHERE ciudad = 'Ciudad Real';

#10. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas de empleados.
SELECT nombre Nombre, cargo_emp Cargo
FROM empleados;

#11. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT nombre, sal_emp, comision_emp
FROM empleados
WHERE id_depto = 2000
ORDER BY comision_emp ASC;

#12. Obtener el valor total a pagar a cada empleado del departamento 3000, que resulta de: 
#sumar el salario y la comisión, más una bonificación de 500. 
#Mostrar el nombre del empleado y el total a pagar, en orden alfabético.
SELECT nombre, sal_emp+comision_emp+500 AS total_a_pagar  #alias
FROM empleados
WHERE id_depto
ORDER BY nombre ASC;

#13. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT *
FROM empleados
WHERE nombre
LIKE 'J%';

#14. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, 
#de aquellos empleados que tienen comisión superior a 1000.
SELECT sal_emp, comision_emp, sal_emp+comision_emp AS salario_total, nombre
FROM empleados
WHERE sal_emp > 1000;

#15. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen tienen comisión
SELECT sal_emp, comision_emp, sal_emp AS salario_total, nombre
FROM empleados
WHERE comision_emp = 0;

#16. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT *
FROM empleados
WHERE comision_emp > sal_emp;

#17. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT *
FROM empleados
WHERE comision_emp <= sal_emp*0.3;

#18. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT *
FROM empleados
WHERE nombre
NOT LIKE '%MA%';

#19. Obtener los nombres de los departamentos que sean “Ventas”, “Investigación” o ‘Mantenimiento.
SELECT nombre_depto
FROM departamentos
WHERE nombre_depto IN ('Ventas', 'Investigacion', 'Mantenimiento');

#20. Ahora obtener el contrario, los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT nombre_depto
FROM departamentos
WHERE nombre_depto NOT IN ('Ventas', 'Investigacion', 'Mantenimiento');

#21. Mostrar el salario más alto de la empresa.
SELECT MAX(sal_emp) AS salario_maximo
FROM empleados;
SELECT *
FROM empleados
WHERE sal_emp = (SELECT MAX(sal_emp) FROM empleados);

#22. Mostrar el nombre del último empleado de la lista por orden alfabético.
SELECT MAX(nombre) AS ultimo_nombre
FROM empleados; 
SELECT * FROM empleados where nombre = (SELECT MAX(nombre) AS ultimo_nombre
FROM empleados); 

#23. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT MAX(sal_emp) AS salario_alto, MIN(sal_emp) AS salario_min, MAX(sal_emp)-MIN(sal_emp) AS diferencia
FROM empleados;
SELECT 
    MAX(sal_emp) AS salario_alto, 
    MIN(sal_emp) AS salario_min, 
    MAX(sal_emp) - MIN(sal_emp) AS diferencia,
    (
        SELECT nombre 
        FROM empleados 
        WHERE sal_emp = (SELECT MAX(sal_emp) FROM empleados)
    ) AS empleado_salario_alto,
    (
        SELECT nombre 
        FROM empleados 
        WHERE sal_emp = (SELECT MIN(sal_emp) FROM empleados)
    ) AS empleado_salario_bajo
FROM empleados;

#24. Hallar el salario promedio por departamento.
SELECT d.nombre_depto, AVG(sal_emp) AS promedio_por_dpto
FROM empleados AS e
INNER JOIN departamentos AS d
ON e.id_depto = d.id_depto
GROUP BY d.nombre_depto;

#ej inner join id_dpto
SELECT *
FROM empleados
INNER JOIN departamentos
ON empleados.id_depto = departamentos.id_depto;
																																						
#>>Consultas con Having 
#25. Hallar los departamentos que tienen más de tres empleados. 
#Mostrar el número de empleados de esos departamentos.

SELECT COUNT(e.id_emp) AS numero_de_empleados, d.nombre_depto 
FROM empleados AS e
INNER JOIN departamentos AS d
ON e.id_depto = d.id_depto
GROUP BY d.nombre_depto
HAVING COUNT(e.id_emp)>3
ORDER BY COUNT(e.id_emp) ASC;

#26. Hallar los departamentos que no tienen empleados
SELECT COUNT(e.id_emp) AS numero_de_empleados, d.nombre_depto 
FROM empleados AS e
INNER JOIN departamentos AS d
ON e.id_depto = d.id_depto
GROUP BY d.nombre_depto
HAVING COUNT(e.id_emp)=0;

#Consulta con Subconsulta 
#28. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. 
#Ordenarlo por departamento
SELECT *
FROM empleados AS e
WHERE e.sal_emp > (SELECT AVG(sal_emp) 
					FROM empleados 
                    INNER JOIN departamentos AS d
					ON e.id_depto = d.id_depto
                    GROUP BY d.nombre_depto);