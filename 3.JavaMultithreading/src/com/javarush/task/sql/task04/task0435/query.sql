SELECT GROUP_CONCAT(CONCAT(employee.name, '-', employee.position))
FROM employee