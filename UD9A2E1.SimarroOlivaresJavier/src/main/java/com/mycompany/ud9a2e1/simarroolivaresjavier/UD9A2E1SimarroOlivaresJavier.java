/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ud9a2e1.simarroolivaresjavier;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Crea una aplicación simple para gestionar libros en una biblioteca. 
 * Implementa las operaciones CRUD básicas para la entidad Libro. 
 * 
 * La clase Libro debe tener:
 * 
 *      • ID (autogenerado)
 * 
 *      • Título
 * 
 *      • Autor
 * 
 *      • Año de publicación
 * 
 *      • ISBN
 * 
 * Se deben implementar métodos para:
 * 
 *      • Agregar un nuevo libro.
 * 
 *      • Buscar un libro por ID.• Listar todos los libros.
 * 
 *      • Actualizar información de un libro.
 * 
 *      • Eliminar un libro
 * 
 * @author macky
 */
public class UD9A2E1SimarroOlivaresJavier {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gamversLibros");
        EntityManager em = emf.createEntityManager();

// Ya puedes usar em.persist(), em.find(), etc.
        
        System.out.println("=======================================================================");
        
        try {
            
            // Creacion

            Libros l1 = new Libros("Cien años de soledad", "Gabriel García Márquez", "978-03-07474-72-8", LocalDate.parse("1967-05-29"));
            Libros l2 = new Libros("El resplandor", "Stephen King", "978-03-45806-78-9", LocalDate.parse("1977-01-28"));
            Libros l3 = new Libros("Dune", "Frank Herbert", "978-04-41172-71-9", LocalDate.parse("1965-08-01")); 
            
            em.getTransaction().begin();
            em.persist(l1);
            em.persist(l2);
            em.persist(l3);
            em.getTransaction().commit();
            
            System.out.printf("Se han creado %d Libros\n\n", (Long) em.createQuery("SELECT COUNT(l) FROM Libros l").getSingleResult());
            System.out.println("=======================================================================");
            listarLibros(em);
            System.out.println("=======================================================================");
            
            // Modificacion.
            em.getTransaction().begin();
            TypedQuery<Libros> cambio = em.createQuery("SELECT l FROM Libros l WHERE LOWER(l.titulo) = LOWER('cien años de soledad')", Libros.class);
            List<Libros> lista = cambio.getResultList();
            Libros l = lista.get(0);
            l.setFechaPublicacion(LocalDate.parse("1967-05-30"));
            em.getTransaction().commit();
            listarLibros(em);
            System.out.println("=======================================================================");
            
            // Busqueda.
            TypedQuery<Libros> busqueda = em.createQuery("SELECT l FROM Libros l WHERE LOWER(l.titulo) = LOWER('cien años de soledad')", Libros.class);
            imprimirLibro(busqueda.getSingleResult());
            System.out.println("=======================================================================");
            
            // Eliminacion 
            em.getTransaction().begin();
            TypedQuery<Libros> elimina = em.createQuery("SELECT l FROM Libros l WHERE LOWER(l.titulo) = LOWER('cien años de soledad')", Libros.class);
            lista = elimina.getResultList();
            l = lista.get(0);
            em.remove(l);
            em.getTransaction().commit();
            listarLibros(em);
            System.out.println("=======================================================================");
            
        } catch (Exception e) {
            
            System.out.println (e.getMessage());
            
        } finally {
            em.getTransaction().begin();
            int eliminados = em.createQuery("DELETE FROM Libros").executeUpdate();
            em.getTransaction().commit();
            System.out.printf( "Se han borrado %d Libros\n", eliminados);
            em.close();
        }
        
        
        
    }
     
    /**
     * Imprime la lista de todos los libros persistidos en la base de datos de objetos.
     * @param em El Entity Manager donde se han persistido los datos.
     */
    public static void listarLibros (EntityManager em) {
        
        TypedQuery<Libros> lista = em.createQuery("SELECT l FROM Libros l", Libros.class);
        List<Libros> libros = lista.getResultList();

        for (Libros l : libros) {
            imprimirLibro(l);
        }
    }
    
    /**
     * Realiza la funcion de sacar por pantalla los datos requeridos por libro.
     * @param l Objeto Libros cuyos datos se van a mostrar.
     */
    public static void imprimirLibro (Libros l) {
        
        System.out.printf("%10d\t%-40s\t%-40s\t%20s\n\n", l.getId(), l.getTitulo(), l.getAutor(), l.getFechaPublicacion());
        
    }
    
    
}
