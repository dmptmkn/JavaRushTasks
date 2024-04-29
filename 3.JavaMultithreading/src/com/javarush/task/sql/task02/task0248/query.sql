SELECT department, position, COUNT(*) as total
FROM employee
GROUP BY department, position
HAVING total BETWEEN 2 AND 4
ORDER BY department