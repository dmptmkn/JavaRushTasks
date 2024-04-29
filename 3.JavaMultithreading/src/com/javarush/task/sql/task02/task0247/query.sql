SELECT department, position, COUNT(*) as total
FROM employee
GROUP BY department, position
HAVING total = 1
ORDER BY department