-- Populate Breed table
INSERT INTO Breed (name, coat_color) VALUES
('Thoroughbred', 'Bay'),
('Arabian', 'Chestnut'),
('Quarter Horse', 'Sorrel');

-- Populate Horse table
INSERT INTO Horse (full_name, nickname, gender, date_of_birth, breed_id) VALUES
('Champion Stallion', 'Champ', 'M', '2015-04-20', 1),
('Desert Beauty', 'Beauty', 'F', '2018-09-15', 2),
('Lightning Bolt', 'Bolt', 'M', '2017-03-10', 3);
