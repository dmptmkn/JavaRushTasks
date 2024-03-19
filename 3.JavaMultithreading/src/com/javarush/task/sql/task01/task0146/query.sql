SELECT *
FROM parts
WHERE description IS NULL
  AND required = true
