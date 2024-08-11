-- Populate Coach table
INSERT INTO Coach (name, surname, years_of_experience) VALUES
('John', 'Doe', 15),
('Jane', 'Smith', 10),
('Robert', 'Johnson', 8);

-- Populate Rider table
INSERT INTO Rider (name, surname, address, date_of_birth, date_of_enrollment, coach_id) VALUES
('Emily', 'Brown', '123 Oak Street', '2000-04-15', '2021-05-01', 1),
('Michael', 'Davis', '456 Pine Avenue', '1995-08-22', '2020-09-15', 2),
('Sarah', 'Wilson', '789 Maple Drive', '2002-11-30', '2022-02-10', 3);

-- Populate Session table
INSERT INTO Session (rider_id, horse_id, date, time, description) VALUES
(1, 1, '2024-08-01', '10:00', 'Morning training'),
(2, 2, '2024-08-03', '15:00', 'Afternoon ride'),
(3, 3, '2024-08-05', '09:30', 'Early session');

-- Populate Favorite table
INSERT INTO Favorite (rider_id, id_horse) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(3, 2);
