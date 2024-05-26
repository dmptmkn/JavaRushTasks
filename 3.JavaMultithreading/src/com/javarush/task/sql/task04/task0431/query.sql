SELECT DAYNAME(event.date_time), COUNT(event.type)
FROM event
WHERE event.type = 'REGISTRATION'
GROUP BY DAYNAME(event.date_time)