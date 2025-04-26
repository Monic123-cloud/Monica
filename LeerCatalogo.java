import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerCatalogo {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libros.obj"))) {
            Catalogo catalogoImportado = (Catalogo) ois.readObject();
            System.out.println("Catálogo importado exitosamente.");
            catalogoImportado.mostrarTodosLibros();

        } catch (IOException e) {
            System.err.println("Error al leer el catálogo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Clase Catalogo no encontrada durante la lectura.");
        }
    }
}