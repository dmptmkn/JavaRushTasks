SELECT department AS department_name, COUNT(*) as count
FROM employee
WHERE position = 'frontend developer'
GROUP BY department