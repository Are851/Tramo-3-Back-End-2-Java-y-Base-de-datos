/*
3. Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de
2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
electrodomésticos, 2000 para lavadora y 5000 para televisor.
 */
package guia12teoriaej03.Entidades;

import java.util.Scanner;

public class Televisor extends Electrodomesticos {

    protected int resolucion;
    protected boolean tdt;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean tdt) {
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public Televisor(int resolucion, boolean tdt, double precio, String color, char consumoEnergetico, int peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    public void crearTelevisor() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        super.crearElectrodomestico();

        System.out.print("Ingrese la resolucion: ");
        resolucion = leer.nextInt();

        System.out.print("posee tdt?: ");
        String resp = leer.next();
        if (resp.equalsIgnoreCase("S")) {
            this.tdt = true;
            leer.close();
        }
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (resolucion > 40) {
            setPrecio(getPrecio() * 1.3);
        }
        if (tdt) {
            setPrecio(getPrecio() + 500);
        }
    }

//    @Override
//    public String toString() {
//        return "Televisor{" + "resolucion=" + resolucion + ", tdt=" + tdt + '}';
//    }
}
