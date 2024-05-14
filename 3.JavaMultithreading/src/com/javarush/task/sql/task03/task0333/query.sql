SELECT auth.last_name AS author, book.genre AS genre, book.date_released AS book_genre
FROM authors AS auth
         RIGHT JOIN books AS book ON auth.author_id = book.author_id
WHERE book.date_released < 1900
GROUP BY auth.last_name, book.genre, book.date_released