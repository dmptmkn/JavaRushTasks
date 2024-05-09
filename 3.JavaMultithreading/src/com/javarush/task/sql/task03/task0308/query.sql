SELECT g.location, person.name, person.email, person.telephone
FROM gyms g, customers person
WHERE person.name = 'Hulk'