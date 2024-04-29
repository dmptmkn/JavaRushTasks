SELECT name, COUNT(*) as car_count
FROM cars
GROUP BY name
HAVING car_count < 3