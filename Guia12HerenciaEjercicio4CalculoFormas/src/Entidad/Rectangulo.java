
package Entidad;

/**
 *
 * @author Robert Are "BlackDragon" <https://github.com/Are851>
 *   <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */

    interface calculosFormas;

    public class Rectangulo implements calculosFormas {

    private double base;
    private double altura;

    public Rectangulo() {
    }

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return this.altura * this.base;
    }

    @Override
    public double calcularPerimetro() {
        return (this.base + this.altura) * 2;
    }

}

