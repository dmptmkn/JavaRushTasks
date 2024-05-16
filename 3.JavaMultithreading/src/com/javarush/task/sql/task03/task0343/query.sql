SELECT film_directors.full_name
FROM film_directors
         LEFT JOIN (SELECT films.director_id FROM films WHERE genre = 'comedy') AS f
                   ON film_directors.id = f.director_id