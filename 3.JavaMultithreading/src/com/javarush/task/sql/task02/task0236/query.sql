SELECT department, position, COUNT(*)
FROM employee
GROUP BY department, position
ORDER BY department
