import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");

        Libro l1=new Libro();
        l1.setTitulo("100 años de soledad");
        l1.setAutor("-gabriel Garcia Marquez");
        l1.setGenero("Novela");
        l1.setCodigoBarras("00001");

        Libro l2=new Libro("Rowlling", "Harry Potter y la pierda filosofal", "Ciencia ficción", "00002");

        Libro l3= new Libro("Baldor", "Operaciones aritmeticas", "Educación", "00003");

        List<Libro> libros=new ArrayList<>();
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);

        Scanner scanner= new Scanner(System.in);
        int opcion= scanner.nextInt();

        System.out.println("\n -- MENU --");
        System.out.println("Opción 1 : Guardar Libro");
        System.out.println("Opción 2: Buscar por Código");
        System.out.println("Opción 3: Mostrar todos los libros ");
        System.out.println("Opción 4: Buscar por genero");
        System.out.println("\n Ingrese una opción");

       
        do {
            System.out.println("\n -- MENU --");
            System.out.println("1. Crear / Registrar un libro");
            System.out.println("2. Buscar por Código");
            System.out.println("3. Mostrar todos los libros registrados");
            System.out.println("4. Buscar por Genero");
            System.out.println("5. Salir (terminar / detener el programa)");
            System.out.print("\nIngrese una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    registrarLibro(libros, scanner);
                    break;
                case 2:
                    buscarPorCodigo(libros, scanner);
                    break;
                case 3:
                    mostrarTodos(libros);
                    break;
                case 4:
                    buscarPorGenero(libros, scanner);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Métodos para cada opción del menu
    static void registrarLibro(List<Libro> libros, Scanner scanner) {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Código de Barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();

        Libro nuevoLibro = new Libro(autor, titulo, genero, codigoBarras);
        libros.add(nuevoLibro);
        System.out.println("Libro registrado exitosamente.");
    }

    static void buscarPorCodigo(List<Libro> libros, Scanner scanner) {
        System.out.print("Ingrese el código a buscar: ");
        String codigo = scanner.nextLine();

        Libro resultado = null;
        for (Libro libro : libros) {
            if (libro.getCodigoBarras().equals(codigo)) {
                resultado = libro;
                break;
            }
        }

        if (resultado != null) {
            System.out.println(resultado); // Imprime la información del libro
        } else {
            System.out.println("No se encontró el código solicitado: " + codigo);
        }
    }

    static void mostrarTodos(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro); // Imprime la información de cada libro
            }
        }
    }

    static void buscarPorGenero(List<Libro> libros, Scanner scanner) {
        System.out.print("Ingrese el género a buscar: ");
        String genero = scanner.nextLine();

        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getGenero().equalsIgnoreCase(genero)) { // Ignora mayúsculas y minúsculas
                librosEncontrados.add(libro);
            }
        }

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontró el género solicitado: " + genero);
        } else {
            for (Libro libro : librosEncontrados) {
                System.out.println(libro); // Imprime la información de cada libro
            }
        }
    }
}
