import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class LibroPoliciaca extends Libro implements Serializable {
    private String trama;
    private List<String> personajes;

    public LibroPoliciaca(String trama, List<String> personajes)
    {
        this.trama = trama;
        this.personajes = personajes;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public void setPersonajes(List<String> personajes) {
        this.personajes = personajes;
    }

    public LibroPoliciaca(String autor, int numeroPaginas, String isbn, String trama, List<String> personajes) {
        super(autor, numeroPaginas, isbn);
        this.trama = trama;
        this.personajes = new ArrayList<>(personajes);
    }

    public String getTrama() {
        return trama;
    }

    public List<String> getPersonajes() {
        return personajes;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: Policiaca, Trama: " + trama + ", Personajes: " + personajes;
    }
}