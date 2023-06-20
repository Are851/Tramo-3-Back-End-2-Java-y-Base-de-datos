/*
6. Se necesita una aplicación para una tienda en la cual queremos almacenar los 
distintos productos que venderemos y el precio que tendrán. Además, se necesita 
que la aplicación cuente con las funciones básicas.  Estas las realizaremos en 
el servicio. Como, introducir un elemento, modificar su precio, eliminar un 
producto y mostrar los productos que tenemos con su precio (Utilizar Hashmap).
El HashMap tendrá de llave el nombre del producto y de valor el precio. 
Realizar un menú para lograr todas las acciones previamente mencionadas.  
 */
package Entidad;

/**
 *
 * @author RobAre
 */
    public class Producto {

        private String nombre;
        private double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return nombre + " - Precio: " + precio;
        }
    }

