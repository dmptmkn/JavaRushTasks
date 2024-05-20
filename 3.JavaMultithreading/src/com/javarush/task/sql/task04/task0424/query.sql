SELECT employee.name, employee.position
FROM employee
WHERE DAYOFYEAR(employee.date_of_birth) < 201