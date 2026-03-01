/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

/**
 *
 * Desarrolla un programa que simule una pila de libros. Cada libro tendrá un 
 * título y un autor. Implementa las operaciones básicas: apilar un libro, 
 * desapilar un libro y mostrar el libro que está en la cima de la pila. 
 * 
 * También deberá poder mostrar si la pila está vacía. 
 * 
 * Utiliza una clase libro con los atributos título y autor. 
 * 
 * Controla los posibles errores y excepciones.
 * 
 * @author macky
 */
public class Libro {
    
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) throws Exception {
        if (this.stringNoNulo(titulo))
            this.titulo = titulo;
        if (this.stringNoNulo(autor))
            this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (this.stringNoNulo(titulo))
            this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (this.stringNoNulo(autor))
            this.autor = autor;
    }
    
    public boolean stringNoNulo  (String texto) throws Exception {
        
        if (texto == null)
            throw new Exception ("Parámetro String nulo");
        
        if(texto.isEmpty())
            throw new Exception ("Parametro String vacío");
    
        if(texto.isBlank())
            throw new Exception ("Parametro String en blanco");
        
        return true;
        
    }
    
    
    
}
