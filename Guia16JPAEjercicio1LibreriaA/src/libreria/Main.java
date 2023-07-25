package libreria;
/*
 1. Sistema de Guardado de una Librería
El objetivo de este ejercicio es el desarrollo de un sistema de guardado de libros en JAVA
utilizando una base de datos MySQL y JPA como framework de persistencia.
Creación de la Base de Datos MySQL:
Lo primero que se debe hacer es crear la base de datos sobre el que operará el sistema de
reservas de libros. Para ello, se debe abrir el IDE de base de datos que se está utilizando
(Workbench) y ejecutar la siguiente sentencia:
CREATE DATABASE libreria;
De esta manera se habrá creado una base de datos vacía llamada librería.
Paquetes del Proyecto Java:
Los paquetes que se utilizarán para este proyecto son los siguientes:
Ø entidades: en este paquete se almacenarán aquellas clases que se quiere
persistir en la base de datos.
Ø servicios: en este paquete se almacenarán aquellas clases que llevarán adelante
la lógica del negocio. En general se crea un servicio para administrar las
operaciones CRUD (Create, Remove, Update, Delele) cada una de las entidades
y las consultas de cada entidad.
Nota: En este proyecto vamos a eliminar entidades, pero no es considerado una buena
practica. Por esto, además de eliminar nuestras entidades, vamos a practicar que nuestras
entidades estén dados de alta o de baja. Por lo que las entidades tendrán un atributo alta
booleano, que estará en true al momento de crearlas y en false cuando las demos de baja,
que sería cuando se quiere eliminar esa entidad.
a) Entidades
Crearemos el siguiente modelo de entidades:
Entidad Libro
La entidad libro modela los libros que están disponibles en la biblioteca para ser
prestados. En esta entidad, el atributo “ejemplares” contiene la cantidad total de
ejemplares de ese libro, mientras que el atributo “ejemplaresPrestados” contiene
cuántos de esos ejemplares se encuentran prestados en este momento y el atributo
“ejemplaresRestantes” contiene cuántos de esos ejemplares quedan para prestar.
Entidad Autor
La entidad autor modela los autores de libros.
Entidad Editorial
La entidad editorial modela las editoriales que publican libros.
b) Unidad de Persistencia
Para configurar la unidad de persistencia del proyecto, se recomienda leer el Instructivo
Unidad de Persistencia recuerde hacer click con el botón derecho sobre el proyecto y
seleccionar nuevo. A continuación, se debe seleccionar la opción de Persistence Unit
como se indica en la siguiente imagen.
Base de Datos
Para este proyecto nos vamos a conectar a la base de datos Librería, que creamos
previamente.
Generación de Tablas
La estrategia de generación de tablas define lo que hará JPA en cada ejecución, si debe
crear las tablas faltantes, si debe eliminar todas las tablas y volver a crearlas o no hacer
nada. Recomendamos en este proyecto utilizar la opción: “Create”
Librería de Persistencia
Se debe seleccionar para este proyecto la librería “EclipseLink”.
c) Servicios
AutorServicio
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar autores (consulta, creación, modificación y eliminación).
EditorialServicio
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar editoriales (consulta, creación, modificación y eliminación)
LibroServicio
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar libros (consulta, creación, modificación y eliminación).
20
d) Main
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para interactuar con el usuario. En esta clase se muestra el menú de opciones con las
operaciones disponibles que podrá realizar el usuario.
e) Tareas a Realizar
Al alumno le toca desarrollar, las siguientes funcionalidades:
1) Crear base de datos Librería
2) Crear unidad de persistencia
3) Crear entidades previamente mencionadas ( excepto Préstamo )
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título.
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
Ejercicio Extra
Sistema de Reservas de una Librería
Vamos a continuar con el ejercicio anterior. Ahora el objetivo de este ejercicio es el
desarrollo de un sistema de reserva de libros en JAVA. Para esto vamos a tener que
sumar nuevas entidades a nuestro proyecto en el paquete de entidades y crearemos los
servicios de esas entidades.
Usaremos la misma base de datos y se van a crear las tablas que nos faltan. Deberemos
agregar las entidades a la unidad de persistencia.
a) Entidades
Crearemos el siguiente modelo de entidades:
Entidad Cliente
La entidad cliente modela los clientes (a quienes se les presta libros) de la biblioteca. Se
almacenan los datos personales y de contacto de ese cliente.
Entidad Préstamo
La entidad préstamo modela los datos de un préstamo de un libro. Esta entidad registra
la fecha en la que se efectuó el préstamo y la fecha en la que se devolvió el libro. Esta
entidad también registra el libro que se llevo en dicho préstamo y quien fue el cliente al
cual se le prestaron.
b) Servicios
ClienteServicio
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para administrar clientes (consulta, creación, modificación y eliminación).
PrestamoServicio
Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias
para generar prestamos, va a guardar la información del cliente y del libro para persistirla
en la base de datos. (consulta, creación, modificación y eliminación).
c) Tareas a Realizar
Al alumno le toca desarrollar, las siguientes funcionalidades:
1. Creación de un Cliente nuevo
2. Crear entidad Préstamo
3. Registrar el préstamo de un libro.
4. Devolución de un libro
5. Búsqueda de todos los prestamos de un Cliente.
6. Agregar validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados.
• No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más
ejemplares de los que hay, ni devolver más de los que se encuentran prestados.
No se podrán prestar libros con fecha anterior a la fecha actual, etc.
 */
