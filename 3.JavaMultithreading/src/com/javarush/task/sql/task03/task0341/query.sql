SELECT *
FROM films
WHERE films.title LIKE (SELECT films.title WHERE films.title LIKE 'The%r' LIMIT 1)