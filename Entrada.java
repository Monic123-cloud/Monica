import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import Controller.TipoHumor;

public class Entrada
{
    public static void main(String[] args) {
        // 1. Creo una biblioteca
        Biblioteca biblioteca = new Biblioteca("Entregable 3", "Mónica Blanco");
        System.out.println("Biblioteca '" + biblioteca.getNombre() + "' creada.");

        // 2. Creo un catálogo de 4 libros
        biblioteca.construirCatalogo(4);
        System.out.println("Catálogo construido con capacidad para 4 libros.");

        // Creo algunos libros
        Libro libro1 = new LibroPoliciaca("Arthur Conan", 321, "9788446041542", "MISTERIO", List.of("Sherlock Holmes"));
        Libro libro2 = new LibroTerror("Bram Stoker", 438, "9788497405935", 9);
        Libro libro3 = new LibroComedia("Groucho Marx", 318, "9788435018371", TipoHumor.SARCASMO);
        Libro libro4 = new LibroEnsayo("Pio Baroja", 396, "9788419136909");
        Libro libro5 = new LibroTerror("Mary Shelley", 264, "9788415601401", 8);
        Libro libro6 = new LibroComedia("George Orwell", 184, "9788423342662", TipoHumor.IRONIA);

        // 3. Agrego 6 libros al catálogo, pero sólo puede haber 4
        biblioteca.agregarLibroAlCatalogo(libro1);
        biblioteca.agregarLibroAlCatalogo(libro2);
        biblioteca.agregarLibroAlCatalogo(libro3);
        biblioteca.agregarLibroAlCatalogo(libro4);
        biblioteca.agregarLibroAlCatalogo(libro5);
        biblioteca.agregarLibroAlCatalogo(libro6);

        // 4. Muestro la información de todos los libros
        System.out.println("Información libros en el catálogo:");
        biblioteca.mostrarTodosLibrosDisponibles();

        // 5. Exporto todos los libros del catálogo a un fichero llamado libros.obj
        System.out.println("Exportando Catálogo");
        biblioteca.exportarCatalogo("C:\\Users\\monic\\IdeaProjects\\Entregable3_2\\libros.obj");
        //no se visualiza bien
        biblioteca.exportarCatalogoATexto("C:\\Users\\monic\\IdeaProjects\\Entregable3_2\\libros.txt");
    }
}