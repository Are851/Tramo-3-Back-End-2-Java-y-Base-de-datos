/*
Ejercicio 9 de Excepciones
 */
package Respuestas;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Respuestas {
    /**
    class C {
void metodoC() throws TuException{
sentencia_c1
try {
sentencia_c2
sentencia_c3
} catch (MioException e){
sentencia_c4
} catch (TuException e){
sentencia_c5 throw (e)
}
finally
sentencia_c6 
     9. Dado el método metodoC de la clase C, indique:
a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
Si se produce la excepción MioException:
Se ejecuta sentencia_c1.
Se ejecuta sentencia_c2.
Se ejecuta sentencia_c4 (en el bloque catch correspondiente a MioException).
No se ejecuta sentencia_c5 (pues MioException no coincide con TuException).
No se ejecuta sentencia_c6 (pues la ejecución se desvía al bloque catch y no llega al bloque finally).

b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
Se ejecuta sentencia_c1.
Se ejecuta sentencia_c2.
Se ejecuta sentencia_c3.
No se ejecuta sentencia_c4 (pues no se produce MioException).
No se ejecuta sentencia_c5 (pues no se produce MioException).
Se ejecuta sentencia_c6 (en el bloque finally).

c) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción TuException?
Si se produce la excepción TuException, las sentencias se ejecutarían en el 
siguiente orden:
     * sentencia_c1 
     * sentencia_c2 
     * sentencia_c5 (bloque catch de TuException) 
     * throw (e) (se lanza la excepción TuException) 
     *En todos los casos, la sentencia_c6 (bloque finally) se ejecutará después 
de los bloques try-catch, independientemente de si se produce una excepción o no.
     */
}
