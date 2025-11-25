import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {

    private GestorAcademico gestor;
    private JTextArea txtArea;

    public VentanaPrincipal() {
        gestor = new GestorAcademico();
        inicializarDatosEjemplo();
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Plataforma Digital Educativa - Gestión Académica");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color colorFondo = new Color(245, 248, 255);
        Color colorPanelLateral = new Color(230, 236, 250);
        Color colorBoton = new Color(78, 115, 223);

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(Color.WHITE);
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel lblTitulo = new JLabel("Plataforma Digital Educativa", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(45, 55, 72));

        JLabel lblSubtitulo = new JLabel("Gestión de alumnos, docentes, asignaturas y notas", SwingConstants.LEFT);
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(100, 116, 139));

        panelTitulo.add(lblTitulo, BorderLayout.NORTH);
        panelTitulo.add(lblSubtitulo, BorderLayout.SOUTH);

        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelLateral.setBackground(colorPanelLateral);

        JButton btnRegistrarEstudiante = crearBoton("Registrar estudiante", colorBoton, Color.BLACK);
        JButton btnRegistrarDocente = crearBoton("Registrar docente", colorBoton, Color.BLACK);
        JButton btnRegistrarAsignatura = crearBoton("Registrar asignatura", colorBoton, Color.BLACK);
        JButton btnMatricular = crearBoton("Matricular estudiante", colorBoton, Color.BLACK);
        JButton btnRegistrarNota = crearBoton("Registrar nota", colorBoton, Color.BLACK);
        JButton btnVerReporte = crearBoton("Ver reporte estudiante", colorBoton, Color.BLACK);
        JButton btnSalir = crearBoton("Salir", new Color(220, 53, 69), Color.BLACK);

        panelLateral.add(btnRegistrarEstudiante);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnRegistrarDocente);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnRegistrarAsignatura);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnMatricular);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnRegistrarNota);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnVerReporte);
        panelLateral.add(Box.createVerticalStrut(8));
        panelLateral.add(btnSalir);

        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtArea.setBackground(Color.WHITE);
        txtArea.setForeground(new Color(30, 41, 59));
        txtArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollArea = new JScrollPane(txtArea);
        scrollArea.setBorder(BorderFactory.createTitledBorder("Registro de acciones y reportes"));

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(colorFondo);
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentro.add(scrollArea, BorderLayout.CENTER);

        getContentPane().setBackground(colorFondo);
        add(panelTitulo, BorderLayout.NORTH);
        add(panelLateral, BorderLayout.WEST);
        add(panelCentro, BorderLayout.CENTER);

        btnRegistrarEstudiante.addActionListener(e -> registrarEstudiante());
        btnRegistrarDocente.addActionListener(e -> registrarDocente());
        btnRegistrarAsignatura.addActionListener(e -> registrarAsignatura());
        btnMatricular.addActionListener(e -> matricularEstudiante());
        btnRegistrarNota.addActionListener(e -> registrarNota());
        btnVerReporte.addActionListener(e -> verReporteEstudiante());
        btnSalir.addActionListener(e -> dispose());

        appendLog("Bienvenido a la Plataforma Digital Educativa.\n");
        appendLog("Use los botones de la izquierda para gestionar la información.\n\n");
    }

    private JButton crearBoton(String texto, Color fondo, Color textoColor) {
        JButton btn = new JButton(texto);
        btn.setFocusPainted(false);
        btn.setBackground(fondo);
        btn.setForeground(textoColor);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setPreferredSize(new Dimension(220, 40));
        btn.setMaximumSize(new Dimension(220, 40));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        return btn;
    }

    private void inicializarDatosEjemplo() {
        Docente docenteEjemplo = gestor.registrarDocente(
                "María Pérez", "maria.perez@instituto.edu", "DOC001", "Sistemas");
        Estudiante estudianteEjemplo = gestor.registrarEstudiante(
                "Lucía Gómez", "lucia.gomez@correo.com", "EST001", "Ingeniería de Software");

        Asignatura asig1 = gestor.registrarAsignatura(
                "Programación Orientada a Objetos", 4, docenteEjemplo);
        gestor.registrarAsignatura(
                "Base de Datos I", 3, docenteEjemplo);
        gestor.registrarAsignatura(
                "Arquitectura de Computadoras", 3, docenteEjemplo);
        gestor.registrarAsignatura(
                "Matemática Discreta", 4, docenteEjemplo);
        
        gestor.matricularEstudianteEnAsignatura(estudianteEjemplo, asig1);
    }

    private void appendLog(String texto) {
        txtArea.append(texto);
    }

    private String pedirTexto(String mensaje) {
        String valor = JOptionPane.showInputDialog(this, mensaje);
        if (valor == null) return null;
        valor = valor.trim();
        if (valor.isEmpty()) return null;
        return valor;
    }

    private void registrarEstudiante() {
        String nombre = pedirTexto("Nombre del estudiante:");
        if (nombre == null) return;

        String email = pedirTexto("Email del estudiante:");
        if (email == null) return;

        String codigo = pedirTexto("Código del estudiante (ej. EST002):");
        if (codigo == null) return;

        String carrera = pedirTexto("Carrera del estudiante:");
        if (carrera == null) return;

        Estudiante e = gestor.registrarEstudiante(nombre, email, codigo, carrera);
        appendLog("Estudiante registrado:\n" + e + "\n\n");
        JOptionPane.showMessageDialog(this, "Estudiante registrado correctamente.");
    }

    private void registrarDocente() {
        String nombre = pedirTexto("Nombre del docente:");
        if (nombre == null) return;

        String email = pedirTexto("Email del docente:");
        if (email == null) return;

        String codigo = pedirTexto("Código del docente (ej. DOC002):");
        if (codigo == null) return;

        String departamento = pedirTexto("Departamento del docente:");
        if (departamento == null) return;

        Docente d = gestor.registrarDocente(nombre, email, codigo, departamento);
        appendLog("Docente registrado:\n" + d + "\n\n");
        JOptionPane.showMessageDialog(this, "Docente registrado correctamente.");
    }

    private void registrarAsignatura() {
        if (gestor.getDocentes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay docentes registrados. Registra uno primero.");
            return;
        }

        String nombre = pedirTexto("Nombre de la asignatura:");
        if (nombre == null) return;

        String creditosStr = pedirTexto("Créditos de la asignatura:");
        if (creditosStr == null) return;

        int creditos;
        try {
            creditos = Integer.parseInt(creditosStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Créditos inválidos.");
            return;
        }

        String[] opcionesDocentes = gestor.getDocentes().stream()
                .map(d -> d.getCodigoDocente() + " - " + d.getNombre())
                .toArray(String[]::new);

        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione un docente:",
                "Docente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesDocentes,
                opcionesDocentes[0]
        );

        if (seleccion == null) return;

        String[] partes = seleccion.split(" - ");
        String codigoDoc = partes[0];

        Optional<Docente> docenteOpt = gestor.buscarDocentePorCodigo(codigoDoc);
        if (docenteOpt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Docente no encontrado.");
            return;
        }

        Asignatura a = gestor.registrarAsignatura(nombre, creditos, docenteOpt.get());
        appendLog("Asignatura registrada:\n" + a + "\n\n");
        JOptionPane.showMessageDialog(this, "Asignatura registrada correctamente.");
    }

    private void matricularEstudiante() {
        if (gestor.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes registrados.");
            return;
        }
        if (gestor.getAsignaturas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay asignaturas registradas.");
            return;
        }

        String[] opcionesEst = gestor.getEstudiantes().stream()
                .map(e -> e.getCodigoEstudiante() + " - " + e.getNombre())
                .toArray(String[]::new);

        String selEst = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione un estudiante:",
                "Matricular estudiante",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEst,
                opcionesEst[0]
        );
        if (selEst == null) return;

        String[] partesEst = selEst.split(" - ");
        String codEst = partesEst[0];

        Optional<Estudiante> estOpt = gestor.buscarEstudiantePorCodigo(codEst);
        if (estOpt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.");
            return;
        }

        String[] opcionesAsig = gestor.getAsignaturas().stream()
                .map(a -> a.getId() + " - " + a.getNombre())
                .toArray(String[]::new);

        String selAsig = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione una asignatura:",
                "Asignatura",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesAsig,
                opcionesAsig[0]
        );
        if (selAsig == null) return;

        String[] partesAsig = selAsig.split(" - ");
        String idStr = partesAsig[0];

        int idAsig;
        try {
            idAsig = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID de asignatura inválido.");
            return;
        }

        Optional<Asignatura> asigOpt = gestor.buscarAsignaturaPorId(idAsig);
        if (asigOpt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Asignatura no encontrada.");
            return;
        }

        Matricula m = gestor.matricularEstudianteEnAsignatura(estOpt.get(), asigOpt.get());
        appendLog("Matrícula registrada:\n" + m + "\n\n");
        JOptionPane.showMessageDialog(this, "Matrícula registrada correctamente.");
    }

    private void registrarNota() {
        if (gestor.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes registrados.");
            return;
        }

        String[] opcionesEst = gestor.getEstudiantes().stream()
                .map(e -> e.getCodigoEstudiante() + " - " + e.getNombre())
                .toArray(String[]::new);

        String selEst = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione un estudiante:",
                "Registrar Nota",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEst,
                opcionesEst[0]
        );
        if (selEst == null) return;

        String[] partesEst = selEst.split(" - ");
        String codEst = partesEst[0];

        Optional<Estudiante> estOpt = gestor.buscarEstudiantePorCodigo(codEst);
        if (estOpt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.");
            return;
        }

        Estudiante est = estOpt.get();
        List<Matricula> mats = gestor.obtenerMatriculasPorEstudiante(est);

        if (mats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El estudiante no tiene matrículas.");
            return;
        }

        String[] opcionesMat = mats.stream()
                .map(m -> m.getAsignatura().getNombre())
                .toArray(String[]::new);

        String selMat = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione una asignatura para registrar nota:",
                "Asignatura",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesMat,
                opcionesMat[0]
        );
        if (selMat == null) return;

        Matricula matriculaSeleccionada = null;
        for (Matricula m : mats) {
            if (m.getAsignatura().getNombre().equals(selMat)) {
                matriculaSeleccionada = m;
                break;
            }
        }

        if (matriculaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la matrícula.");
            return;
        }

        String tipo = pedirTexto("Tipo de nota (Parcial, Final, etc.):");
        if (tipo == null) return;

        String valorStr = pedirTexto("Valor de la nota:");
        if (valorStr == null) return;

        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor de nota inválido.");
            return;
        }

        matriculaSeleccionada.agregarNota(new Nota(tipo, valor));
        appendLog("Nota registrada en " + matriculaSeleccionada.getAsignatura().getNombre() +
                " para " + est.getNombre() + " -> " + tipo + ": " + valor + "\n\n");
        JOptionPane.showMessageDialog(this, "Nota registrada correctamente.");
    }

    private void verReporteEstudiante() {
        if (gestor.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes registrados.");
            return;
        }

        String[] opcionesEst = gestor.getEstudiantes().stream()
                .map(e -> e.getCodigoEstudiante() + " - " + e.getNombre())
                .toArray(String[]::new);

        String selEst = (String) JOptionPane.showInputDialog(
                this,
                "Seleccione un estudiante:",
                "Reporte Académico",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesEst,
                opcionesEst[0]
        );
        if (selEst == null) return;

        String[] partesEst = selEst.split(" - ");
        String codEst = partesEst[0];

        Optional<Estudiante> estOpt = gestor.buscarEstudiantePorCodigo(codEst);
        if (estOpt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado.");
            return;
        }

        Estudiante est = estOpt.get();
        List<Matricula> mats = gestor.obtenerMatriculasPorEstudiante(est);

        if (mats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El estudiante no tiene matrículas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Reporte académico de ").append(est.getNombre()).append(":\n\n");
        for (Matricula m : mats) {
            sb.append("Asignatura: ").append(m.getAsignatura().getNombre()).append("\n");
            sb.append("Notas:\n");
            for (Nota n : m.getNotas()) {
                sb.append(" - ").append(n.toString()).append("\n");
            }
            sb.append("Promedio: ").append(String.format("%.2f", m.calcularPromedio())).append("\n");
            sb.append("Estado: ").append(m.getEstado()).append("\n");
            sb.append("---------------------------------------\n");
        }

        appendLog(sb.toString() + "\n");
        JOptionPane.showMessageDialog(this, sb.toString(), "Reporte Académico", JOptionPane.INFORMATION_MESSAGE);
    }
}