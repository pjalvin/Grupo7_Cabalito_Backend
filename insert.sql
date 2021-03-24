USE db_cabalito;

INSERT INTO city VALUES
(NULL,'La Paz',1,NOW(),1,'192.168.10.215',NOW()),
(NULL,'Cochabamba',1,NOW(),1,'192.168.10.215',NOW()),
(NULL,'Santa Cruz',1,NOW(),1,'192.168.10.215',NOW()),
(NULL,'Potosi',1,NOW(),1,'192.168.10.215',NOW()),
(NULL,'Oruro',1,NOW(),1,'192.168.10.215',NOW());

START TRANSACTION;
INSERT INTO brand VALUES
(null,'Toyota',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Mitsubishi',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Nissan',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Suzuki',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Chevrolet',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Renault',1,NOW(),1,'172.0.0.1',NOW());
COMMIT;

START TRANSACTION;
INSERT INTO color VALUES
(null,'Azul',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Rojo',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Verde',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Amarillo',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Negro',1,NOW(),1,'172.0.0.1',NOW()),

(null,'Blanco',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Gris',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Cafe',1,NOW(),1,'172.0.0.1',NOW()),
(null,'Naranja',1,NOW(),1,'172.0.0.1',NOW());
COMMIT;
