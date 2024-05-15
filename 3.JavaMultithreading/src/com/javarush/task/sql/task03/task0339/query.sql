SELECT *
FROM authors
WHERE authors.author_id IN (SELECT books.author_id FROM books WHERE books.genre = 'fantasy')