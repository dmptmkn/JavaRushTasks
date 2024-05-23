SELECT YEAR(event.date_time),
       MONTH(event.date_time),
       DAY(event.date_time),
       COUNT(YEAR(event.date_time)),
       COUNT(MONTH(event.date_time)),
       COUNT(DAY(event.date_time))
FROM event
GROUP BY YEAR(event.date_time), MONTH(event.date_time), DAY(event.date_time)
HAVING COUNT(DAY(event.date_time)) > 5
