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
public class RentasPorFecha {
    private int id;
    private String nombre;

    public RentasPorFecha(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public RentasPorFecha() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "RentasPorFecha{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public ResultSet Rentas_Fecha(String sql) {
                ResultSet rs = null;

        try {
            ConnectBD objDB = new ConnectBD();

            if (objDB.crearConexion()) {
                rs = objDB.getStatement().executeQuery(sql);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return rs;
    }
    
}
