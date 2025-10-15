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
    
    private String nombre;
    private int id;
    private String programa;
    private String cicloEscolar;
    private int semestreInscrito;
    private List<Materia> materias;
    
    private List<IObserver> observadores;

    public Alumno(String nombre, int id, String programa, String cicloEscolar, int semestreInscrito) {
        this.nombre = nombre;
        this.id = id;
        this.programa = programa;
        this.cicloEscolar = cicloEscolar;
        this.semestreInscrito = semestreInscrito;
        this.materias = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

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
    
    public int getNumMaterias(){
        return materias.size();
    }

    public AlumnoDTO toDTO() {
        List<String> nombresMaterias = new ArrayList<>();
        for (Materia m : materias) {
            nombresMaterias.add(m.getNombre());
        }
        return new AlumnoDTO(nombre, id, programa, cicloEscolar, semestreInscrito, nombresMaterias);
    }

    public static Alumno fromDTO(AlumnoDTO dto) {
        Alumno alumno = new Alumno(dto.getNombre(), dto.getId(), dto.getPrograma(),
                dto.getCicloEscolar(), dto.getSemestreInscrito());
        return alumno;
    }
    
    public static List<AlumnoDTO> buscarAlumnoPorId(List<Alumno> alumnos, String textoId) {
    List<AlumnoDTO> resultado = new ArrayList<>();
    if (textoId == null || textoId.isBlank()) {
        for (Alumno a : alumnos) {
            resultado.add(a.toDTO());
        }
        return resultado;
    }

    for (Alumno a : alumnos) {
        if (String.valueOf(a.getId()).startsWith(textoId)) {
            resultado.add(a.toDTO());
        }
    }
    return resultado;
}

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
        for (IObserver o : observadores) {
            o.notificar(mensaje, this);
        }
    }
    
}