import java.util.Scanner;
import static javafx.scene.input.KeyCode.T;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;
import persistencia.DAO;
/**
 *
 * @author Rober Are  <https://github.com/Are851>
 * <https://www.linkedin.com/in/robert-arevalo-2438a9277/>
 */
public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        ClienteServicio cs = new ClienteServicio();
        PrestamoServicio ps = new PrestamoServicio();
        DAO  dao=new DAO();
        boolean menu = true;
        do {
            System.out.println("\n");
            System.out.println("1. Agregar autor, editorial, o libro.");
            System.out.println("2. Dar de alta/baja o editar autor, editorial, o libro.");
            System.out.println("3. Buscar Autor por nombre");
            System.out.println("4. Buscar libro por ISBN");
            System.out.println("5. Buscar libro por Título");
            System.out.println("6. Buscar libro/s por nombre de Autor");
            System.out.println("7. Buscar libro/s por nombre de Editorial");
            System.out.println("8. Prestar libro");
            System.out.println("9. Lista de autores,clientes, editoriales y libros");
            System.out.println("10. Salir");

            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Autor");
                    System.out.println("2. Editorial");
                    System.out.println("3. Libro");
                    opcion = leer.nextInt();
                    switch (opcion) {
                        case 1:
                            as.guardarAutor();
                            break;
                        case 2:
                            es.guardarEditorial();
                            break;
                        case 3:
                            ls.guardarLibro();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 2:
                    System.out.println("1. Autor");
                    System.out.println("2. Editorial");
                    System.out.println("3. Libro");
                    opcion = leer.nextInt();

                    switch (opcion) {
                        case 1:
                            as.darBajaAutor();
                            break;
                        case 2:
                            es.darBajaEditorial();
                            break;
                        case 3:
                            ls.darBajaLibro();
                            break;
                        default:
                            System.out.println("Opción no reconocida.");
                    }
                    break;
                case 3:
                    as.buscarAutorNombre();
                    break;
                case 4:
                    ls.buscarLibroIsbn();
                    break;
                case 5:
                    ls.buscarLibroTitulo();
                    break;
                case 6:
                    ls.buscarLibroAutor();
                    break;
                case 7:
                    ls.buscarLibroEditorial();
                    break;
                case 8:
                    System.out.println(ls.consultarLibro());
                    ps.consultarPrestamo();
                    System.out.println(cs.consultarCliente());
                    ps.prestamoLibro();
                    break;
                    case 9:
                    System.out.println(as.mostrarAutores());
                    System.out.println(cs.consultarCliente());
                    System.out.println(ls.consultarLibro());
                    es.consultarEditorial();
                    break;
                case 10:
                    menu = false;
                    System.out.println("Gracias por usar mi programa!");
                    break;
                default:
                    System.out.println("Opción no reconocida. Por favor, elige una opción del menú.");
            }
        } while (menu);
        System.out.println("\n\n");
        System.out.println("*************** RA ***************");
        System.out.println("\n\n");

    }

}
