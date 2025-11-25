import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JWindow;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class PlataformaNotasApp {

    // ================== SPLASH / LOADING ==================

    private static void mostrarSplashYArrancar() {
        JWindow splash = new JWindow();
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(20, 33, 61));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("Plataforma Digital Educativa", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);

        JLabel subtitulo = new JLabel("Creado por el Grupo 4", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitulo.setForeground(new Color(200, 213, 255));

        JLabel cargando = new JLabel("Cargando...", SwingConstants.CENTER);
        cargando.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        cargando.setForeground(Color.WHITE);

        JProgressBar barra = new JProgressBar();
        barra.setIndeterminate(true);
        barra.setPreferredSize(new Dimension(250, 18));
        barra.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel centro = new JPanel(new GridLayout(3, 1, 5, 5));
        centro.setOpaque(false);
        centro.add(titulo);
        centro.add(subtitulo);
        centro.add(cargando);

        panel.add(centro, BorderLayout.CENTER);
        panel.add(barra, BorderLayout.SOUTH);

        splash.getContentPane().add(panel);
        splash.pack();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        Timer timer = new Timer(2000, e -> {
            splash.dispose();
            VentanaPrincipal v = new VentanaPrincipal();
            v.setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }

    // ================== MAIN ==================

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            mostrarSplashYArrancar();
        });
    }
}