/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 *  1.  Desarrolla un programa que simule una pila de libros. Cada libro tendrá 
 *      un título y un autor. Implementa las operaciones básicas: apilar un libro, 
 *      desapilar un libro y mostrar el libro que está en la cima de la pila. 
 * 
 *      También deberá poder mostrar si la pila está vacía. Utiliza una clase 
 *      libro con los atributos título y autor. Controla los posibles errores y 
 *      excepciones.
 * 
 * @author macky
 */
public class Libro {
    
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        if (this.stringNoNulo(titulo, "título")))
            this.titulo = titulo;
        
        this.autor = autor;
    }
    
    
    
    
    
    public boolean stringNoNulo (String texto, String mensaje) throws Exception{
        
        if (texto.isEmpty())
            throw new Exception (String.format("ERROR, El parámetro %s está vacío.", mensaje));
        
        if (texto == null)
            throw new Exception (String.format("ERROR, El parámetro %s es Nulo", mensaje));    
        
        return true;
        
    }
    
    
}
