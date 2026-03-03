/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio06;

/**
 *
 * @author macky
 */
public class Asistente {
    
    private String nombre;;
    private int edad;
    private double altura;

    private String[] nombres = {
        "Ana", "Carlos", "María", "Juan", "Laura", "Pedro", "Sofía", "Diego",
        "Valentina", "Miguel", "Camila", "José", "Fernanda", "Andrés", "Lucía",
        "Javier", "Daniela", "Alejandro", "Paula", "Sergio", "Andrea", "Ricardo",
        "Gabriela", "Fernando", "Isabella", "Javier"};
    
    public Asistente() {
        
        this.nombre = nombres[(int)(Math.random() * 25 +1)];
        this.edad = this.crearEdad();
        this.altura = this.calcularAltura(this.edad);

    }

    public Asistente(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public int crearEdad () {
        return (int)(Math.random() * 35) + 5;
    }
    
    public double calcularAltura (int edad) {
    
        if (edad > 23)
            edad = 23;
        
        double altura = 100 + (edad * 3);
        double ruido = Math.random() * 17 - 8;
        return (altura + ruido) / 100;

    }
    
}
