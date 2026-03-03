/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * Desarrolla un programa que simule una pila de libros. Cada libro tendrá un 
 * título y un autor. 
 * 
 * Implementa las operaciones básicas: 
 * 
 *      apilar un libro, 
 *      desapilar un libro y 
 *      mostrar el libro que está en la cima de la pila. 
 * 
 * También deberá poder mostrar si la pila está vacía. 
 * 
 * Utiliza una clase libro con los atributos título y autor. 
 * 
 * Controla los posibles errores y excepciones.
 * 
 * @author macky
 */
public class Ejercicio01 {
    
    private static Stack<Libro> pilaLibros;
    private static int tamañoPila;
    private static Scanner kl;

    public static void main (String[] args){
        
        pilaLibros = new Stack<>();
        kl = new Scanner(System.in);
        char opcion;
        
        try {
            
            do {
                opcion = imprimirMenu();
                switch (opcion){
                
                    case '1': añadirLibro(); pilaVacia(); break;
                    case '2': mostrarDetalles(); borraLibro(); pilaVacia(); break;
                    case '3': mostrarDetalles(); pilaVacia(); break;
                    case '4': pilaVacia(); break;
                    default : throw new Exception ("Opcion de menú icorrecta");
                }
            } while (opcion != 'x' || opcion != 'X');
                
                
                
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        
        
        
    }
    
    public static char imprimirMenu(){
        
        char select;
        
        System.out.println("Menu");
        System.out.println("========================="); 
        System.out.println("1 Añadir Libro."); 
        System.out.println("2 Borrar Libro.");  
        System.out.println("3 Mostrar Libro."); 
        System.out.println("4 Mostrar Estado de pila vacía."); 

        System.out.println("X Salir.");
        System.out.println();
        
        select = kl.nextLine().charAt(0);

    //    System.out.println(select);
        
        return select;
        
    }
    
    public static void añadirLibro () throws Exception{
        
        pilaLibros.push(new Libro(
            obtenerDatos("Introduzca el título del Libro"),
            obtenerDatos("Intruduzca el autor")));
        
    }
    
    public static Libro borraLibro (){
        return pilaLibros.pop();        
    }
    
    public static void mostrarDetalles () {
        System.out.printf("%-40s%s\n", "Titulo", "Autor");        
        System.out.printf("%-40s%s\n", pilaLibros.peek().getTitulo(), pilaLibros.peek().getAutor());
        
    }
    
    public static boolean pilaVacia (){
        if (pilaLibros.isEmpty()){
            System.out.println("La pila no tiene contenido, es una pila vacía.");
        } else {
            System.out.printf("La pila no esta vacia contiene %5d Libros\n\n", tamañoPila);
        }             
        return pilaLibros.isEmpty();
    }
    
    public static String obtenerDatos (String mensaje) {
        
        String texto;
        
        do {
        System.out.println(mensaje);
        texto = kl.nextLine();
        
        }while (texto.isEmpty() || texto.isBlank());
        
        return texto;
    }
    
    
    
}
