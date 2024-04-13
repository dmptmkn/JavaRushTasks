SELECT CASE number_of_season
           WHEN 1 THEN 'winter'
           WHEN 2 THEN 'spring'
           WHEN 3 THEN 'autumn'
           WHEN 4 THEN 'summer'
           ELSE 'unknown'
           END
FROM months