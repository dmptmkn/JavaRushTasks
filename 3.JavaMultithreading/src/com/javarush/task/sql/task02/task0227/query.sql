SELECT prod_year, COUNT(*) as car_count
FROM cars
GROUP BY prod_year
ORDER BY prod_year