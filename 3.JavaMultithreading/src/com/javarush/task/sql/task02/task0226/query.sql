SELECT name, COUNT(*) as count
FROM cars
WHERE prod_year = 2021
GROUP BY name