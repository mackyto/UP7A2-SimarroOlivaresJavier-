/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package UD09E2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
public class UD9A1E2SimarroOlivaresJavierZip {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/Alumnos.odb");
        EntityManager em = emf.createEntityManager();
        
        try {
            
            em.getTransaction().begin();
            
            // Crear Alumnos
            Alumnos al1 = new Alumnos("11158787", "Javier Simarro Olivares");
            al1.añadirNota("Programacion", 8.45);
            al1.añadirNota("Lenguaje de Marcas", 8.69);
            al1.añadirNota("Bases de Datos", 10.00);
            al1.añadirNota("Ingles", 6.03);
            al1.añadirNota("IPE", 10.00);
            al1.añadirNota("Proyecto", 5.90);
            al1.añadirNota("Entornos de Deserrollo", 9.00);
            em.persist(al1);

            Alumnos al2 = new Alumnos("11155555", "Pedro Polo Navarro");
            al2.añadirNota("Programacion", 9.50);
            al2.añadirNota("Lenguaje de Marcas", 7.90);
            al2.añadirNota("Bases de Datos", 8.60);
            al2.añadirNota("Ingles", 9.80);
            al2.añadirNota("IPE", 10.00);
            al2.añadirNota("Proyecto", 7.30);
            al2.añadirNota("Entornos de Deserrollo", 8.00);
            em.persist(al2);
            
            Alumnos al3 = new Alumnos("11156666", "Francisco Sanchis Torres");
            al3.añadirNota("Programacion", 4.45);
            al3.añadirNota("Lenguaje de Marcas", 5.39);
            al3.añadirNota("Bases de Datos", 3.20);
            al3.añadirNota("Ingles", 4.50);
            al3.añadirNota("IPE", 5.10);
            al3.añadirNota("Proyecto", 5.00);
            al3.añadirNota("Entornos de Deserrollo", 6.30);
            em.persist(al3);
            
            Alumnos al4 = new Alumnos("11111111", "Juan Romero Cortes");
            em.persist(al4);
            
            em.getTransaction().commit();

            System.out.printf("Se han creado %d Alumnos\n\n", (Long) em.createQuery("SELECT COUNT(al) FROM Alumnos al").getSingleResult());            
            
            listarAlumnos (em);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            em.getTransaction().begin();
            int cantidad = em.createQuery("DELETE FROM Alumnos").executeUpdate();
            em.getTransaction().commit();
            System.out.printf("Se han borrada %d registros", cantidad);
            em.close();
        }
       
    }
    
    /**
     * Imprime la lista de todos los alumnos persistidos en la base de datos de objetos.
     * @param em El Entity Manager donde se han persistido los datos.
     */
    public static void listarAlumnos (EntityManager em) {
        
        TypedQuery<Alumnos> lista = em.createQuery("SELECT l FROM Alumnos l", Alumnos.class);
        List<Alumnos> alumnos = lista.getResultList();

        for (Alumnos al : alumnos) {
           imprimirAlumno(al);
        }
    }
    
    /**
     * Realiza la funcion de sacar por pantaalla los datos requeridos por alumno.
     * @param al Objeto Alumno cuyos datos se van a mostrar.
     */
    public static void imprimirAlumno (Alumnos al) {

        System.out.println("=======================================================================");        
        System.out.printf("%-10s%-40s%4.02f\n\n", al.getMatricula(), al.getNombre(), al.media());
        
    }
    
    
}
