public class Estudiante extends Usuario {
    private String codigoEstudiante;
    private String carrera;

    public Estudiante(int id, String nombre, String email, String codigoEstudiante, String carrera) {
        super(id, nombre, email);
        this.codigoEstudiante = codigoEstudiante;
        this.carrera = carrera;
    }

    public String getCodigoEstudiante() { return codigoEstudiante; }
    public String getCarrera() { return carrera; }

    public String toString() {
        return "[Estudiante] " + super.toString() +
                " | Código: " + codigoEstudiante +
                " | Carrera: " + carrera;
    }
}