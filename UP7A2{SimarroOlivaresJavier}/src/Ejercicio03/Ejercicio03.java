/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * Implementa un programa que utilice una pila para comprobar si una palabra
 * o frase es un palíndromo (se lee igual de izquierda a derecha que de derechab
 * a izquierda), ignorando espacios y signos de puntuación. 
 * 
 * Convierte la cadena a minúsculas antes de empezar.
 * 
 * @author macky
 */
public class Ejercicio03 {
    
    private static Queue<Character> directo;
    private static Stack<Character> reverso;
    private static Scanner kl;
    
    public static void main () {
        
        directo = new LinkedList<>();
        reverso = new Stack<>();
        kl = new Scanner(System.in);
        
        
        System.out.println("Indica un palindromo");
        String palindromo = kl.nextLine();
        palindromo = palindromo.toLowerCase().replaceAll("[^a-z]", "");
        
        if (isPalindromo(palindromo))
            System.out.println("El texto es palindromo");
        else
            System.out.println("El texto no es palindromo");
        
        
    }
    
    public static boolean isPalindromo ( String palindromo){
        
        palindromo = palindromo.toLowerCase().replaceAll("[^a-z]", "");
        
        for (int i = 0; i < palindromo.length(); i++){
            directo.add(palindromo.charAt(i));
            reverso.push(palindromo.charAt(i));    
        }
        
        for (int i = 0; i < palindromo.length() / 2 + palindromo.length() % 2; i++){
            if (directo.poll() != reverso.pop())
                return false;
        }
        
        return true;
        
    }
   
    
    
}
