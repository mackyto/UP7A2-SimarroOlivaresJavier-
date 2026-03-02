/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  Crea un programa que gestione una cola de impresión. 
 *  Cada documento tendrá un nombre y un número de páginas. 
 *  El programa debe permitir añadir documentos a la cola, 
 *  imprimir (eliminar) el primer documento y mostrar todos los documentos en cola.
 * 
 * @author macky
 */
public class Ejercicio02 {
    
    private static Queue<Documento> cola;
    private static int tamañoCola;
    
    public static void main (String[] args){
        
        cola = new LinkedList<>();
        tamañoCola = 0;
        
        
        
        
    }
    
    public static void añadirDoc (String nombre, int numeroPaginas) {
        cola.add(new Documento(nombre,numeroPaginas));
        tamañoCola++;
    }
    
    public static Documento documentoImpreso () {
        tamañoCola--;        
        return cola.poll();  
    }
    
    public static int getTamañoCola ()  {
        return tamañoCola; 
    }
    
    
}
