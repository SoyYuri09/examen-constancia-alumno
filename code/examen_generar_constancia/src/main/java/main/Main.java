package main;

import controllers.ControlConstancia;
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
        alumno3.getMaterias().add(m7);
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
        
        Alumno alumno6 = new Alumno("Ana María Juárez Molina", 253001, "Ing. Software", "Agosto-Diciembre", 3);
        alumno6.getMaterias().add(m11);
        alumno6.getMaterias().add(m15);
        alumno6.getMaterias().add(m17);
        alumno6.getMaterias().add(m18);

        Alumno alumno7 = new Alumno("Carlos Alberto Martínez Ibarra", 253019, "Ing. Mecatrónica", "Enero-Mayo", 6);
        alumno7.getMaterias().add(m1);
        alumno7.getMaterias().add(m10);
        alumno7.getMaterias().add(m7);
        alumno7.getMaterias().add(m5);
        alumno7.getMaterias().add(m16);

        Alumno alumno8 = new Alumno("María Fernanda Díaz Rojas", 253055, "Psicología", "Agosto-Diciembre", 7);
        alumno8.getMaterias().add(m13);
        alumno8.getMaterias().add(m11);
        alumno8.getMaterias().add(m18);
        alumno8.getMaterias().add(m15);

        Alumno alumno9 = new Alumno("David Alejandro López Pérez", 253090, "Ing. Electrónica", "Enero-Mayo", 8);
        alumno9.getMaterias().add(m5);
        alumno9.getMaterias().add(m1);
        alumno9.getMaterias().add(m10);
        alumno9.getMaterias().add(m16);
        alumno9.getMaterias().add(m8);

        Alumno alumno10 = new Alumno("Manuel Ernesto Flores García", 253102, "Ing. Electrónica", "Agosto-Diciembre", 2);
        alumno10.getMaterias().add(m17);
        alumno10.getMaterias().add(m15);
        alumno10.getMaterias().add(m11);
        alumno10.getMaterias().add(m13);
        
        Alumno alumno11 = new Alumno("Jorge Luis Herrera Sandoval", 253120, "Ing. Industrial", "Enero-Mayo", 4);
        alumno11.getMaterias().add(m1);
        alumno11.getMaterias().add(m5);
        alumno11.getMaterias().add(m15);
        alumno11.getMaterias().add(m16);

        Alumno alumno12 = new Alumno("María Jesús García López", 253140, "Ing. Civil", "Agosto-Diciembre", 7);
        alumno12.getMaterias().add(m11);
        alumno12.getMaterias().add(m13);
        alumno12.getMaterias().add(m18);

        Alumno alumno13 = new Alumno("Francisco Javier Salazar Ruiz", 253150, "Ing. Mecatrónica", "Enero-Mayo", 5);
        alumno13.getMaterias().add(m5);
        alumno13.getMaterias().add(m10);
        alumno13.getMaterias().add(m7);
        alumno13.getMaterias().add(m1);

        Alumno alumno14 = new Alumno("Alejandra Gómez Padilla", 253165, "Ing. Mecatrónica", "Agosto-Diciembre", 3);
        alumno14.getMaterias().add(m15);
        alumno14.getMaterias().add(m16);
        alumno14.getMaterias().add(m13);

        Alumno alumno15 = new Alumno("Roberto Pineda Vargas", 253180, "Ing. Software", "Enero-Mayo", 6);
        alumno15.getMaterias().add(m6);
        alumno15.getMaterias().add(m9);
        alumno15.getMaterias().add(m8);
        alumno15.getMaterias().add(m10);
        alumno15.getMaterias().add(m3);

        Alumno alumno16 = new Alumno("Daniela López Rivas", 253195, "Arquitectura", "Agosto-Diciembre", 4);
        alumno16.getMaterias().add(m4);
        alumno16.getMaterias().add(m5);
        alumno16.getMaterias().add(m17);
        alumno16.getMaterias().add(m11);

        Alumno alumno17 = new Alumno("Miguel Ángel Castro Barrera", 253210, "Ing. Civil", "Enero-Mayo", 8);
        alumno17.getMaterias().add(m1);
        alumno17.getMaterias().add(m4);
        alumno17.getMaterias().add(m15);
        alumno17.getMaterias().add(m5);

        Alumno alumno18 = new Alumno("Claudia Pérez Ramos", 253225, "Arquitectura", "Agosto-Diciembre", 5);
        alumno18.getMaterias().add(m13);
        alumno18.getMaterias().add(m11);
        alumno18.getMaterias().add(m16);
        alumno18.getMaterias().add(m18);

        Alumno alumno19 = new Alumno("Iván Alejandro Morales Soto", 253240, "Ing. Software", "Enero-Mayo", 3);
        alumno19.getMaterias().add(m12);
        alumno19.getMaterias().add(m14);
        alumno19.getMaterias().add(m2);
        alumno19.getMaterias().add(m4);

        Alumno alumno20 = new Alumno("María Elizabeth López Torres", 253260, "Ing. Industrial", "Agosto-Diciembre", 6);
        alumno20.getMaterias().add(m1);
        alumno20.getMaterias().add(m5);
        alumno20.getMaterias().add(m13);
        alumno20.getMaterias().add(m15);
        alumno20.getMaterias().add(m17);
        
        Alumno alumno21 = new Alumno("Frida Sofía Morales Lázaro", 253275, "Ing. Software", "Enero-Mayo", 2);
    alumno21.getMaterias().add(m12);
    alumno21.getMaterias().add(m14);
    alumno21.getMaterias().add(m6);

    Alumno alumno22 = new Alumno("Jesús Ernesto Ibarra Lópz", 253290, "Ing.Civil", "Agosto-Diciembre", 5);
    alumno22.getMaterias().add(m4);
    alumno22.getMaterias().add(m5);
    alumno22.getMaterias().add(m15);
    alumno22.getMaterias().add(m17);

    Alumno alumno23 = new Alumno("Alexia Pérez Torres", 253305, "Arquitectura", "Enero-Mayo", 3);
    alumno23.getMaterias().add(m1);
    alumno23.getMaterias().add(m4);
    alumno23.getMaterias().add(m13);
    alumno23.getMaterias().add(m16);

    Alumno alumno24 = new Alumno("Daniel Roman Maldonado Tánori", 253320, "Ing. Electrónica", "Agosto-Diciembre", 6);
    alumno24.getMaterias().add(m11);
    alumno24.getMaterias().add(m13);
    alumno24.getMaterias().add(m18);
    alumno24.getMaterias().add(m15);

    Alumno alumno25 = new Alumno("Isabel Valenzuela Rocha", 253335, "Ing. Software", "Enero-Mayo", 4);
    alumno25.getMaterias().add(m15);
    alumno25.getMaterias().add(m16);
    alumno25.getMaterias().add(m13);
    alumno25.getMaterias().add(m12);

        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
        listaAlumnos.add(alumno6);
        listaAlumnos.add(alumno7);
        listaAlumnos.add(alumno8);
        listaAlumnos.add(alumno9);
        listaAlumnos.add(alumno10);
        listaAlumnos.add(alumno11);
        listaAlumnos.add(alumno12);
        listaAlumnos.add(alumno13);
        listaAlumnos.add(alumno14);
        listaAlumnos.add(alumno15);
        listaAlumnos.add(alumno16);
        listaAlumnos.add(alumno17);
        listaAlumnos.add(alumno18);
        listaAlumnos.add(alumno19);
        listaAlumnos.add(alumno20);
        listaAlumnos.add(alumno21);
        listaAlumnos.add(alumno22);
        listaAlumnos.add(alumno23);
        listaAlumnos.add(alumno24);
        listaAlumnos.add(alumno25);
        
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