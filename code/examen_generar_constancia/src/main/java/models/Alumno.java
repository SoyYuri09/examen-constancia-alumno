package models;
import dtos.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;
/**
 * Alumno.java
 *
 * Clase entidad que representa un alumno
 * con todos sus datos dentro de la institución.
 * 
 * @author Yuri Germán García López
 * ID: 00000252583
 *
 */
public class Alumno implements ISubject{
    
    //Declaración de variables
    private String nombre;
    private int id;
    private String programa;
    private String cicloEscolar;
    private int semestreInscrito;
    private List<Materia> materias;
    private boolean seleccionado;
    private List<IObserver> observadores;

    /**
     * Constructor que inicializa un nuevo alumno con
     * sus datos académicos principales.
     * 
     * @param nombre Nombre completo del alumno
     * @param id Identificador único del alumno
     * @param programa Programa educativo
     * @param cicloEscolar Ciclo escolar actual
     * @param semestreInscrito Semestre que cursa actualmente
     */
    public Alumno(String nombre, int id, String programa, String cicloEscolar, int semestreInscrito) {
        this.nombre = nombre;
        this.id = id;
        this.programa = programa;
        this.cicloEscolar = cicloEscolar;
        this.semestreInscrito = semestreInscrito;
        this.materias = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.seleccionado = false;
    }

    //Getters y Setters
    public String getNombre() { 
        return nombre; 
    
    }
    public int getId() { 
        return id; 
    }
    
    public String getPrograma() { 
        return programa; 
    }
    
    public String getCicloEscolar() { 
        return cicloEscolar; 
    }
    
    public int getSemestreInscrito() { 
        return semestreInscrito; 
    }
    
    public List<Materia> getMaterias() { 
        return materias; 
    }
    
    public int getNumMaterias() { 
        return materias.size(); 
    }
    
    public boolean isSeleccionado() { 
        return seleccionado; 
    }

    /**
     * Método que marca al alumno como 
     * seleccionado y notifica a los observadores.
     */
    public void seleccionar() {
        this.seleccionado = true;
        notificarObservadores("ALUMNO_SELECCIONADO");
    }

    /**
     * Método que cancela la selección del alumno 
     * y notifica a los observadores.
     */
    public void cancelarSeleccion() {
        this.seleccionado = false;
        notificarObservadores("ALUMNO_CANCELADO");
    }
    
    /**
     * Método que restablece el estado de búsqueda 
     * y notifica a los observadores.
     */
    public void regresarBusqueda() {
        this.seleccionado = false;
        notificarObservadores("REGRESAR_A_BUSQUEDA");
    }

    /**
     * Método que genera una constancia académica 
     * con los datos actuales del alumno.
     * 
     * @return Texto de la constancia generada
     */
    public String generarConstancia() {
        StringBuilder constancia = new StringBuilder();
        constancia.append("CONSTANCIA ACADÉMICA\n\n")
                  .append("Por este medio se hace constar que el alumno ")
                  .append(nombre).append(", con ID ").append(id)
                  .append(", pertenece al programa educativo ")
                  .append(programa).append(", en el ciclo escolar ")
                  .append(cicloEscolar).append(", cursando actualmente el semestre ")
                  .append(semestreInscrito).append(".\n\n")
                  .append("Actualmente cursa ").append(getNumMaterias())
                  .append(" materias.\n\n")
                  .append("Atentamente,\nLa Coordinación Académica.");

        notificarObservadores("CONSTANCIA_GENERADA");
        return constancia.toString();
    }

    /**
     * Método que convierte la entidad actual
     * un objeto AlumnoDTO.
     * 
     * @return Objeto AlumnoDTO
     */
    public AlumnoDTO toDTO() {
        List<String> nombresMaterias = new ArrayList<>();
        for (Materia m : materias) nombresMaterias.add(m.getNombre());
        return new AlumnoDTO(nombre, id, programa, cicloEscolar, semestreInscrito, nombresMaterias);
    }

    /**
     * Método que crea una instancia de Alumno 
     * a partir de un AlumnoDTO.
     * 
     * @param dto Objeto DTO con los datos del alumno
     * @return Instancia de Alumno generada
     */
    public static Alumno fromDTO(AlumnoDTO dto) {
        return new Alumno(dto.getNombre(), dto.getId(), dto.getPrograma(),
                          dto.getCicloEscolar(), dto.getSemestreInscrito());
    }

    /**
     * Método que cusca alumnos por coincidencia en su ID.
     * 
     * @param alumnos Lista de alumnos registrados
     * @param textoId Texto del ID a buscar
     * @return Lista de alumnos coincidentes en formato DTO
     */
    public static List<AlumnoDTO> buscarAlumnoPorId(List<Alumno> alumnos, String textoId) {
        List<AlumnoDTO> resultado = new ArrayList<>();
        if (textoId == null || textoId.isBlank()) {
            for (Alumno a : alumnos) resultado.add(a.toDTO());
            return resultado;
        }
        for (Alumno a : alumnos) {
            if (String.valueOf(a.getId()).startsWith(textoId)) resultado.add(a.toDTO());
        }
        return resultado;
    }

    //Métodos Observer
    @Override
    public void agregarObserver(IObserver observador) { 
        observadores.add(observador); 
    }

    @Override
    public void quitarObserver(IObserver observador) { 
        observadores.remove(observador); 
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (IObserver o : observadores){
            o.notificar(mensaje, this);
        }
    }
    
}