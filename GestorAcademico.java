import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorAcademico {
    private List<Estudiante> estudiantes = new ArrayList<>();
    private List<Docente> docentes = new ArrayList<>();
    private List<Asignatura> asignaturas = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();

    private int nextEstudianteId = 1;
    private int nextDocenteId = 1;
    private int nextAsignaturaId = 1;

    public Estudiante registrarEstudiante(String nombre, String email, String codigo, String carrera) {
        Estudiante e = new Estudiante(nextEstudianteId++, nombre, email, codigo, carrera);
        estudiantes.add(e);
        return e;
    }

    public Docente registrarDocente(String nombre, String email, String codigo, String departamento) {
        Docente d = new Docente(nextDocenteId++, nombre, email, codigo, departamento);
        docentes.add(d);
        return d;
    }

    public Asignatura registrarAsignatura(String nombre, int creditos, Docente docente) {
        Asignatura a = new Asignatura(nextAsignaturaId++, nombre, creditos, docente);
        asignaturas.add(a);
        return a;
    }

    public Optional<Estudiante> buscarEstudiantePorCodigo(String codigo) {
        return estudiantes.stream()
                .filter(e -> e.getCodigoEstudiante().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public Optional<Docente> buscarDocentePorCodigo(String codigo) {
        return docentes.stream()
                .filter(d -> d.getCodigoDocente().equalsIgnoreCase(codigo))
                .findFirst();
    }

    public Optional<Asignatura> buscarAsignaturaPorId(int id) {
        return asignaturas.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
    }

    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public List<Docente> getDocentes() { return docentes; }
    public List<Asignatura> getAsignaturas() { return asignaturas; }

    public Matricula matricularEstudianteEnAsignatura(Estudiante e, Asignatura a) {
        Optional<Matricula> existente = matriculas.stream()
                .filter(m -> m.getEstudiante().equals(e) && m.getAsignatura().equals(a))
                .findFirst();
        if (existente.isPresent()) return existente.get();

        Matricula m = new Matricula(e, a);
        matriculas.add(m);
        return m;
    }

    public List<Matricula> obtenerMatriculasPorEstudiante(Estudiante e) {
        List<Matricula> result = new ArrayList<>();
        for (Matricula m : matriculas) {
            if (m.getEstudiante().equals(e)) result.add(m);
        }
        return result;
    }
}