SELECT *
FROM event
WHERE DATEDIFF(event.date_time, CURDATE()) < 30
  AND DATEDIFF(event.date_time, CURDATE()) > -30