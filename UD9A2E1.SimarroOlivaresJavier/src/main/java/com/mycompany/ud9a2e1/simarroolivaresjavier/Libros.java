/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ud9a2e1.simarroolivaresjavier;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
 *      • Buscar un libro por ID.
 * 
 *      • Listar todos los libros.
 * 
 *      • Actualizar información de un libro.
 * 
 *      • Eliminar un libro
 * 
 * @author macky
 */
@Entity
@Table (name = "Libros")
public class Libros {

    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "fechaPublicacion")
    private LocalDate fechaPublicacion;

    /**
     * Constructor vacío
     */
    public Libros() {}

    /**
     * Contructor de libro
     * @param titulo String con el titulo del libro
     * @param autor String con el nombre del autor
     * @param fechaPublicacion LocajDate con la fecha de publicacion.
     */
    public Libros(String titulo, String autor, String isbn, LocalDate fechaPublicacion) throws Exception {
        
        if (this.isString(titulo))
            this.titulo = titulo;
        
        if (this.isString(autor))
            this.autor = autor;
        
        if (this.isIsbn(isbn))
            this.isbn = isbn;
        
        this.fechaPublicacion = fechaPublicacion;
        
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws Exception {
        if (this.isString(titulo))
            this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {
        if (this.isString(autor))
            this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws Exception {
        if (this.isIsbn(isbn))
            this.isbn = isbn;
    }
    
    

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
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
     * Metodo para verificar formato de isbn
     * @param isbn String isbn del objeto
     * @return Booleano true si el string es un isbn válido
     * @throws ErrorDeDatos Mensaje descriptivo de Error
     */
    public boolean isIsbn (String isbn) throws Exception{
        
        if (isbn.isEmpty()){
            throw new Exception("Campo isbn nulo");
        }
        
        if (!isbn.matches("^97[89]-[0-9]{2}-[0-9]{5}-[0-9]{2}-[0-9]$")){
            throw new Exception("Código isbn incorrecto");            
        }
            return true;        
    }
    
}
