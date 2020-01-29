/*TABLA CIUDADES*/
--INSERT INTO ciudad (ciu_id, ciu_nom) VALUES (1,'Bogota');
--INSERT INTO ciudad (ciu_id, ciu_nom) VALUES (2,'Cali');
--INSERT INTO ciudad (ciu_id, ciu_nom) VALUES (3,'Medellin');
--INSERT INTO ciudad (ciu_id, ciu_nom) VALUES (4,'Boyaca');
/*TABLA HOTELES*/
INSERT INTO hotel (hot_nit, hot_nom, ciudad_ciu_id, hot_dir, hot_numh) 
VALUES (1,'Decameron', 1, 'Calle falsa 123', 5);
INSERT INTO hotel (hot_nit, hot_nom, ciudad_ciu_id, hot_dir, hot_numh) 
VALUES (2,'Hilton', 2, 'Calle falsa 123', 3);
INSERT INTO hotel (hot_nit, hot_nom, ciudad_ciu_id, hot_dir, hot_numh)
VALUES (3,'El buque', 3, 'Calle falsa 123', 8);
INSERT INTO hotel (hot_nit, hot_nom, ciudad_ciu_id, hot_dir, hot_numh)
VALUES (4,'Margaritas', 4, 'Calle falsa 123', 6);