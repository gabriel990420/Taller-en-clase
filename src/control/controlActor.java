/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Actor;
import modelo.clienteRenta;

/**
 *
 * @author gabri
 */
public class controlActor {

    public static ResultSet Peliculas_actor(int id) {
        boolean b = true;
        Actor cr = new Actor();

        String nombremovie, nombreActor;
        String sql = "call PeliculaActor(" + id + ")";
        ResultSet rs = cr.buscarCliente(sql);
        if (b) {
            if (rs == null) {
                cr = null;
                b = false;
            } else {
                try {
                    rs.next();
                    nombremovie = rs.getString("title");
                    nombreActor = rs.getString("nombre actor");

                    cr = new Actor(nombremovie, nombreActor);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return rs;

    }

}
