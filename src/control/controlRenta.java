/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import java.util.LinkedList;
import modelo.clienteRenta;

/**
 *
 * @author gabri
 */
public class controlRenta {
    
    public static ResultSet BuscarRentas(int id){
        boolean b=true;
        clienteRenta cr= new clienteRenta();
        
        String nombremovie,nombreCliente;
        String sql= "call ClientePelicula("+id+")";
        ResultSet rs= cr.buscarCliente(sql);
        if(b){
        if (rs==null) {
            cr=null;
            b=false;
        }else{
            try{
            rs.next();
            nombremovie=rs.getString("title");
            nombreCliente=rs.getString("nombre");
           
            
            
            cr=new clienteRenta(nombremovie, nombreCliente);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        }
        return rs;      
    }
}
