CREATE TABLE superhero (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  universe VARCHAR(250) NOT NULL
   
);
INSERT INTO superhero (id, name, universe) VALUES (1, 'SPIDERMAN', 'MARVEL');
INSERT INTO superhero (id, name, universe) VALUES (2, 'BATMAN', 'DC');
INSERT INTO superhero (id, name, universe) VALUES (3, 'SUPERMAN', 'DC');
INSERT INTO superhero (id, name, universe) VALUES (4, 'DOCTOR STRANGE', 'MARVEL');
INSERT INTO superhero (id, name, universe) VALUES (5, 'GREEN LANTERN', 'DC');