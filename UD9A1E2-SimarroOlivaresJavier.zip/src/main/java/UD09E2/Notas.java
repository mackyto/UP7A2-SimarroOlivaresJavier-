/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UD09E2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * 2. Desarrolla un sistema básico para almacenar notas de estudiantes usando ObjectDB. El sistema debe:
 * 
 *      • Registrar estudiantes con nombre y número de matrícula.
 * 
 *      • Agregar notas a los estudiantes. Considera las notas como una nueva clase.
 * 
 *      • Calcular y mostrar la media de cada estudiante.
 * 
 * Ayuda:
 * 
 *      1. Usa @OneToMany para la relación entre Estudiante y sus notas.
 * 
 *      2. Implementa un método para calcular la media.
 * 
 *      3. Utiliza una Id autogenerada para la clase que almacene las calificaciones
 *
 * @author macky
 */
@Entity
public class Notas {
    
    @Id
    @GeneratedValue
    private int id;
    private String asignatura;
    private double nota;

    @ManyToOne
    private Alumnos alumno;
    
    public Notas() {}

    /**
     * Constructor de nota
     * @param asignatura String con el nombre de la assignatura
     * @param nota double con la notaa alcanzada en la asignatura
     * @param alumno Objeto Alumnos a quie pertenece la nota
     */
    public Notas(String asignatura, double nota, Alumnos alumno) {
        this.asignatura = asignatura;
        this.nota = nota;
        this.alumno = alumno;
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    
}
