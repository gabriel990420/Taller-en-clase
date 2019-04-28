/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class clienteRenta {
    private int id;
    private String nombremovie, nombrecliente;

    public clienteRenta() {
    }

    public clienteRenta(String nombremovie, String nombrecliente) {
        this.nombremovie = nombremovie;
        this.nombrecliente = nombrecliente;
    }

    public clienteRenta(int id, String nombremovie, String nombrecliente) {
        this.id = id;
        this.nombremovie = nombremovie;
        this.nombrecliente = nombrecliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombremovie() {
        return nombremovie;
    }

    public void setNombremovie(String nombremovie) {
        this.nombremovie = nombremovie;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    @Override
    public String toString() {
        return "clienteRenta{" + "id=" + id + ", nombremovie=" + nombremovie + ", nombrecliente=" + nombrecliente + '}';
    }

    public ResultSet buscarCliente(String sql) {
                  ResultSet rs = null;
       
       try{
           ConnectBD objDB = new ConnectBD();
           
           if(objDB.crearConexion()){
               rs = objDB.getStatement().executeQuery(sql);
           }
           
       }catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
       
       return rs;
    }
    
    
}
