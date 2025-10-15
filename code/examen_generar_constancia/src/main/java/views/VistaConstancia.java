package views;
import controllers.ControlConstancia;
import dtos.AlumnoDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import models.Alumno;
import models.IObserver;
import models.ISubject;
import models.Materia;
/**
 *
 * @author Usuario
 */
public class VistaConstancia extends javax.swing.JFrame implements IObserver{
    
    private String RUTA_IMAGEN_ICONO_APLICACION = "/logoGenerarConstancia.png";
    private Font FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA = new Font("Verdana", 1, 12);
    private Font FUENTE_LETRA_TITULO_PANEL_TABLA = new Font("Verdana", 1, 24);
    
    /**
     * Creates new form VistaConstancia
     */
    public VistaConstancia() {
        initComponents();
        setTitle("Generar Constancia de alumno inscrito");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource(RUTA_IMAGEN_ICONO_APLICACION)).getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        setIconImage(iconoPropio);
    }

    public void mostrarAlumnosEnTabla(List<AlumnoDTO> listaAlumnos) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Alumno");

        if (listaAlumnos != null) {
            for (AlumnoDTO alumno : listaAlumnos) {
                Object[] fila = { alumno.getId(), alumno.getNombre() };
                modelo.addRow(fila);
            }
        }

        tableAlumnos.setModel(modelo);
        tableAlumnos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableAlumnos.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    public void iniciarBuscador(ControlConstancia controlador) {
        textBuscarAlumno.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { filtrar(); }

            private void filtrar() {
                if (!controlador.isBusquedaBloqueada()) {
                    String texto = textBuscarAlumno.getText().trim();
                    List<AlumnoDTO> filtrados = controlador.buscarAlumnosPorId(texto);
                    mostrarAlumnosEnTabla(filtrados);
                }
            }
        });
    }

    public void iniciarSeleccionAlumno(ControlConstancia controlador) {
        tableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tableAlumnos.getSelectedRow();
                if (fila >= 0 && !controlador.isBusquedaBloqueada()) {
                    int idAlumno = (int) tableAlumnos.getValueAt(fila, 0);
                    controlador.seleccionarAlumno(idAlumno);

                    // Bloquear el campo de búsqueda
                    textBuscarAlumno.setEnabled(false);
                    tableAlumnos.setEnabled(false);

                    // Obtener datos del alumno seleccionado
                    Alumno alumno = controlador.getAlumnoSeleccionado();

                    // Limpiar panel antes de agregar datos
                    panelConstancia.removeAll();

                    // Mantener tamaño fijo del panel
                    panelConstancia.setPreferredSize(new Dimension(480, panelConstancia.getHeight()));
                    panelConstancia.setMaximumSize(new Dimension(480, panelConstancia.getHeight()));

                    // Layout vertical general
                    panelConstancia.setLayout(new BoxLayout(panelConstancia, BoxLayout.Y_AXIS));

                    // Título centrado
                    JLabel titulo = new JLabel("Datos del alumno");
                    titulo.setFont(FUENTE_LETRA_TITULO_PANEL_TABLA);
                    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panelConstancia.add(Box.createRigidArea(new Dimension(0, 35)));
                    panelConstancia.add(titulo);
                    panelConstancia.add(Box.createRigidArea(new Dimension(0, 20)));

                    // Panel para información del alumno con margen interno
                    JPanel infoPanel = new JPanel();
                    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
                    infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    infoPanel.setOpaque(false);
                    infoPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20)); // margen izquierdo y derecho

                    JLabel nombre = new JLabel("Nombre completo: " + alumno.getNombre());
                    JLabel programa = new JLabel("Programa: " + alumno.getPrograma());
                    JLabel ciclo = new JLabel("Ciclo escolar: " + alumno.getCicloEscolar());
                    JLabel semestre = new JLabel("Semestre inscrito: " + alumno.getSemestreInscrito());
                    JLabel numMaterias = new JLabel("Cantidad de materias: " + alumno.getNumMaterias());

                    nombre.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                    programa.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                    ciclo.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                    semestre.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                    numMaterias.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);

                    nombre.setAlignmentX(Component.LEFT_ALIGNMENT);
                    programa.setAlignmentX(Component.LEFT_ALIGNMENT);
                    ciclo.setAlignmentX(Component.LEFT_ALIGNMENT);
                    semestre.setAlignmentX(Component.LEFT_ALIGNMENT);
                    numMaterias.setAlignmentX(Component.LEFT_ALIGNMENT);

                    infoPanel.add(nombre);
                    infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    infoPanel.add(programa);
                    infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    infoPanel.add(ciclo);
                    infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    infoPanel.add(semestre);
                    infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    infoPanel.add(numMaterias);

                    panelConstancia.add(infoPanel);
                    panelConstancia.add(Box.createRigidArea(new Dimension(0, 20)));

                    // Panel para botones
                    JPanel botonesPanel = new JPanel();
                    botonesPanel.setOpaque(false);
                    botonesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.X_AXIS));

                    JButton btnCancelar = new JButton("Cancelar");
                    JButton btnGenerar = new JButton("Generar constancia");
                    
                    btnGenerar.setBackground(new Color(181, 242, 148));
                    btnGenerar.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                    btnCancelar.setBackground(new Color(247, 153, 153));
                    btnCancelar.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);

                    botonesPanel.add(btnCancelar);
                    botonesPanel.add(Box.createRigidArea(new Dimension(10, 0)));
                    botonesPanel.add(btnGenerar);

                    panelConstancia.add(botonesPanel);
                    panelConstancia.add(Box.createVerticalGlue());

                    btnCancelar.addActionListener(ev -> {
                        // Lógica del controlador
                        controlador.cancelarConstancia();

                        // Limpiar panel y restaurar estado
                        panelConstancia.removeAll();
                        panelConstancia.revalidate();
                        panelConstancia.repaint();

                        textBuscarAlumno.setEnabled(true);
                        tableAlumnos.setEnabled(true);
                    });

                    // Acción del botón Generar constancia
                    btnGenerar.addActionListener(ev -> {
                        
                        controlador.generarConstancia();
                        // Limpiar panel actual
                        panelConstancia.removeAll();
                        panelConstancia.setLayout(new BoxLayout(panelConstancia, BoxLayout.Y_AXIS));

                        // Título
                        JLabel tituloConstancia = new JLabel("Constancia de Inscripción");
                        tituloConstancia.setFont(FUENTE_LETRA_TITULO_PANEL_TABLA);
                        tituloConstancia.setAlignmentX(Component.CENTER_ALIGNMENT);
                        panelConstancia.add(Box.createRigidArea(new Dimension(0, 35)));
                        panelConstancia.add(tituloConstancia);
                        panelConstancia.add(Box.createRigidArea(new Dimension(0, 30)));

                        // Texto descriptivo
                        JTextArea texto = new JTextArea();
                        texto.setEditable(false);
                        texto.setLineWrap(true);
                        texto.setWrapStyleWord(true);
                        texto.setOpaque(false);
                        texto.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);

                        texto.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25));
                        
                        StringBuilder sb = new StringBuilder();
                        sb.append("Por este medio hacemos constar que el alumno ")
                          .append(alumno.getNombre())
                          .append(" perteneciente a la carrera de ")
                          .append(alumno.getPrograma())
                          .append(" se encuentra inscrito en el ciclo escolar ")
                          .append(alumno.getCicloEscolar())
                          .append(" en su semestre número ")
                          .append(alumno.getSemestreInscrito())
                          .append(", cursando las siguientes materias:\n\n");

                        // Agregar lista de materias
                        for (Materia materia : alumno.getMaterias()) {
                            sb.append("• ").append(materia.getNombre()).append("\n");
                        }

                        texto.setText(sb.toString());
                        texto.setAlignmentX(Component.LEFT_ALIGNMENT);

                        JScrollPane scrollTexto = new JScrollPane(texto);
                        scrollTexto.setBorder(null);
                        scrollTexto.setOpaque(false);
                        scrollTexto.getViewport().setOpaque(false);
                        scrollTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
                        scrollTexto.setPreferredSize(new Dimension(450, 300));

                        panelConstancia.add(scrollTexto);
                        panelConstancia.add(Box.createRigidArea(new Dimension(0, 30)));

                        // Botón Regresar
                        JButton btnRegresar = new JButton("Regresar");
                        btnRegresar.setBackground(new Color(181, 242, 148));
                        btnRegresar.setFont(FUENTE_LETRA_TEXTO_PANEL_CONSTANCIA);
                        btnRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);

                        panelConstancia.add(btnRegresar);
                        panelConstancia.add(Box.createVerticalGlue());

                        // Acción del botón Regresar
                        btnRegresar.addActionListener(backEv -> {
                            controlador.regresarBusqueda();
                            panelConstancia.removeAll();
                            panelConstancia.revalidate();
                            panelConstancia.repaint();
                            textBuscarAlumno.setEnabled(true);
                            tableAlumnos.setEnabled(true);
                        });

                        panelConstancia.revalidate();
                        panelConstancia.repaint();
                    });
                    
                    panelConstancia.revalidate();
                    panelConstancia.repaint();
                }
            }
        });
    }
    
    @Override
    public void notificar(String mensaje, ISubject origen) {
        switch (mensaje) {
            case "ALUMNO_SELECCIONADO":
                System.out.println("Se ha seleccionado un alumno.");
                break;
            case "ALUMNO_CANCELADO":
                System.out.println("Se ha cancelado la seleccion del alumno.");
                break;
                case "REGRESAR_A_BUSQUEDA":
                System.out.println("Se ha regresado a la busqueda de alumnos.");
                break;
            case "CONSTANCIA_GENERADA":
                System.out.println("Se ha generado la constancia del alumno.");
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelTabla = new RoundedPanel(50, new Color(224,224,224));
        labelTituloTabla = new javax.swing.JLabel();
        textBuscarAlumno = new javax.swing.JTextField();
        scrollPaneTabla = new javax.swing.JScrollPane();
        tableAlumnos = new javax.swing.JTable();
        panelConstancia = new RoundedPanel(50, new Color(224,224,224));
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(172, 203, 255));

        panelTabla.setBackground(null);

        labelTituloTabla.setBackground(new java.awt.Color(0, 0, 0));
        labelTituloTabla.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelTituloTabla.setForeground(new java.awt.Color(0, 0, 0));
        labelTituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTituloTabla.setText("Buscar alumno");

        textBuscarAlumno.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tableAlumnos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Alumno"
            }
        ));
        scrollPaneTabla.setViewportView(tableAlumnos);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPaneTabla)
                    .addComponent(textBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(labelTituloTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelTituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textBuscarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panelConstancia.setBackground(null);

        javax.swing.GroupLayout panelConstanciaLayout = new javax.swing.GroupLayout(panelConstancia);
        panelConstancia.setLayout(panelConstanciaLayout);
        panelConstanciaLayout.setHorizontalGroup(
            panelConstanciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        panelConstanciaLayout.setVerticalGroup(
            panelConstanciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelTitulo.setBackground(new java.awt.Color(90, 137, 255));

        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Generar Constancia de alumno inscrito");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(panelConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelConstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloTabla;
    private javax.swing.JPanel panelConstancia;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollPaneTabla;
    private javax.swing.JTable tableAlumnos;
    private javax.swing.JTextField textBuscarAlumno;
    // End of variables declaration//GEN-END:variables

    class RoundedPanel extends JPanel{
        private Color backgroundColor;
        private int cornerRadius = 15;
        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }
        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
            
        }
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());

        }
    }
    
}