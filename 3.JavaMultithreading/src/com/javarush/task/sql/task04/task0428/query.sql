SELECT *
FROM event
WHERE MONTH(event.date_time) = MONTH(CURDATE())