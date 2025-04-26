import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalogo implements Serializable {
    private Map<String, Libro> libros;
    private int capacidad;
    private static final long serialVersionUID = 1234L;

    public Catalogo() { }

    public void setLibros(Map<String, Libro> libros) {
        this.libros = libros;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Catalogo(int capacidad) {
        this.capacidad = capacidad;
        this.libros = new HashMap<>(capacidad);
    }

    public int getNumeroLibros() {
        return libros.size();
    }

    public void agregarLibro(Libro libro) throws CatalogoLlenoException {
        if (libros.size() == capacidad) {
            throw new CatalogoLlenoException("El catálogo está lleno. No se puede agregar el libro.");
        }
        if (libros.containsKey(libro.getIsbn())) {
            System.out.println("El libro con ISBN " + libro.getIsbn() + " ya existe en el catálogo.");
            return;
        }
        libros.put(libro.getIsbn(), libro);
        System.out.println("Libro con ISBN " + libro.getIsbn() + " agregado al catálogo.");
    }

    public Libro buscarLibro(String isbn) throws LibroNoEncontradoException {
        Libro libro = libros.get(isbn);
        if (libro == null) {
            throw new LibroNoEncontradoException("No se encontró ningún libro con el ISBN: " + isbn);
        }
        return libro;
    }

    public void eliminarLibro(String isbn) {
        if (libros.containsKey(isbn)) {
            libros.remove(isbn);
            System.out.println("Libro con ISBN " + isbn + " eliminado del catálogo.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN: " + isbn + " en el catálogo.");
        }
    }

    public void mostrarTodosLibros() {
        if (libros.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        System.out.println("--- Libros en el Catálogo ---");
        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
        System.out.println("----------------------------");
    }

    public Map<String, Libro> getLibros() { // Añadimos un getter para acceder a los libros
        return libros;
    }


}