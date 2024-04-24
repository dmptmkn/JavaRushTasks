SELECT YEAR(date_of_birth) as year_of_birth, COUNT(*)
FROM employee
WHERE position LIKE '%developer%'
GROUP BY YEAR(date_of_birth)
ORDER BY YEAR(date_of_birth)