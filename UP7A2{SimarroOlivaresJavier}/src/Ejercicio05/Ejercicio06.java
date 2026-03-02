/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio05;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * Crea un programa que utilice una pila para invertir el orden de los 
 * caracteres de una cadena de texto. 
 * 
 * El programa debe mostrar tanto la cadena original como la invertida.
 * 
 * @author macky
 */
public class Ejercicio06 {
    
    private static Stack<Character> reverso;
    private static Scanner kl;
    
    public static void main () {
        
        reverso = new Stack<>();
        kl = new Scanner(System.in);
        
        
        System.out.println("Escribe una frase");
        String frase = kl.nextLine();
        
        System.out.println(frase);

        System.out.println(String.format("%s", invertido(frase)));
        
        
    }
    
    public static String invertido (String frase) {
        
        String inverso = "";
        
        for (int i = 0; i < frase.length(); i++){
            reverso.push(frase.charAt(i));
        }
        
        for (int i = 0; i < frase.length(); i++){
            inverso = inverso.concat(String.format("%s", reverso.pop()));
        }
        System.out.println(inverso);
        
        return inverso;
        
    }
   
    
    
    
}
