/*
Se plantea desarrollar un programa que nos permita calcular el área y el perímetro
de formas geométricas, en este caso un circulo y un rectángulo. Ya que este
calculo se va a repetir en las dos formas geométricas, vamos a crear una Interfaz,
llamada calculosFormas que tendrá, los dos métodos para calcular el área, el
perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la
interfaz y se calcule el área y el perímetro de los dos. En el main se crearán las
formas y se mostrará el resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2
 */
package Entidad;

import static java.lang.Math.PI;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
//Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.

interface calculosFormas;

public class Circulo implements CalculosFormas {
    private double radio;
  
    public Circulo(double radio) {
        this.radio = radio;
    }
  
    public double calcularArea() {
        return PI * Math.pow(radio, 2);
    }
  
    public double calcularPerimetro() {
        return PI * 2 * radio;
    }
}
