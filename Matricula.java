import java.util.ArrayList;
import java.util.List;

public class Matricula {
    private Estudiante estudiante;
    private Asignatura asignatura;
    private List<Nota> notas = new ArrayList<>();

    public Matricula(Estudiante estudiante, Asignatura asignatura) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Asignatura getAsignatura() { return asignatura; }
    public List<Nota> getNotas() { return notas; }

    public void agregarNota(Nota nota) { notas.add(nota); }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (Nota n : notas) suma += n.getValor();
        return suma / notas.size();
    }

    public String getEstado() {
        double promedio = calcularPromedio();
        return promedio >= 11 ? "APROBADO" : "DESAPROBADO";
    }

    public String toString() {
        return "Matrícula -> Estudiante: " + estudiante.getNombre()
                + " | Asignatura: " + asignatura.getNombre()
                + " | Promedio: " + String.format("%.2f", calcularPromedio())
                + " | Estado: " + getEstado();
    }
}