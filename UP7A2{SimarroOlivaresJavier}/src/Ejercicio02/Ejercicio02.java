/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    private static Scanner kl;
    
    public static void main (String[] args){
        
        cola = new ArrayDeque<>();
        kl = new Scanner(System.in);
        char opcion; 
        
        
        try {
            do {
                opcion = imprimirMenu();
                switch (opcion){
                
                    case '1': break;
                    case '2': break;
                    case '3': break;
                    case 'x': break;
                    case 'X': break;
                    default : throw new Exception ("Opcion de menú incorrecta");
                }
                
            } while (!(opcion == 'x' || opcion == 'X'));
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }        
        
        
        
    }
    
        
    
    public static void añadirDoc () {
        cola.add(new Documento());
    }
    
    public static void añadirDoc (String nombre, int numeroPaginas) {
        cola.add(new Documento(nombre,numeroPaginas));
    }
    
    public static Documento documentoImpreso () {
        return cola.poll();  
    }
    
    public static int getTamañoCola ()  {
        return cola.size(); 
    }
    
    public static void mostrarTodos () {
     
        Queue<Documento> intercambio = new ArrayDeque<>();
        
        System.out.printf("%-10s\t%5s\t\t%s\n\n","Nombre", "Pagínas");    
        
        for (Documento doc: cola){
            System.out.printf("%-10s\t%3d años\n", doc.getNombre(), doc.getNumeroPaginas());
            intercambio.add(doc);
        }
        System.out.printf("\n\n");
        cola = intercambio;
    }
    
        public static char imprimirMenu(){
        
        char select;
        
        System.out.printf("Menu (%d Visitantes añadidos)\n", cola.size());
        System.out.println("========================="); 
        System.out.println("1 Añadir Asistente."); 
        System.out.println("2 Montar Asistente.");
        System.out.println("3 Mostrar lista completa."); 

        System.out.println("X Salir.");
        System.out.printf("\n\n");
        
        select = kl.nextLine().charAt(0);

        return select;
        
    }
    
    
}
