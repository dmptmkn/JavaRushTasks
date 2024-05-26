SELECT YEAR(event.date_time), MONTH(event.date_time), DAY(event.date_time), COUNT(event.type)
FROM event
WHERE event.user_id = 3
  AND event.type = 'SOLVE_TASK'
  AND event.status = 'OK'
GROUP BY YEAR(event.date_time), MONTH(event.date_time), DAY(event.date_time)