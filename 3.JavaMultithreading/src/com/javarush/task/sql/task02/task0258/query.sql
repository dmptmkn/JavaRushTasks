SELECT position, GROUP_CONCAT(name)
FROM employee
GROUP BY position