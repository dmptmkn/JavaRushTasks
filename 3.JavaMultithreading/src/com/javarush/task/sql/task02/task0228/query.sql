SELECT department, COUNT(*) as number_of_employees
FROM employee
GROUP BY department