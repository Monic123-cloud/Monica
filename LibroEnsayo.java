import java.io.Serializable;

public class LibroEnsayo extends Libro implements Serializable
{
    public LibroEnsayo(String autor, int numeroPaginas, String isbn)
    {
        super(autor, numeroPaginas, isbn);
    }

    public LibroEnsayo() { }

    @Override
    public String toString() {
        return super.toString() + ", Género: Ensayo";
    }
}