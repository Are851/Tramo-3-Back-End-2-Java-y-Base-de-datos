/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
import entidades.Producto;
import Persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public void selectPorParametro(String nombre) throws Exception {
        dao.selectUnParametro(nombre);
    }

    public void selectPorParametro(String nombre, String precio) throws Exception {
        dao.selectDosParametro(nombre, precio);
    }

    public void listarPorPrecio(double precioMin, double precioMax) throws Exception {
        dao.listarPorPrecio(precioMin, precioMax);
    }

    public void listarPortatiles() throws Exception {
        dao.listarPortatiles();
    }

    public void obtenerProductoMasBarato() throws Exception {
        dao.obtenerProductoMasBarato();
    }

    public void agregarProducto(Producto producto) throws Exception {
        dao.agregarProducto(producto);
    }

    public void editarProducto(Producto producto) throws Exception {
        dao.editarProducto(producto);
    }

    public void eliminarProducto(int codigoProducto) throws Exception {
        dao.eliminarProducto(codigoProducto);
    }

    public void selectAll() {
        try {
            dao.selectAll();
        } catch (Exception e) {
            System.out.println("Error al intentar listar todos los productos: " + e.getMessage());
        }
    }
}