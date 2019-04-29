use sakila;
DELIMITER // 
create procedure insertar_film(in title varchar(20), in descripcion varchar(20), in release_year year(4), in language_id TINYINT(3), in original_language_id TINYINT(3),
in rental_duration TINYINT(3), in rental_rate DECIMAL(4,2), in lengtht SMALLINT(5),in replacement_cost DECIMAL(5,2), in rating ENUM('G', 'PG', 'PG-13', 'R', 'NC-17'), in special_features SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes'),
in last_update TIMESTAMP) begin INSERT INTO sakila.film
(
`title`,
`description`,
`release_year`,
`language_id`,
`original_language_id`,
`rental_duration`,
`rental_rate`,
`length`,
`replacement_cost`,
`rating`,
`special_features`,
`last_update`) 
value(title,descripcion,release_year,language_id,original_language_id,rental_duration,rental_rate,lengtht,replacement_cost,rating,special_features,last_update);
END //
Delimiter ;

DELIMITER ¡¡
CREATE PROCEDURE ClientePelicula(in idscustomer_id SMALLINT(5))
BEGIN
select distinct film.title, concat(customer.first_name," ", customer.last_name) as "nombre" from (((film inner join inventory on film.film_id = inventory.film_id ) inner join rental on inventory.inventory_id= rental.inventory_id) inner join customer on rental.customer_id= customer.customer_id) where customer.customer_id= idscustomer_id;
END ¡¡
DELIMITER ;
drop procedure ClientePelicula;
call ClientePelicula(26);

DELIMITER ?
CREATE PROCEDURE PeliculaActor(in idactor_id SMALLINT(5))
BEGIN
 select film.title, concat(actor.first_name," ", actor.last_name) as "nombre actor" from ((film inner join film_actor on film.film_id = film_actor.film_id) inner join actor on film_actor.actor_id = actor.actor_id) where actor.actor_id = idactor_id ;
END ?
DELIMITER ;
drop procedure PeliculaActor;
call PeliculaActor(5);

DELIMITER \\
CREATE PROCEDURE PeliculasTerror()
begin
select film.title from((film inner join film_category on film.film_id= film_category.film_id) inner join category on film_category.category_id=category.category_id) where category.category_id=11;
end \\
DELIMITER ;
call PeliculasTerror;

DELIMITER &&
CREATE PROCEDURE rentas()
BEGIN
select concat(customer.first_name,' ',customer.last_name) as 'Nombre Cliente', rental.rental_id as 'id Renta'  from customer inner join rental on customer.customer_id = rental.customer_id where rental.rental_date between '2005-05-25 00:19:27' and '2005-05-25 06:44:53';
END &&
DELIMITER ;

call rentas;