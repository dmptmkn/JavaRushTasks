SELECT *
FROM film_directors
WHERE film_directors.full_name LIKE (CONCAT(film_directors.first_name, ' ', film_directors.last_name))
LIMIT 1