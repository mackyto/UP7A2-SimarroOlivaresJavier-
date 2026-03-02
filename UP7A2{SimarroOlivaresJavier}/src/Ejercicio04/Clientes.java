/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

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
public class Clientes {
    
    private String nombre;
    private int numeroArticulos;

    public Clientes(String nombre, int numeroArticulos) {
        this.nombre = nombre;
        this.numeroArticulos = numeroArticulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroArticulos() {
        return numeroArticulos;
    }

    public void setNumeroArticulos(int numeroArticulos) {
        this.numeroArticulos = numeroArticulos;
    }
    
}
