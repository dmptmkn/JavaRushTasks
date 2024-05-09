SELECT gym.location, person.location
FROM gyms gym, customers person
WHERE person.location != 'London'
GROUP BY gym.location, person.location