SELECT prod_year, COUNT(*) as count
FROM cars
WHERE name = 'Blue Car'
GROUP BY prod_year
ORDER BY prod_year