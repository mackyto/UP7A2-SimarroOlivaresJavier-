/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UD09E2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Alumnos {
    
    @Id
    private String matricula;
    private String nombre;
    
    
    // Relacion con notas Lista de notas (mappedBy la FK de notas, cascade persiste las notas de cada alumno en em.persist(alumno) ya que se crean en alumno, orphanRemoval elimina las notas si se borra el alumno) 
    @OneToMany (mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Notas> calificaciones;

    // Constructor vacío
    public Alumnos() {
    }

    /**
     * Constructor de alumno. Las notas se añaden despues.
     * @param matricula String único que representa el alumno.
     * @param nombre  String nombre del alumno.
     */
    public Alumnos(String matricula, String nombre) throws Exception {
        
        if (this.isString(matricula))
            this.matricula = matricula;
        
        if (this.isString(nombre))
            this.nombre = nombre;
        
        calificaciones = new ArrayList<>();
    }

    //Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws Exception {
        if(this.isString(nombre))
            this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (this.isString(nombre))
            this.nombre = nombre;
    }

    public List<Notas> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Notas> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    /**
     * La lista de notas se crea con el constructor y evoluciona en aañadir nota
     * @param asignatura String con el nombre de la asignatura
     * @param nota double valor de notaa alcanzado en la asignatura
     */
    public void añadirNota(String asignatura, double nota) throws Exception {
        if (this.isString(nombre) || this.isDouble(nota))
            this.calificaciones.add(new Notas(asignatura, nota, this));
  
    }
    
    /**
     * Devuelve la media aritmetica de todas las notas del alumno
     * @return double con la media aritmetica de las notas
     */
    public double media () {
         
        double media = 0.00;
        
        if (this.calificaciones.size() > 0){
            for (Notas n: this.getCalificaciones())
                media += n.getNota();
                media /= this.getCalificaciones().size();
        }
        return media;
    }

    /**
     * Verifica que una cadena de texto no esta vacía o con solo espacios o nula
     * @param texto String texto a comprobar
     * @return booleana true si nla cadena es válida
     * @throws Exception mensaje especifico
     */
    public boolean isString (String texto) throws Exception {
        if (texto.isEmpty() && texto.isBlank() && texto == null)
            throw new Exception ("ERROR de entrada de datos. String nulo");
        
        return true;
        
    }
    
    /**
     * Verifica que el número double de la nota es positivo se permite pasar cero, hasta diez y 11 para MH
     * @param numero nota numero double a comprobar de 0 a 11 son válidos
     * @return booleana frue si el numero para nota es válido, positivo, y dentro de rango
     * @throws Exception Mensaje explicativo del error
     */
    public boolean isDouble (double numero) throws Exception {
        if (numero < 0 && numero > 11)
            throw new Exception ("ERROR de entrada de datos. double fuera de rango");
        
        return true;
        
    }
    
}
