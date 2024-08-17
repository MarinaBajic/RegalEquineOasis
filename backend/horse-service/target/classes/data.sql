-- Populate Breed table
INSERT INTO Breed (name, coat_color) VALUES
('Thoroughbred', 'Bay'),
('Arabian', 'Chestnut'),
('Quarter Horse', 'Sorrel'),
('Clydesdale', 'Brown'),
('Appaloosa', 'Leopard'),
('Morgan', 'Black');

-- Populate Horse table
INSERT INTO Horse (full_name, nickname, gender, date_of_birth, breed_id) VALUES
('Champion Stallion', 'Champ', 'M', '2015-04-20', 1),
('Desert Beauty', 'Beauty', 'F', '2018-09-15', 2),
('Lightning Bolt', 'Bolt', 'M', '2017-03-10', 3),
('Mountain King', 'King', 'M', '2016-02-25', 4),
('Spotted Wonder', 'Spot', 'F', '2019-07-12', 5),
('Midnight Star', 'Star', 'F', '2014-11-03', 6),
('River Breeze', 'Breeze', 'M', '2020-05-08', 1),
('Golden Glory', 'Glory', 'F', '2013-10-20', 2),
('Thunder Strike', 'Thunder', 'M', '2016-08-15', 3),
('Sunny Day', 'Sunny', 'F', '2017-12-01', 5);
