SELECT author.last_name AS author, author.country AS author_country, book.genre AS book_genre
FROM authors AS author
         LEFT JOIN books AS book ON author.author_id = book.author_id
WHERE book.genre = 'fantasy'
GROUP BY author.last_name, author.country, book.genre
ORDER BY author_country ASC
LIMIT 5