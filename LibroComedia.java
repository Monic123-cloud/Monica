import java.io.Serializable;
import Controller.TipoHumor; // Importamos el enum

public class LibroComedia extends Libro implements Serializable {
    private TipoHumor tipoHumor;

    public LibroComedia(TipoHumor tipoHumor)
    {
        this.tipoHumor = tipoHumor;
    }

    public LibroComedia(String autor, int numeroPaginas, String isbn, TipoHumor tipoHumor) {
        super(autor, numeroPaginas, isbn);
        this.tipoHumor = tipoHumor;
    }

    public void setTipoHumor(TipoHumor tipoHumor) {
        this.tipoHumor = tipoHumor;
    }

    public TipoHumor getTipoHumor() {
        return tipoHumor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: Comedia, Tipo de Humor: " + tipoHumor;
    }
}