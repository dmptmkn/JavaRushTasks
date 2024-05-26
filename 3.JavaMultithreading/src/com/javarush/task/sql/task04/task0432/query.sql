SELECT MONTHNAME(event.date_time), COUNT(event.type)
FROM event
WHERE event.status = 'ERROR' OR event.status = 'FAILED'
GROUP BY MONTHNAME(event.date_time)