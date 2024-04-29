SELECT department, position, COUNT(*) as total
FROM employee
GROUP BY department, position
HAVING position = 'backend developer' AND total = 1