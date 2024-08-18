-- Populate Coach table
INSERT INTO coach (name, surname, years_of_experience) VALUES
('John', 'Doe', 15),
('Jane', 'Smith', 10),
('Robert', 'Johnson', 8);

-- Populate Rider table
INSERT INTO rider (name, surname, address, date_of_birth, date_of_enrollment, coach_id) VALUES
('Emily', 'Brown', '123 Oak Street', '2000-04-15', '2021-05-01', 1),
('Michael', 'Davis', '456 Pine Avenue', '1995-08-22', '2020-09-15', 2),
('Sarah', 'Wilson', '789 Maple Drive', '2002-11-30', '2022-02-10', 3);

-- Populate SessionType table
INSERT INTO session_type (type, price, duration, description) VALUES
('JUMPING', 25.00, 45, 'Focuses on improving your horse\'s ability to jump over obstacles with precision and confidence. Ideal for enhancing jumping techniques and form.'),
('DRESSAGE', 30.00, 60, 'Emphasizes the art of training horses to perform precise movements and routines. Perfect for developing control and elegance in riding.'),
('CROSS-COUNTRY', 40.00, 75, 'Involves navigating varied terrain and natural obstacles. Great for building endurance and adaptability in both horse and rider.');


-- Populate Session table
INSERT INTO session (rider_id, horse_id, date, time, description, session_type_id) VALUES
(1, 1, '2024-07-06', '10:00', 'Morning training', 3),
(2, 2, '2024-07-06', '15:00', 'Afternoon ride', 1),
(3, 3, '2024-07-06', '09:30', 'Early session', 2),
(1, 4, '2024-07-07', '12:00', 'Midday session', 1),
(2, 5, '2024-07-07', '08:00', 'Morning run', 3),
(3, 6, '2024-07-07', '13:00', 'Post-lunch session', 2),
(1, 7, '2024-07-08', '10:30', 'Morning training', 1),
(2, 8, '2024-07-08', '11:00', 'Intermediate ride', 2),
(3, 9, '2024-07-08', '14:00', 'Advanced session', 3),
(1, 10, '2024-07-09', '09:00', 'Morning warm-up', 1),
(2, 1, '2024-07-09', '16:00', 'Late afternoon session', 3),
(3, 2, '2024-07-09', '07:30', 'Early bird session', 2),
(1, 3, '2024-07-10', '13:30', 'Midday ride', 2),
(2, 4, '2024-07-10', '10:00', 'Morning routine', 1),
(3, 5, '2024-07-10', '15:30', 'Advanced training', 3);

-- Populate Favorite table
INSERT INTO favorite (rider_id, horse_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1),
(3, 2);
