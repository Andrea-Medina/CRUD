/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.pmp.biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import com.pmp.biblioteca.dao.ClienteDao;

/**
 *
 * @author Andrea Medina
 */
public class Biblioteca {

    public static Scanner input;
    public static ArrayList<Cliente> arrCliente;
    public static ClienteDao posicionDao;
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        arrCliente = new ArrayList();
        
        posicionDao = new ClienteDao();
        
        Pantalla.header("CRUD - Alquiler De Libros De Una Biblioteca");
        String optionSelected = "";
        while(!optionSelected.equalsIgnoreCase("S")){
            Pantalla.generateMenu();
            optionSelected = input.nextLine();
            mainController(optionSelected);
        }
    }
    public static void mainController(String optionSelected){
        arrCliente = posicionDao.obtenerCliente();
        switch(optionSelected.toUpperCase()){
            case "M":
                mostrarCliente();
                break;
            case "N":
                newCliente();
                break;
            case "A":
                actualizarCliente();
                break;
            case "E":
                eliminarCliente();
                break;
            case "V":
                System.out.println("Opcion V Seleccionada");
                break;
            case "S":
                System.out.println("Opcion S Seleccionada");
                break;
            default:
                Pantalla.header("Opcion no Valida");
        }
    }
      
    private static Cliente inputForm (Cliente baseCliente){
        baseCliente.setNombreCliente(
                Pantalla.getFieldInput(input, "Nombre del Cliente", baseCliente.getNombreCliente())
        );
        baseCliente.setCodigoLibro(
                Pantalla.getFieldInput(input, "Codigo del Libro", baseCliente.getCodigoLibro())
        );
        baseCliente.setDiasPrestado(
                Integer.parseInt(Pantalla.getFieldInput(input, "Dias Prestado", baseCliente.getDiasPrestado().toString())
                )
        );
        baseCliente.setNombreLibro(
                Pantalla.getFieldInput(input, "Nombre del Libro", baseCliente.getNombreLibro())
        );
        return baseCliente;
    }
    
     private static Cliente validarEntradaRegistro() {
        if (arrCliente.isEmpty()) {
            System.out.println("No Hay Datos!");
            return null;
        }
        int index = Integer.parseInt(
            Pantalla.getFieldInput(input, "Número de Cliente: ", "1")
        );
        for (int i = 0; i < arrCliente.size(); i++){
            if (index == arrCliente.get(i).getId()) {
                return arrCliente.get(i);
            }
        }
        return null;
    }
   
    private static void newCliente(){
        Cliente newClienteIns = new Cliente();
        newClienteIns.setNombreCliente("Andrea Medina");
        newClienteIns.setCodigoLibro("EP505");
        newClienteIns.setDiasPrestado(15);
        newClienteIns.setTelefonoCliente("00000000");
        newClienteIns.setNombreLibro("American Gods");
        newClienteIns = inputForm(newClienteIns);
        posicionDao.insertFrontdesk(newClienteIns);
        arrCliente.add(newClienteIns);
    }

    private static void mostrarCliente() {
        arrCliente = posicionDao.obtenerCliente();
        if (arrCliente.size() > 0 ) {
            for ( int i = 0; i < arrCliente.size(); i++) {
                Cliente frontdesk = arrCliente.get(i);
                System.out.println(
                        String.valueOf(i+1) + " : " +
                        frontdesk.getNombreCliente() + " " +
                        frontdesk.getNombreLibro() + " " +
                        frontdesk.getCodigoLibro()+
                        " " +
                        frontdesk.getDiasPrestado().toString() + " dias"
                );
            }
        } else {
            System.out.println("No hay datos que mostrar.");
        }
    }
    
    private static void actualizarCliente() {
        Cliente updateCliente = validarEntradaRegistro();
        if(updateCliente != null){
            updateCliente = inputForm(updateCliente);
            posicionDao.updateFrontdesk(updateCliente);
            System.out.println("Registro Modificado");
        }
    }
    
    private static void eliminarCliente(){
        Cliente deleteCliente = validarEntradaRegistro();
        if (deleteCliente != null) {
            posicionDao.deleteFrontdesk(deleteCliente);
            System.out.println("Registro Modificado");
        }
    }
}
