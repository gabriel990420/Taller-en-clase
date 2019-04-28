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
public class Pelicula_Terror {

    private String nombre;

    public Pelicula_Terror() {
    }

    public Pelicula_Terror(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula_Terror{" + "nombre=" + nombre + '}';
    }

    public ResultSet Peliculas_terror(String sql) {
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
