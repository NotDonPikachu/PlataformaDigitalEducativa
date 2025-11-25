public class Docente extends Usuario {
    private String codigoDocente;
    private String departamento;

    public Docente(int id, String nombre, String email, String codigoDocente, String departamento) {
        super(id, nombre, email);
        this.codigoDocente = codigoDocente;
        this.departamento = departamento;
    }

    public String getCodigoDocente() { return codigoDocente; }
    public String getDepartamento() { return departamento; }

    public String toString() {
        return "[Docente] " + super.toString() +
                " | Código: " + codigoDocente +
                " | Depto: " + departamento;
    }
}