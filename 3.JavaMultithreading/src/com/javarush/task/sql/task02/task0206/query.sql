SELECT *, IF(salary <= 500, 1000, 0) AS bonus
FROM employee
WHERE id > 5
LIMIT 10