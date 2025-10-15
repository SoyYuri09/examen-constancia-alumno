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
        
        Materia m1 = new Materia("Métodos Numéricos", 101);
        Materia m2 = new Materia("Programación III", 102);
        Materia m3 = new Materia("Análisis de Algoritmos", 103);
        Materia m4 = new Materia("Estructura de datos", 104);
        Materia m5 = new Materia("Redes", 105);
        Materia m6 = new Materia("Diseño de Software", 106);
        Materia m7 = new Materia("Arquitectura de Software", 107);
        Materia m8 = new Materia("Seguridad Informática", 108);
        Materia m9 = new Materia("Bases de datos avanzadas", 109);
        Materia m10 = new Materia("Sistemas empotrados", 110);
        Materia m11 = new Materia("Cultura de la legalidad", 111);
        Materia m12 = new Materia("Programación I", 112);
        Materia m13 = new Materia("Salud y Desarrollo Personal", 113);
        Materia m14 = new Materia("Introducción a la Ing. Software", 114);
        Materia m15 = new Materia("Cálculo", 115);
        Materia m16 = new Materia("Estadística Inferencial", 116);
        Materia m17 = new Materia("Álgebra Lineal", 117);
        Materia m18 = new Materia("Tutoría", 118);

        Alumno alumno1 = new Alumno("Mario Enrique López García", 252678, "Ing. Software", "Enero-Mayo", 1);
        alumno1.getMaterias().add(m12);
        alumno1.getMaterias().add(m15);
        alumno1.getMaterias().add(m14);
        alumno1.getMaterias().add(m18);
        alumno1.getMaterias().add(m13);

        Alumno alumno2 = new Alumno("Leonardo Leyva Flores", 252479, "Ing. Software", "Enero-Mayo", 4);
        alumno2.getMaterias().add(m3);
        alumno2.getMaterias().add(m8);
        alumno2.getMaterias().add(m9);
        alumno2.getMaterias().add(m16);
        alumno2.getMaterias().add(m11);
        alumno2.getMaterias().add(m10);

        Alumno alumno3 = new Alumno("José Ernesto Miramontes Hernández", 242587, "Diseño Gráfico", "Enero-Mayo", 5);
        alumno3.getMaterias().add(m10);
        alumno3.getMaterias().add(m17);
        alumno3.getMaterias().add(m10);
        alumno3.getMaterias().add(m18);
        alumno3.getMaterias().add(m1);
        alumno3.getMaterias().add(m16);
        alumno3.getMaterias().add(m3);
        alumno3.getMaterias().add(m2);
        
        Alumno alumno4 = new Alumno("Luis Fernando Aguilar López", 252587, "Ing. Civil", "Enero-Mayo", 2);
        alumno4.getMaterias().add(m4);
        alumno4.getMaterias().add(m2);
        alumno4.getMaterias().add(m5);
        alumno4.getMaterias().add(m13);
        
        Alumno alumno5 = new Alumno("Ramón Valencia Hernández", 252778, "Ing. Software", "Enero-Mayo", 5);
        alumno5.getMaterias().add(m10);
        alumno5.getMaterias().add(m17);
        alumno5.getMaterias().add(m10);
        alumno5.getMaterias().add(m18);
        alumno5.getMaterias().add(m6);
        alumno5.getMaterias().add(m16);
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