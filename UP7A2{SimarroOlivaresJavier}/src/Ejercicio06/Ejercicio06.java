/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio06;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * Implementa un programa que gestione una cola de espera para las atracciones de PortAventura. 
 * Cada persona en la cola tendrá un nombre, edad y altura (en cm). 
 * 
 * El programa debe permitir:
 *
 *  • Añadir personas a la cola.
 *  • Permitir el acceso (eliminar) a la siguiente persona si cumple los requisitos de la atracción.
 *  • Mostrar toda la cola de espera. 
 *  • Mostrar el tiempo estimado de espera (3 minutos por persona en la cola). 
 *  • Verificar si una persona cumple los requisitos mínimos para la atracción 
 *    (por ejemplo, altura mínima de 120cm y edad mínima de 10 años)
 * 
 * @author macky
 */
public class Ejercicio06 {
    
    private static Queue<Asistente> pendientes;
    private static Scanner kl;
    
    
    public static void main (String[] args) {
        
        pendientes = new ArrayDeque<>();
        kl = new Scanner(System.in);
        char opcion; 
        
        
        try {
            do {
                opcion = imprimirMenu();
                switch (opcion){
                
                    case '1': añadirAsistente(); break;
                    case '2': subirAsistente(); break;
                    case '3': mostrarTodos(); break;
                    case 'x': break;
                    case 'X': break;
                    default : throw new Exception ("Opcion de menú icorrecta");
                }
                
            } while (!(opcion == 'x' || opcion == 'X'));
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
  
        
    }

    public static void añadirAsistente () {
        pendientes.add(new Asistente());
    }    
    
    public static void añadirAsistente (String nombre, int edad, double altura ) {
        pendientes.add(new Asistente(nombre, edad, altura));
    }
    
    public static Asistente subirAsistente () throws Exception {
        
        if (comprobarAltura(1.23))
            return pendientes.poll();
        
        throw new Exception ("La Altura del visitante es menor que la requerida");
        //return null;
        
    }
    
    public static void mostrarTodos () {
     
        Queue<Asistente> intercambio = new ArrayDeque<>();
        int tamañoOriginal = pendientes.size();
        
        for (Asistente a: pendientes){
            intercambio.add(pendientes.poll());
        }
        
        pendientes.clear();
            System.out.printf("%-10s\t%s\t%s\n\n","Nombre", "Edad", "Altura");        
        for (int i = 0; i < tamañoOriginal; i++) {
            Asistente asis = intercambio.poll();
            System.out.printf("%-10s\t%3d\t%.2fm\n",asis.getNombre(), asis.getEdad(), asis.getAltura());
            pendientes.add(asis);
        }
        System.out.printf("\n\n");
    }
    
    public static char imprimirMenu(){
        
        char select;
        
        System.out.printf("Menu (%d Visitantes añadidos)\n", pendientes.size());
        System.out.println("========================="); 
        System.out.println("1 Añadir Asistente."); 
        System.out.println("2 Montar Asistente.");
        System.out.println("3 Mostrar lista completa."); 

        System.out.println("X Salir.");
        System.out.printf("\n\n");
        
        select = kl.nextLine().charAt(0);

    //    System.out.println(select);
        
        return select;
        
    }
        
    public static boolean comprobarAltura (double requisitoAltura) {
        
        if (pendientes.peek().getAltura() >= requisitoAltura)
            return true;
        
        return false;
        
    }

}
