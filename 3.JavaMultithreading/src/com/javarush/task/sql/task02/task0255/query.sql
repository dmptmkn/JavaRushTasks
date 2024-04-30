SELECT name, MIN(price), MAX(price)
FROM cars
GROUP BY name
HAVING MAX(price) < 200000