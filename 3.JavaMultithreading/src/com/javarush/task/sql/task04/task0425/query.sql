SELECT YEAR(employee.date_of_birth),
       MONTH(employee.date_of_birth),
       COUNT(YEAR(employee.date_of_birth)),
       COUNT(MONTH(employee.date_of_birth))
FROM employee
GROUP BY YEAR(employee.date_of_birth), MONTH(employee.date_of_birth)
ORDER BY YEAR(employee.date_of_birth)