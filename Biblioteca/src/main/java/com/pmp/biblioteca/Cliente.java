/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.biblioteca;

/**
 *
 * @author Andrea Medina
 */
public class Cliente {
    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Integer getDiasPrestado() {
        return diasPrestado;
    }

    public void setDiasPrestado(Integer diasPrestado) {
        this.diasPrestado = diasPrestado;
    }

    private String nombreCliente;
    private String telefonoCliente;
    private String codigoLibro;
    private String nombreLibro;
    private Integer diasPrestado;
    private Integer id;
}