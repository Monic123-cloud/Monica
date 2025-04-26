import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Biblioteca implements Serializable {
    private String nombre;
    private String director;
    private Catalogo catalogo;

    public Biblioteca() {}

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
        this.catalogo = null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDirector() {
        return director;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void construirCatalogo(int capacidad) {
        this.catalogo = new Catalogo(capacidad);
        System.out.println("Catálogo construido con capacidad para " + capacidad + " libros.");
    }

    public void buscarInformacionLibro(String isbn) {
        try {
            Libro libro = catalogo.buscarLibro(isbn);
            System.out.println("Información del Libro:");
            System.out.println(libro);
            System.out.println(" ");
        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: El catálogo no ha sido construido aún.");
        }
    }

    public void consultarNumeroLibros() {
        try {
            System.out.println("Número de libros en el catálogo: " + catalogo.getNumeroLibros());
        } catch (NullPointerException e) {
            System.out.println("Error: El catálogo no ha sido construido aún.");
        }
    }

    public void agregarLibroAlCatalogo(Libro libro) {
        try {
            catalogo.agregarLibro(libro);
        } catch (CatalogoLlenoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: El catálogo no ha sido construido aún.");
        }
    }

    public void sacarLibroDelCatalogo(String isbn) {
        try {
            catalogo.eliminarLibro(isbn);
        } catch (NullPointerException e) {
            System.out.println("Error: El catálogo no ha sido creado aún.");
        }
    }

    public void mostrarTodosLibrosDisponibles() {
        try {
            catalogo.mostrarTodosLibros();
        } catch (NullPointerException e) {
            System.out.println("Error: El catálogo no ha sido creado aún.");
        }
    }
    public void exportarCatalogo(String path)
    {
        exportarFichero(path);
    }

    private void exportarFichero(String path) {
        File file = new File(path);

        if (catalogo != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(catalogo);
                System.out.println("Catálogo de libros exportado a " + path);
            } catch (IOException | NullPointerException e) {
                System.err.println("Error al exportar el catálogo a " + path + ": " + e.getMessage());
            }
        } else {
            System.out.println("\nError: No se puede exportar un catálogo inexistente.");
        }
    }
    public void exportarCatalogoATexto(String path) {
        if (catalogo != null) {
            Map<String, Libro> mapaDeLibros = catalogo.getLibros();
            List<Libro> listaDeLibros = new ArrayList<>(mapaDeLibros.values());
            try (FileWriter writer = new FileWriter(path)) {
                writer.write("Catálogo de la Biblioteca\n");
                writer.write("Nombre de la Biblioteca: " + nombre + "\n");
                writer.write("Director: " + director + "\n");
                writer.write("Número de Libros: " + catalogo.getNumeroLibros() + "\n");
                writer.write("-----------------------------------\n");
                for (Libro libro : listaDeLibros) {
                    writer.write(libro.toString() + "\n");
                    writer.write("-----------------------------------\n");
                }
                System.out.println("Catálogo exportado exitosamente a " + path);
            } catch (IOException e) {
                System.err.println("Error al exportar el catálogo a " + path + ": " + e.getMessage());
            }
        } else {
            System.out.println("Error: No se puede exportar un catálogo inexistente.");
        }
    }
}