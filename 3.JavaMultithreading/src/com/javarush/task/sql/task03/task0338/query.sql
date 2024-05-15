SELECT *
FROM authors
WHERE authors.full_name NOT LIKE CONCAT(authors.first_name, ' ', authors.last_name)
  AND authors.last_name != 'Shakespeare'