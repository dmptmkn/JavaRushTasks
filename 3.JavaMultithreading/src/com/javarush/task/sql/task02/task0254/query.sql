SELECT name, MIN(price), MAX(price)
FROM cars
GROUP BY name
