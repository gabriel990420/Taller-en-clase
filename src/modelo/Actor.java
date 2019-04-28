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
public class Actor {

    private int id;
    private String nombreActor, cnombremovie;

    public Actor() {
    }

    public Actor(String nombreActor, String cnombremovie) {
        this.nombreActor = nombreActor;
        this.cnombremovie = cnombremovie;
    }

    public Actor(int id, String nombreActor, String cnombremovie) {
        this.id = id;
        this.nombreActor = nombreActor;
        this.cnombremovie = cnombremovie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getCnombremovie() {
        return cnombremovie;
    }

    public void setCnombremovie(String cnombremovie) {
        this.cnombremovie = cnombremovie;
    }

    @Override
    public String toString() {
        return "Actor{" + "id=" + id + ", nombreActor=" + nombreActor + ", cnombremovie=" + cnombremovie + '}';
    }

    public ResultSet buscarCliente(String sql) {
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
