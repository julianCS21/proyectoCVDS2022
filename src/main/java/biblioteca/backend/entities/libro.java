package biblioteca.backend.entities;

public class libro extends recurso {

    private String titulo;

    private String autor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public libro(int id, String nombre, String ubicacion, String tipo, int capacidad, String descripcion, int disponible, String titulo, String autor) {
        super(id, nombre, ubicacion, tipo, capacidad, descripcion, disponible);
        this.titulo = titulo;
        this.autor = autor;
    }
}
