package persistencia;

//a) Lista el nombre de todos los productos que hay en la tabla producto.
import entidades.Producto;

//b) Lista los nombres y los precios de todos los productos de la tabla producto.
//c) Listar aquellos productos que su precio esté entre 120 y 202.
//d) Buscar y listar todos los Portátiles de la tabla producto.
//e) Listar el nombre y el precio del producto más barato.
//f) Ingresar un producto a la base de datos.
//g) Ingresar un fabricante a la base de datos
//h) Editar un producto con datos a elección.
public class ProductoDAO extends DAO {

    public void mostrarProductosNombre() throws Exception {
        String sql = "SELECT * FROM producto";
        consultarBase(sql);
        System.out.println("El nombre de los productos es: ");
        while (resultado.next()) {
            String nombre = resultado.getString("nombre");
            System.out.println("Nombre: " + nombre);
        }
    }

    public void mostrarProductosNombreyPrecio() throws Exception {
        String sql = "SELECT precio,nombre FROM producto";
        consultarBase(sql);
        while (resultado.next()) {
            Double precio = resultado.getDouble("precio");
            String nombre = resultado.getString("nombre");
            System.out.println(nombre + " " + precio);
        }
    }

    public void mostrarProductosRangoPrecio(double min, double max) throws Exception {
        String sql = "SELECT * FROM producto WHERE precio BETWEEN " + min + " AND " + max;
        consultarBase(sql);
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nombre = resultado.getString("nombre");
            Double precio = resultado.getDouble("precio");
            int codigoFabricante = resultado.getInt("codigo_fabricante");
            System.out.println(codigo + " " + nombre + " " + precio + " " + codigoFabricante);
        }
    }

    public void mostrarPortatiles() throws Exception {
        String sql = "SELECT * FROM producto where nombre like '%portatil%'";
        consultarBase(sql);
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nombre = resultado.getString("nombre");
            Double precio = resultado.getDouble("precio");
            int codigoFabricante = resultado.getInt("codigo_fabricante");
            System.out.println(codigo + " " + nombre + " " + precio + " " + codigoFabricante);
        }
    }

    public void mostrarMasBarato() throws Exception {
        String sql = "SELECT * FROM producto order by precio limit 1";
        consultarBase(sql);
        while (resultado.next()) {
            int codigo = resultado.getInt("codigo");
            String nombre = resultado.getString("nombre");
            Double precio = resultado.getDouble("precio");
            int codigoFabricante = resultado.getInt("codigo_fabricante");
            System.out.println(codigo + " " + nombre + " " + precio + " " + codigoFabricante);
        }
    }

    public void ingresarProducto(Producto producto) throws Exception {
        String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ("
                + "'" + producto.getNombre() + "',"
                + producto.getPrecio() + ","
                + producto.getCodigo_fabricante() + ")";
        insertarModificarEliminar(sql);
    }

    public void modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombre='" + producto.getNombre()
                + "', precio=" + producto.getPrecio()
                + ", codigo_fabricante=" + producto.getCodigo_fabricante()
                + " WHERE codigo=" + producto.getCodigo();
    }
}
