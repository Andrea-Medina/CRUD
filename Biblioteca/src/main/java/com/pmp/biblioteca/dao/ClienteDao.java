/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.biblioteca.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.Exception;
import java.util.ArrayList;
import com.pmp.biblioteca.Cliente;

/**
 *
 * @author Andrea Medina
 */
public class ClienteDao {
    private Connection conn = null;
    public ClienteDao(){
        try {
        conn = Conexionbd.getConnection();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS CLIENTE ("
                +   "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +   "nombreCliente TEXT ,"
                +   "telefonoCliente TEXT ," 
                +   "codigoLibro TEXT ,"
                +   "diasPrestado INTEGER, "
                +   "nombreLibro TEXT "
                + ");";
        
        Statement comandoSQLCreate = conn.createStatement();
        comandoSQLCreate.executeUpdate(sqlCreateTable);
        comandoSQLCreate.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
    
    public void insertFrontdesk(Cliente newFrontdesk){
        try{
        String sqlInsert = "INSERT INTO CLIENTE (nombreCliente, " +
                "telefonoCliente, codigoLibro, diasPrestado, nombreLibro) values (" +
                "?, ?, ?, ?, ?)";
        PreparedStatement comandoInsert = conn.prepareStatement(sqlInsert);
        
        comandoInsert.setString(1, newFrontdesk.getNombreCliente());
        comandoInsert.setString(2, newFrontdesk.getTelefonoCliente());
        comandoInsert.setString(3, newFrontdesk.getCodigoLibro());
        comandoInsert.setString(4, newFrontdesk.getNombreLibro());
        comandoInsert.setInt(5, newFrontdesk.getDiasPrestado());
        
        int registroAgregados = comandoInsert.executeUpdate();
        System.out.println(registroAgregados);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void updateFrontdesk(Cliente updateFrontdesk) {
        try {
            String sqlStrUpdate = "UPDATE CLIENTE set nombreCliente = ?," +
                " telefonoCliente = ?," +
                " codigoLibro = ?," +
                " nombreLibro = ?," +
                " diasPrestado = ? where id = ?;";
            PreparedStatement comando = this.conn.prepareStatement(sqlStrUpdate);
            comando.setString(1, updateFrontdesk.getNombreCliente());
            comando.setString(2, updateFrontdesk.getTelefonoCliente());
            comando.setString(3, updateFrontdesk.getCodigoLibro());
            comando.setString(4, updateFrontdesk.getNombreLibro());
            comando.setInt(5, updateFrontdesk.getDiasPrestado());
            comando.setInt(6, updateFrontdesk.getId());
            comando.executeUpdate();
            comando.close();
            
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteCliente(Cliente deleteFrontdesk) {
        try {
            String sqlStrDelete = "DELETE FROM CLIENTE where id = ?;";
            PreparedStatement comando = this.conn.prepareStatement(sqlStrDelete);
            comando.setInt(1, deleteFrontdesk.getId());
            comando.executeUpdate();
            comando.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<Cliente> obtenerCliente() {
        try {
            String sqlstr = "SELECT * from CLIENTE;";
            Statement comando = conn.createStatement();
            ArrayList frontdesk = new ArrayList<Cliente>();
            ResultSet registros = comando.executeQuery(sqlstr);
            while (registros.next()){
                Cliente cliente = new Cliente();
                cliente.setId(registros.getInt("id"));
                cliente.setNombreCliente(registros.getString("nombreCliente"));
                cliente.setTelefonoCliente(registros.getString("telefonoCliente"));
                cliente.setCodigoLibro(registros.getString("codigoLibro"));
                cliente.setNombreLibro(registros.getString("nombreLibro"));
                cliente.setDiasPrestado(registros.getInt("diasPrestado"));
                frontdesk.add(cliente);
            }
            return frontdesk;
        } catch (Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<Cliente>();
        }
    }

    public void deleteFrontdesk(Cliente deleteCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
