SELECT title
FROM films
         LEFT JOIN (SELECT film_directors.id, film_directors.last_name
                    FROM film_directors
                    WHERE film_directors.last_name = 'Spielberg') AS director
                   ON films.film_id = director.id
