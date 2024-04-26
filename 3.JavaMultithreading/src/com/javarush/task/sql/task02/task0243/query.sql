SELECT YEAR(date_of_birth) as prod_year, MONTH(date_of_birth) as prod_month, COUNT(*)
FROM employee
GROUP BY prod_year, prod_month
ORDER BY prod_year