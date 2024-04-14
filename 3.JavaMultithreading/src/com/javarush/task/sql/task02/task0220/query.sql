SELECT DISTINCT name,
                CASE prod_year
                    WHEN 2020 THEN 'new'
                    WHEN 2021 THEN 'newer'
                    WHEN 2022 THEN 'even never'
                    END
FROM cars

