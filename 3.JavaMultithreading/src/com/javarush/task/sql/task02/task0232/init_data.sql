DROP TABLE IF EXISTS students;

CREATE TABLE students
(
    `id`           INT          not null auto_increment primary key,
    `name`         VARCHAR(100) not null,
    `age`          INT          not null,
    `is_full_time` VARCHAR(100) not null
);

insert into students (id, name, age, is_full_time)
values (11, 'Mary', 21, 'no'),
       (2, 'Peter', 24, 'yes'),
       (5, 'Amy', 22, 'no'),
       (7, 'John', 19, 'yes'),
       (6, 'Dexter', 40, 'yes'),
       (1, 'Maria', 26, 'yes'),
       (9, 'Alex', 21, 'yes');