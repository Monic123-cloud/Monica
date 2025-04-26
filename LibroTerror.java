import java.io.Serializable;

public class LibroTerror extends Libro implements Serializable {
    private int calificacion;

    public LibroTerror(String autor, int numeroPaginas, String isbn, int calificacion) {
        super(autor, numeroPaginas, isbn);
        this.calificacion = calificacion;
    }

    public LibroTerror(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: Terror, Calificación: " + calificacion;
    }
}
