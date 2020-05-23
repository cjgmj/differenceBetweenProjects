-- Insert users
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (1, 'Mitchell', 'Hudson', 'mitchell.hudson11@example.com', '1981-02-07', 38);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (2, 'Melanie', 'Bell', 'melanie.bell51@example.com', '1979-09-08', 39);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (3, 'Diane', 'Ruiz', 'diane.ruiz24@example.com', '1984-07-06', 34);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (4, 'Kathy', 'Hudson', 'kathy.hudson28@example.com', '1973-02-04', 46);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (5, 'Veronica', 'Ryan', 'veronica.ryan77@example.com', '1978-02-05', 41);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (6, 'Paul', 'Beck', 'paul.beck48@example.com', '1971-04-03', 48);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (7, 'Robin', 'Gonzales', 'robin.gonzales84@example.com', '1972-05-01', 47);
INSERT INTO users (id, name, surname, email, birthdate, age) VALUES (8, 'Leslie', 'Lee', 'leslie.lee78@example.com', '1970-01-09', 49);

-- Insert rooms
INSERT INTO rooms (id, name, number, place) VALUES (1, 'Sala 1', '1A', 'Planta baja');
INSERT INTO rooms (id, name, number, place) VALUES (2, 'Sala 2', '1B', 'Planta baja');
INSERT INTO rooms (id, name, number, place) VALUES (3, 'Sala 3', '2A', 'Primera planta');
INSERT INTO rooms (id, name, number, place) VALUES (4, 'Sala 4', '2B', 'Primera planta');
INSERT INTO rooms (id, name, number, place) VALUES (5, 'Sala 5', '2C', 'Primera planta');
INSERT INTO rooms (id, name, number, place) VALUES (6, 'Sala 6', '2D', 'Primera planta');
INSERT INTO rooms (id, name, number, place) VALUES (7, 'Sala 7', '3A', 'Segunda planta');
INSERT INTO rooms (id, name, number, place) VALUES (8, 'Sala 8', '3B', 'Segunda planta');

-- Insert bookings
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (1, 1, 2, '2019-04-15 00:00:00', 'Reunión', true, '2019-04-12 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (2, 1, 4, '2019-04-04 00:00:00', 'Presentación', true, '2019-04-01 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (3, 3, 2, '2019-04-03 00:00:00', null, false, '2019-04-02 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (4, 7, 7, '2019-04-17 00:00:00', 'Entrevista', true, '2019-04-12 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (5, 5, 6, '2019-04-19 00:00:00', 'Formación', true, '2019-04-08 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (6, 3, 7, '2019-04-02 00:00:00', null, true, '2019-03-28 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (7, 3, 8, '2019-04-25 00:00:00', 'Píldora formativa', false, '2019-04-20 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (8, 3, 2, '2019-04-25 00:00:00', 'Píldora formativa', true, '2019-04-18 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (9, 5, 4, '2019-04-30 00:00:00', 'Reunión', true, '2019-04-25 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (10, 2, 7, '2019-04-21 00:00:00', null, false, '2019-04-20 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (11, 4, 6, '2019-04-05 00:00:00', 'Presentación', true, '2019-04-01 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (12, 5, 1, '2019-04-14 00:00:00', 'Reunión', false, '2019-04-10 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (13, 5, 7, '2019-04-14 00:00:00', 'Reunión', true, '2019-04-08 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (14, 2, 1, '2019-04-15 00:00:00', 'Píldora formativa', true, '2019-04-10 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (15, 4, 4, '2019-04-28 00:00:00', 'Entrevista', true, '2019-04-20 00:00:00');
INSERT INTO bookings (id, user, room, date, reason, accepted, booking) VALUES (16, 2, 7, '2019-04-07 00:00:00', 'Formación', true, '2019-04-05 00:00:00');