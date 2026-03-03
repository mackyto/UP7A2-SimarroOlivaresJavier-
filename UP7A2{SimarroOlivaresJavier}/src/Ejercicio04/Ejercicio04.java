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
                    case '3': System.out.printf("Tiempo estimado de cola %1$tM:%1$tS\n\n", estimacionTiempo());break;
                    case '4': mostrarTodos(); break;
                    case 'x': break;
                    case 'X': break;
                    default : throw new Exception ("Opcion de menú incorrecta");
                }
                
            } while (!(opcion == 'x' || opcion == 'X'));
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
   
    } 
    

    public static char imprimirMenu(){
        
        char select;
        
        System.out.printf("Menu (%d Clientes añadidos)\n", cola.size());
        System.out.println("========================="); 
        System.out.println("1 Añadir Cliente."); 
        System.out.println("2 Borrar Cliente.");
        System.out.println("3 Mostrar tiempo estimado.");
        System.out.println("4 Mostrar todos."); 

        System.out.println("X Salir.");
        System.out.println();
        
        select = kl.nextLine().charAt(0);

    //    System.out.println(select);
        
        return select;
        
    }
    
    public static void añadirCliente () {
        int articulos = (int)(Math.random() * 50);
        cola.add(new Clientes(
            nombres[(int)(Math.random() * 25)],
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
    
    public static LocalTime estimacionTiempo (int articulos) {
        return LocalTime.ofSecondOfDay(articulos * tiempoArticulo);
    }
    
    public static void mostrarTodos () {
     
        Queue<Clientes> intercambio = new LinkedList<>();
        
        System.out.printf("%-15s\t   %8s\t%s\n\n","Nombre", "Artículos", "Tiempo Estimado");    
        int contadorArticulos = 0;
        
        for (Clientes cl: cola){
            System.out.printf("%-10s\t%3d artículos\t\t%3$tM:%3$tS\n",cl.getNombre(), cl.getNumeroArticulos() , estimacionTiempo(contadorArticulos));
            contadorArticulos += cl.getNumeroArticulos();
            intercambio.add(cl);
        }
        System.out.printf("\n\n");
        cola = intercambio;
    }
    
}
