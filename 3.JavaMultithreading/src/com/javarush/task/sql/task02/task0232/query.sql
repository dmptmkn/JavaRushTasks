SELECT is_full_time, COUNT(*)
FROM students
GROUP BY is_full_time