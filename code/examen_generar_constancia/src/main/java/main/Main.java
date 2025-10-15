package main;

import controllers.ControlConstancia;
import dtos.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import models.Alumno;
import models.Materia;
import views.VistaConstancia;

/**
 *
 * @author Usuario
 */
public class Main {

    public static void main(String[] args) {
        
        Materia m1 = new Materia("Matemáticas", 101);
        Materia m2 = new Materia("Historia", 102);
        Materia m3 = new Materia("Programación", 103);

        Alumno alumno1 = new Alumno("Mario Enrique López García", 252678, "Ing. Software", "Enero-Mayo", 3);
        alumno1.getMaterias().add(m1);
        alumno1.getMaterias().add(m2);

        Alumno alumno2 = new Alumno("Leonardo Leyva Flores", 252479, "Ing. Software", "Enero-Mayo", 2);
        alumno2.getMaterias().add(m2);
        alumno2.getMaterias().add(m3);

        Alumno alumno3 = new Alumno("José Ernesto Miramontes Hernández", 242587, "Diseño Gráfico", "Enero-Mayo", 1);
        alumno3.getMaterias().add(m1);
        alumno3.getMaterias().add(m3);
        
        Alumno alumno4 = new Alumno("Luis Fernando Aguilar López", 252587, "Ing. Civil", "Enero-Mayo", 2);
        alumno4.getMaterias().add(m1);
        alumno4.getMaterias().add(m2);
        
        Alumno alumno5 = new Alumno("Ramón Valencia Hernández", 252778, "Ing. Software", "Enero-Mayo", 4);
        alumno5.getMaterias().add(m3);
        alumno5.getMaterias().add(m2);

        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);

        ControlConstancia controlador = new ControlConstancia(listaAlumnos);

        SwingUtilities.invokeLater(() -> {
            VistaConstancia vista = new VistaConstancia();

            for (Alumno a : listaAlumnos) {
                a.agregarObserver(vista);
            }

            vista.mostrarAlumnosEnTabla(controlador.cargarAlumnos());

            vista.iniciarBuscador(controlador);

            vista.iniciarSeleccionAlumno(controlador);
            
            vista.setVisible(true);
        });
    }
}
