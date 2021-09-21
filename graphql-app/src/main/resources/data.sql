INSERT INTO CLIENT (name, age) VALUES
('Jane', 26),
('Bob', 40);

INSERT INTO FLIGHT (number, origin, destination) VALUES
('LUX-CDG-123', 'LUX', 'CDG'),
('CDG-HTH-223', 'CDG', 'HTH');

INSERT INTO FLIGHT_BOOKING (flight_id, seat_number) VALUES
((SELECT id from FLIGHT where number = 'LUX-CDG-123'), '6A'),
((SELECT id from FLIGHT where number = 'CDG-HTH-223'), '2A');

INSERT INTO TRIP (name, client_id) VALUES
('Luxembourg to London', (SELECT id from CLIENT where name = 'Jane'));

INSERT INTO TRIP_FLIGHT_BOOKINGS (trip_id, flight_bookings_id) VALUES
((SELECT id from TRIP where name = 'Luxembourg to London'),
(SELECT id from FLIGHT_BOOKING where id = (SELECT id from FLIGHT where number = 'LUX-CDG-123')));

INSERT INTO TRIP_FLIGHT_BOOKINGS (trip_id, flight_bookings_id) VALUES
((SELECT id from TRIP where name = 'Luxembourg to London'),
(SELECT id from FLIGHT_BOOKING where id = (SELECT id from FLIGHT where number = 'CDG-HTH-223')));


