SELECT department, COUNT(*) as employees
FROM employee
WHERE position = 'backend developer'
GROUP BY department