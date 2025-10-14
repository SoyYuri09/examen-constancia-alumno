package models;
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
public class Alumno {
    
    private String nombre;
    private int id;
    private String programa;
    private String cicloEscolar;
    private int semestreInscrito;
    private List<Materia> materias;

    public Alumno(String nombre, int id, String programa, String cicloEscolar, int semestreInscrito) {
        this.nombre = nombre;
        this.id = id;
        this.programa = programa;
        this.cicloEscolar = cicloEscolar;
        this.semestreInscrito = semestreInscrito;
        this.materias = new ArrayList<>();
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
    
    public static List<Alumno> buscarAlumnoPorId(List<Alumno> alumnos, String idParcial) {
        List<Alumno> coincidencias = new ArrayList<>();

        for (Alumno a : alumnos) {
            if (String.valueOf(a.getId()).contains(idParcial)) {
                coincidencias.add(a);
            }
        }

        return coincidencias;
    }
    
}