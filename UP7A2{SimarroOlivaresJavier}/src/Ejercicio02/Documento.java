/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

/**
 *
 *  Crea un programa que gestione una cola de impresión. 
 *  Cada documento tendrá un nombre y un número de páginas. 
 *  El programa debe permitir añadir documentos a la cola, 
 *  imprimir (eliminar) el primer documento y mostrar todos los documentos en cola.
 * 
 * @author macky
 */
public class Documento {
    
    private String nombre;
    private int numeroPaginas;
    private static int docsTotal;

    public Documento() {
        this.nombre = "Documento" + String.format("%5d", docsTotal++);
        this.numeroPaginas = (int)(Math.random() * 250) + 1;
    }
    
    public Documento(String nombre, int numeroPaginas) {
        this.nombre = nombre;
        this.numeroPaginas = numeroPaginas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    
    
    
}
