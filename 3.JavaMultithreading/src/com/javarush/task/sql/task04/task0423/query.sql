SELECT employee.name, employee.position
FROM employee
WHERE DAYNAME(employee.date_of_birth) = 'Monday'