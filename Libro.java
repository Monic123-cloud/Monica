import java.io.Serializable;

public abstract class Libro implements Serializable {
    private String autor;
    private int numeroPaginas;
    private String isbn;

    public Libro() {}

    public Libro(String autor, int numeroPaginas, String isbn) {
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Autor: " + autor + ", Páginas: " + numeroPaginas + ", ISBN: " + isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return isbn.equals(libro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}