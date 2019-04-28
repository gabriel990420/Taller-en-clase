/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Pelicula;

/**
 *
 * @author germanny.lezama
 */
public class controlpelicula {

    public static boolean insertarPeliculas(Pelicula peli) {
        boolean b;
        String title, descripcion, release_year, rating, special_features, last_update, rental_rate, replacement_cont, lenguaje_id, rental_duration, original_lenguaje_id, length;

        title = "'" + peli.getTitle() + "'";
        descripcion = "'" + peli.getDescripcion() + "'";
        release_year = peli.getRelease_year();
        rating = "'" + peli.getRating() + "'";
        special_features = "'" + peli.getSpecial_features() + "'";
        last_update = "'" + peli.getLast_update() + "'";
        rental_rate = Double.toString(peli.getRental_duration());
        replacement_cont = Double.toString(peli.getReplacement_cont());
        lenguaje_id = Integer.toString(peli.getLenguaje_id());
        rental_duration = Integer.toString(peli.getRental_duration());
        original_lenguaje_id = Integer.toString(peli.getOriginal_lenguaje_id());
        length = Integer.toString(peli.getLength());

        String sql = "call insertar_film(" + title + "," + descripcion + "," + release_year + "," + lenguaje_id + "," + original_lenguaje_id + "," + rental_duration + "," + rental_rate + "," + length + "," + replacement_cont + "," + rating + "," + special_features + "," + last_update + ")";

        b = peli.insertarPelicula(sql);
        return b;

    }

    public static boolean updatemovie(Pelicula peli) {
        boolean b;
        String title, descripcion, release_year, rating, special_features, last_update, 
                rental_rate, replacement_cont, lenguaje_id, rental_duration, original_lenguaje_id, length;
                String id= Integer.toString(peli.getFilm_id());
        title = "'" + peli.getTitle() + "'";
        descripcion = "'" + peli.getDescripcion() + "'";
        release_year = peli.getRelease_year();
        rating = "'" + peli.getRating() + "'";
        special_features = "'" + peli.getSpecial_features() + "'";
        last_update = "'" + peli.getLast_update() + "'";
        rental_rate = Double.toString(peli.getRental_duration());
        replacement_cont = Double.toString(peli.getReplacement_cont());
        lenguaje_id = Integer.toString(peli.getLenguaje_id());
        rental_duration = Integer.toString(peli.getRental_duration());
        original_lenguaje_id = Integer.toString(peli.getOriginal_lenguaje_id());
        length = Integer.toString(peli.getLength());

        String sql = "update film set " + "title = " + title + ", description = " + descripcion + ", release_year = " + release_year + ", language_id = "  + lenguaje_id
                + ", original_language_id = " + original_lenguaje_id + ", rental_duration = " + rental_duration + ", rental_rate = " + rental_rate + ", length = " + length
                + ", replacement_cost = " + replacement_cont + ", rating = " + rating + ", special_features = " + special_features + ", last_update = " + last_update
                +"where film_id = "+id;
        b = peli.updateMovie(sql);
        return b;
    }

    public static Pelicula obtener_pelicula(int idmovie) {
        Pelicula peli = new Pelicula();

        String title, descripcion, release_year, lenguaje_id, original_lenguaje_id, rental_duration, rental_rate, length, replacement_cont, rating, special_features, last_update;
        String sql = "select * from film where film_id= " + idmovie;
        ResultSet rs = peli.obtener_movie(sql);
        if (rs == null) {
            peli = null;

        } else {
            try{
                rs.next();
                title=rs.getString("title");
                descripcion=rs.getString("description");
                release_year=Integer.toString(rs.getInt("release_year"));
                lenguaje_id=Integer.toString(rs.getInt("language_id"));
                original_lenguaje_id=Integer.toString(rs.getInt("original_language_id"));
                rental_duration=Integer.toString(rs.getInt("rental_duration"));
                rental_rate= Double.toString(rs.getInt("rental_rate"));
                length=Integer.toString(rs.getInt("length"));
                replacement_cont=Double.toString(rs.getInt("replacement_cost"));
                rating=rs.getString("rating");
                special_features=rs.getString("special_features");
                last_update=rs.getString("last_update");
                if (descripcion==null) {
                    descripcion="default";
                }
                if (release_year.equals("null")) {
                    release_year="default";
                }
                if (original_lenguaje_id.equals("null") ){
                    original_lenguaje_id="default";
                }
                if (length.equals("null")) {
                    length="default";
                }
                if (rating.equals("null")) {
                    rating="default";
                }
                if (special_features.equals("null")) {
                    special_features="default";
                }
                peli= new Pelicula(title, descripcion, release_year, Integer.parseInt(lenguaje_id), Integer.parseInt(original_lenguaje_id), 
                        Integer.parseInt(rental_duration), Double.parseDouble(rental_rate),  Integer.parseInt(length), Double.parseDouble(replacement_cont), rating, special_features, last_update);
                
        }catch(Exception e){
                System.out.println(e);
        }
        }
        return peli;
    }

}
