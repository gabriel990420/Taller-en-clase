/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author germanny.lezama
 */
public class Pelicula {

    public Pelicula() {
    }

   

    private int film_id, lenguaje_id, rental_duration, original_lenguaje_id, length;
    private double rental_rate, replacement_cont;
    private String title, descripcion, release_year, rating, special_features, last_update;

    public Pelicula(int film_id, int lenguaje_id, int rental_duration, int original_lenguaje_id, int length, double rental_rate, double replacement_cont, String title, String descripcion, String release_year, String rating, String special_features, String last_update) {
        this.film_id = film_id;
        this.lenguaje_id = lenguaje_id;
        this.rental_duration = rental_duration;
        this.original_lenguaje_id = original_lenguaje_id;
        this.length = length;
        this.rental_rate = rental_rate;
        this.replacement_cont = replacement_cont;
        this.title = title;
        this.descripcion = descripcion;
        this.release_year = release_year;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
    }

    public Pelicula( String title, String descripcion, String release_year, int lenguaje_id, int original_lenguaje_id, int rental_duration, double rental_rate, int length, double replacement_cont, String rating, String special_features, String last_update) {
        this.title = title;
        this.descripcion = descripcion;
        this.release_year = release_year;
        this.lenguaje_id = lenguaje_id;
        this.original_lenguaje_id = original_lenguaje_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.length = length;
        this.replacement_cont = replacement_cont;
        this.rating = rating;
        this.special_features = special_features;
        this.last_update = last_update;
    }

    public Pelicula(int film_id, int lenguaje_id, int rental_duration, double rental_rate, double replacement_cont, String title, String last_update) {
        this.film_id = film_id;
        this.lenguaje_id = lenguaje_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        this.replacement_cont = replacement_cont;
        this.title = title;
        this.last_update = last_update;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getLenguaje_id() {
        return lenguaje_id;
    }

    public void setLenguaje_id(int lenguaje_id) {
        this.lenguaje_id = lenguaje_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public int getOriginal_lenguaje_id() {
        return original_lenguaje_id;
    }

    public void setOriginal_lenguaje_id(int original_lenguaje_id) {
        this.original_lenguaje_id = original_lenguaje_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(double rental_rate) {
        this.rental_rate = rental_rate;
    }

    public double getReplacement_cont() {
        return replacement_cont;
    }

    public void setReplacement_cont(double replacement_cont) {
        this.replacement_cont = replacement_cont;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "film_id=" + film_id + ", lenguaje_id=" + lenguaje_id + ", rental_duration=" + rental_duration + ", original_lenguaje_id=" + original_lenguaje_id + ", length=" + length + ", rental_rate=" + rental_rate + ", replacement_cont=" + replacement_cont + ", title=" + title + ", descripcion=" + descripcion + ", release_year=" + release_year + ", rating=" + rating + ", special_features=" + special_features + ", last_update=" + last_update + '}';
    }

    public boolean insertarPelicula(String sql) {

        boolean d = false;
        ConnectBD objCB = new ConnectBD();

        try {
            if (objCB.crearConexion()) {
                Statement sentencia = objCB.getStatement();
                sentencia.executeUpdate(sql);
                d = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.toString());
        }

        return d;
    }

    public boolean updateMovie(String sql) {
               boolean d=false;
       try{
           ConnectBD connectdb= new ConnectBD();
           if(connectdb.crearConexion()){
            connectdb.getStatement().executeUpdate(sql);
           
               
           }
            d=true;
       }catch(Exception e){
           System.out.println("ERROR: "+e);
           
       }
        
        return d;
    }

    public ResultSet obtener_movie(String sql) {
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
