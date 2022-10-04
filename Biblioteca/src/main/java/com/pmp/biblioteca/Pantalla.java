/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.biblioteca;

import java.util.Scanner;
/**
 *
 * @author Andrea Medina
 */
public class Pantalla {
    public static void separator(){
        System.out.println("///////////////////////////////////////");
    }
    
    public static void header(String title){
        separator();
        System.out.println(title);
        separator();
    }
    
    public static void generateMenu(){
        header("MENU");
        System.out.println("( M ) \t Mostrar Todos.");
        System.out.println("( N ) \t Nuevo.");
        System.out.println("( A ) \t Actualizar.");
        System.out.println("( E ) \t Eliminar.");
        System.out.println("( V ) \t Detalle.");
        separator();
        System.out.println("( S ) \t Salir.");
        separator();
        System.out.println("Opcion y ENTER para continuar: ");
    }
    
    public static String getFieldInput(Scanner input, String label, String defaultValue){
        System.out.println(label + "(" + defaultValue + "): \t");
        String inputValue = input.nextLine();
        if (inputValue.isBlank()){
            return defaultValue;
        }
        return inputValue.strip();
    }
}
