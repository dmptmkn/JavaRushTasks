DROP TABLE IF EXISTS event;

CREATE TABLE event
(
       `id`        INT         not null    auto_increment primary key ,
       `date_time` DATE        not null,
       `user_id`   INT         not null,
       `type`      VARCHAR(20) not null,
       `status`    VARCHAR(10) not null
);

insert into event (id, date_time, user_id, type, status)
values (1, DATE_ADD(CURRENT_DATE(), INTERVAL -1 DAY), 3, 'LOGIN', 'OK'),
       (2, DATE_ADD(CURRENT_DATE(), INTERVAL -20 DAY), 1, 'REGISTRATION', 'OK'),
       (3, DATE_ADD(CURRENT_DATE(), INTERVAL -50 DAY), 4, 'SOLVE_TASK', 'ERROR'),
       (4, DATE_ADD(CURRENT_DATE(), INTERVAL -8 DAY), 5, 'REGISTRATION', 'OK'),
       (5, DATE_ADD(CURRENT_DATE(), INTERVAL -13 DAY), 1, 'REGISTRATION', 'OK'),
       (6, DATE_ADD(CURRENT_DATE(), INTERVAL -23 DAY), 9, 'LOGIN', 'FAILED'),
       (7, DATE_ADD(CURRENT_DATE(), INTERVAL -32 DAY), 6, 'REGISTRATION', 'OK'),
       (8, DATE_ADD(CURRENT_DATE(), INTERVAL -8 DAY), 7, 'REGISTRATION', 'OK'),
       (9, DATE_ADD(CURRENT_DATE(), INTERVAL -37 DAY), 8, 'LOGIN', 'ERROR'),
       (10, DATE_ADD(CURRENT_DATE(), INTERVAL -19 DAY), 5, 'REGISTRATION', 'OK'),
       (11, DATE_ADD(CURRENT_DATE(), INTERVAL -23 DAY), 3, 'LOGIN', 'OK'),
       (12, DATE_ADD(CURRENT_DATE(), INTERVAL -11 DAY), 4, 'LOGIN', 'FAILED'),
       (13, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 1, 'SOLVE_TASK', 'OK'),
       (14, DATE_ADD(CURRENT_DATE(), INTERVAL -39 DAY), 3, 'LOGIN', 'OK'),
       (15, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 4, 'SOLVE_TASK', 'OK'),
       (16, DATE_ADD(CURRENT_DATE(), INTERVAL -9 DAY), 6, 'REGISTRATION', 'ERROR'),
       (17, DATE_ADD(CURRENT_DATE(), INTERVAL -1 DAY), 9, 'LOGIN', 'OK'),
       (18, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 1, 'LOGIN', 'FAILED'),
       (19, DATE_ADD(CURRENT_DATE(), INTERVAL -33 DAY), 7, 'SOLVE_TASK', 'OK'),
       (20, DATE_ADD(CURRENT_DATE(), INTERVAL -14 DAY), 5, 'LOGIN', 'OK'),
       (21, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 2, 'SOLVE_TASK', 'FAILED'),
       (22, DATE_ADD(CURRENT_DATE(), INTERVAL -22 DAY), 8, 'REGISTRATION', 'OK'),
       (23, DATE_ADD(CURRENT_DATE(), INTERVAL -27 DAY), 1, 'SOLVE_TASK', 'OK'),
       (24, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 9, 'LOGIN', 'ERROR'),
       (25, DATE_ADD(CURRENT_DATE(), INTERVAL -40 DAY), 3, 'SOLVE_TASK', 'OK'),
       (26, DATE_ADD(CURRENT_DATE(), INTERVAL -25 DAY), 4, 'LOGIN', 'FAILED'),
       (27, DATE_ADD(CURRENT_DATE(), INTERVAL -49 DAY), 6, 'SOLVE_TASK', 'OK'),
       (28, DATE_ADD(CURRENT_DATE(), INTERVAL -15 DAY), 5, 'REGISTRATION', 'OK'),
       (29, DATE_ADD(CURRENT_DATE(), INTERVAL -1 DAY), 8, 'LOGIN', 'ERROR'),
       (30, DATE_ADD(CURRENT_DATE(), INTERVAL -17 DAY), 8, 'LOGIN', 'OK'),
       (31, DATE_ADD(CURRENT_DATE(), INTERVAL -16 DAY), 2, 'LOGIN', 'OK'),
       (32, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 3, 'LOGIN', 'FAILED'),
       (33, DATE_ADD(CURRENT_DATE(), INTERVAL -2 DAY), 1, 'SOLVE_TASK', 'OK'),
       (34, DATE_ADD(CURRENT_DATE(), INTERVAL -1 DAY), 7, 'LOGIN', 'OK'),
       (35, DATE_ADD(CURRENT_DATE(), INTERVAL -24 DAY), 6, 'SOLVE_TASK', 'OK'),
       (36, DATE_ADD(CURRENT_DATE(), INTERVAL -33 DAY), 5, 'SOLVE_TASK', 'ERROR'),
       (37, DATE_ADD(CURRENT_DATE(), INTERVAL -18 DAY), 1, 'REGISTRATION', 'OK'),
       (38, DATE_ADD(CURRENT_DATE(), INTERVAL -29 DAY), 5, 'LOGIN', 'FAILED'),
       (39, DATE_ADD(CURRENT_DATE(), INTERVAL -2 DAY), 8, 'SOLVE_TASK', 'OK'),
       (40, DATE_ADD(CURRENT_DATE(), INTERVAL -5 DAY), 4, 'LOGIN', 'OK'),
       (41, DATE_ADD(CURRENT_DATE(), INTERVAL -12 DAY), 6, 'SOLVE_TASK', 'FAILED'),
       (42, DATE_ADD(CURRENT_DATE(), INTERVAL -22 DAY), 3, 'LOGIN', 'FAILED'),
       (43, DATE_ADD(CURRENT_DATE(), INTERVAL -0 DAY), 2, 'SOLVE_TASK', 'OK'),
       (44, DATE_ADD(CURRENT_DATE(), INTERVAL -11 DAY), 1, 'LOGIN', 'OK'),
       (45, DATE_ADD(CURRENT_DATE(), INTERVAL -13 DAY), 4, 'REGISTRATION', 'OK'),
       (46, DATE_ADD(CURRENT_DATE(), INTERVAL -37 DAY), 9, 'SOLVE_TASK', 'ERROR'),
       (47, DATE_ADD(CURRENT_DATE(), INTERVAL -19 DAY), 7, 'LOGIN', 'OK'),
       (48, DATE_ADD(CURRENT_DATE(), INTERVAL 0 DAY), 2, 'REGISTRATION', 'FAILED'),
       (49, DATE_ADD(CURRENT_DATE(), INTERVAL -9 DAY), 8, 'SOLVE_TASK', 'OK'),
       (50, DATE_ADD(CURRENT_DATE(), INTERVAL -11 DAY), 5, 'LOGIN', 'OK')
;