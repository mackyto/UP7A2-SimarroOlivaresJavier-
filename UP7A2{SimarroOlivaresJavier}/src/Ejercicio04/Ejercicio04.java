/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * Desarrolla un programa que simule una cola de clientes en un supermercado. 
 * Cada cliente tendrá un nombre y un número de artículos. El programa debe 
 * permitir añadir clientes a la cola y atender (eliminar) al primer cliente.
 * Además, deberá ofrecer un tiempo estimado de espera, 
 * considerando un tiempo de 2 segundos por cada artículo de cada cliente
 * 
 * @author macky
 */
public class Ejercicio04 {
    
    private static Queue<Clientes> cola; 
    private static  int numeroTotalArticulos;
    private static  String[] nombres = {
        "Ana", "Carlos", "María", "Juan", "Laura", "Pedro", "Sofía", "Diego",
        "Valentina", "Miguel", "Camila", "José", "Fernanda", "Andrés", "Lucía",
        "Javier", "Daniela", "Alejandro", "Paula", "Sergio", "Andrea", "Ricardo",
        "Gabriela", "Fernando", "Isabella", "Javier"};
    private static final int tiempoArticulo = 2; // segundos por articulo
    private static Scanner kl;

    public static void main () {
        
        cola = new LinkedList<>();
        numeroTotalArticulos = 0;
        kl = new Scanner(System.in);
        char opcion; 
        
        try {
            do {
                opcion = imprimirMenu();
                switch (opcion){
                
                    case '1': añadirCliente(); break;
                    case '2': finalizarCliente(); break;
                    case '3': System.out.println(estimacionTiempo());break;
                    default : throw new Exception ("Opcion de menú icorrecta");
                }
            } while (opcion != 'x' || opcion != 'X');
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        
    } 
    

    public static char imprimirMenu(){
        
        char select;
        
        System.out.println("Menu");
        System.out.println("========================="); 
        System.out.println("1 Añadir Cliente."); 
        System.out.println("2 Borrar Cliente.");
        System.out.println("3 Mostrar tiempo estimado."); 

        System.out.println("X Salir.");
        System.out.println();
        
        select = kl.nextLine().charAt(0);

    //    System.out.println(select);
        
        return select;
        
    }
    
    public static void añadirCliente () {
        int articulos = (int)(Math.random() * 50);
        cola.add(new Clientes(
            nombres[(int)(Math.random() * 27)],
            articulos));
        
        numeroTotalArticulos += articulos; 
    }
    
    public static void añadirCliente (String nombre, int articulos) {
        cola.add(new Clientes(nombre, articulos));
        numeroTotalArticulos += articulos; 
    }
    
    public static Clientes finalizarCliente () {
        numeroTotalArticulos -= cola.peek().getNumeroArticulos();
        return cola.poll();
    }
    
    public static int tiempoEstimado () {
        return numeroTotalArticulos * tiempoArticulo;
    }
    
    public static LocalTime estimacionTiempo () {
        return LocalTime.ofSecondOfDay(numeroTotalArticulos * tiempoArticulo);
    }
    
}
