SELECT name AS car_name, COUNT(*) as car_count
FROM cars
GROUP BY name