SELECT name, prod_year, price
FROM cars
GROUP BY name, prod_year, price
ORDER BY name