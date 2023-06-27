/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Dos {
private static int metodo() {
int valor=0;
try{
valor = valor + 1;
valor = valor + Integer.parseInt ("W");
valor = valor + 1;
System.out.println("Valor final del try: " + valor);
} catch ( NumberFormatException e ) {
valor = valor + Integer.parseInt ("42");
System.out.println("Valor final del catch: " + valor) ;
} finally {
valor = valor + 1;
System.out.println("Valor final del finally: " + valor) ;
}
valor = valor + 1;
System.out.println("Valor antes del return: " + valor) ;
return valor;
}
public static void main (String[] args) {
try{
System.out.println ( metodo ( ) ) ;
} catch(Exception e) {
System.err.println ( "Excepcion en metodo ( ) " ) ;
e.printStackTrace();
}
}
}
/*
run:
Valor final del try: 44
Valor final del finally: 45
Valor antes del return: 46
46
 */