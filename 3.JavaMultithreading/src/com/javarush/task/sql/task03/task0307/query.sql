SELECT gym.id, gym.name, cust.id
FROM gyms gym, customers cust
WHERE cust.id < 50