public class Asignatura {
    private int id;
    private String nombre;
    private int creditos;
    private Docente docente;

    public Asignatura(int id, String nombre, int creditos, Docente docente) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public Docente getDocente() { return docente; }

    public String toString() {
        String docNombre = (docente != null) ? docente.getNombre() : "Sin docente";
        return "[Asignatura] ID: " + id + " | Nombre: " + nombre +
                " | Créditos: " + creditos +
                " | Docente: " + docNombre;
    }
}