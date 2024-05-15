SELECT *
FROM authors
WHERE authors.author_id NOT IN
      (SELECT books.author_id FROM books WHERE books.author_id IS NOT NULL AND books.genre = 'novel')