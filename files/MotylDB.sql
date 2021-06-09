DROP DATABASE IF EXISTS motyl_db;

#Creación de la base de datos
CREATE DATABASE motyl_db;
USE motyl_db;

#Creación de tablas
DROP TABLE IF EXISTS plantahospedera;
CREATE TABLE plantahospedera(
    id_planta INT NOT NULL AUTO_INCREMENT,
    nombre_planta VARCHAR(30) NOT NULL,
    necesidad_luz VARCHAR(11) NOT NULL,
    imagen_planta VARCHAR(50) NOT NULL,

    PRIMARY KEY (id_planta)
)ENGINE=InnoDB;
/*ALTER TABLE plantahospedera ADD CONSTRAINT PKid_planta PRIMARY KEY (id_planta) AUTO_INCREMENT;*/

INSERT INTO plantahospedera(nombre_planta, necesidad_luz, imagen_planta) 
VALUES ('alkushi', 'sombra', 'alkushi.jpg'); 
INSERT INTO plantahospedera(nombre_planta, necesidad_luz, imagen_planta) 
VALUES ('venenillo', 'semi-sombra', 'venenillo.jpg'); 
INSERT INTO plantahospedera(nombre_planta, necesidad_luz, imagen_planta) 
VALUES ('maracuyá', 'luz directa', 'maracuya.jpg'); 
INSERT INTO plantahospedera(nombre_planta, necesidad_luz, imagen_planta) 
VALUES ('mastuerzo', 'semi-sombra', 'mastuerzo.jpg'); 


DROP TABLE IF EXISTS especie;
CREATE TABLE especie(
    id_especie INT NOT NULL AUTO_INCREMENT,
    nombre_cientifico VARCHAR(50) NOT NULL, #CHECAR NUMERO
    nombre_comun VARCHAR(50) NOT NULL,
    color_especie VARCHAR(20) NOT NULL,
    tamano_especie VARCHAR(7) NOT NULL,
    tipo_alimentacion BOOL NOT NULL,
    id_planta INT NOT NULL,
    imagen_especie VARCHAR(50) NOT NULL,

    PRIMARY KEY (id_especie),
    FOREIGN KEY (id_planta) REFERENCES plantahospedera(id_planta)
)ENGINE=InnoDB;
/*ALTER TABLE especie ADD CONSTRAINT PK_especie PRIMARY KEY (id_especie);
ALTER TABLE especie ADD CONSTRAINT FK_id_planta FOREIGN KEY(id_planta) REFERENCES plantahospedera(id_planta);*/

INSERT INTO especie(nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) 
VALUES ('morpho menelaus', 'morfo azul', 'azul', 'grande', 0, 1, 'morfo.jpg'); 
INSERT INTO especie(nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) 
VALUES ('danaus plexippu', 'monarca', 'naranja', 'mediano', 0, 2, 'monarca.jpg');
INSERT INTO especie(nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) 
VALUES ('dione juno', 'mariposa cartero', 'naranja rojizo', 'mediano', 1, 3, 'cartero.jpg');  
INSERT INTO especie(nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) 
VALUES ('danaus sp.', 'falsa monarca', 'naranja', 'mediano', 1, 2, 'falsa_monarca.jpg'); 
INSERT INTO especie(nombre_cientifico, nombre_comun, color_especie, tamano_especie, tipo_alimentacion, id_planta, imagen_especie) 
VALUES ('leptophobia aripa', 'mariposa blanca', 'blanco', 'chico', 1, 4, 'blanca.jpg'); 



DROP TABLE IF EXISTS fase_huevo;
CREATE TABLE fase_huevo(
    id_lotehuevo INT NOT NULL AUTO_INCREMENT,
    huevos_recolec INT NOT NULL,
    inicio_etapa DATE NOT NULL,
    fin_etapa DATE,
    dias_reales INT,
    larvas_finales INT,
    id_especie INT NOT NULL,

    PRIMARY KEY (id_lotehuevo),
    FOREIGN KEY (id_especie) REFERENCES especie(id_especie)
)ENGINE=InnoDB;
/*ALTER TABLE fase_huevo ADD CONSTRAINT PKid_lotehuevo PRIMARY KEY (id_lotehuevo);
ALTER TABLE fase_huevo ADD CONSTRAINT FKid_especie FOREIGN KEY(id_especie) REFERENCES especie(id_especie);*/

INSERT INTO fase_huevo(huevos_recolec, inicio_etapa, fin_etapa, dias_reales, larvas_finales, id_especie) 
VALUES (400, '2021-01-04', '2021-01-14', 10, 398, 1); 
INSERT INTO fase_huevo(huevos_recolec, inicio_etapa, fin_etapa, dias_reales, larvas_finales, id_especie) 
VALUES (200, '2021-01-04', '2021-01-14', 10, 198, 2); 
INSERT INTO fase_huevo(huevos_recolec, inicio_etapa, fin_etapa, dias_reales, larvas_finales, id_especie) 
VALUES (150, '2021-02-15', '2021-02-21', 6, 150, 3); 




DROP TABLE IF EXISTS fase_larva;
CREATE TABLE fase_larva(
    id_lotelarva INT NOT NULL AUTO_INCREMENT,
    larvas_iniciales INT NOT NULL,
    inicio_etapa DATE NOT NULL,
    fecha_cambiohoja DATE,
    fin_etapa DATE,
    pupas_finales INT,
    id_lotehuevo INT NOT NULL,

    PRIMARY KEY (id_lotelarva),
    FOREIGN KEY (id_lotehuevo) REFERENCES fase_huevo(id_lotehuevo) ON DELETE CASCADE
)ENGINE=InnoDB;
/*ALTER TABLE fase_larva ADD CONSTRAINT PKid_lotelarva PRIMARY KEY (id_lotelarva);
ALTER TABLE fase_larva ADD CONSTRAINT FKid_lotehuevo FOREIGN KEY(id_lotehuevo) REFERENCES fase_huevo(id_lotehuevo);*/

INSERT INTO fase_larva(larvas_iniciales, inicio_etapa, fecha_cambiohoja, fin_etapa, pupas_finales, id_lotehuevo) 
VALUES (398, '2021-01-14', '2021-01-21', '2021-03-04', 398, 1); 
INSERT INTO fase_larva(larvas_iniciales, inicio_etapa, fecha_cambiohoja, fin_etapa, pupas_finales, id_lotehuevo) 
VALUES (150, '2021-02-22', '2021-03-07', '2021-03-14', 145, 3); 

DROP TABLE IF EXISTS fase_pupa;
CREATE TABLE fase_pupa(
    id_lotepupa INT NOT NULL AUTO_INCREMENT,
    pupas_iniciales INT NOT NULL,
    inicio_etapa DATE NOT NULL,
    fin_etapa DATE,
    adultos_finales INT,
    id_lotelarva INT NOT NULL,

    PRIMARY KEY (id_lotepupa),
    FOREIGN KEY (id_lotelarva) REFERENCES fase_larva(id_lotelarva) ON DELETE CASCADE
)ENGINE=InnoDB;
/*ALTER TABLE fase_pupa ADD CONSTRAINT PKid_lotepupa PRIMARY KEY (id_lotepupa);
ALTER TABLE fase_pupa ADD CONSTRAINT FKid_lotelarva FOREIGN KEY(id_lotelarva) REFERENCES fase_larva(id_lotelarva);*/

INSERT INTO fase_pupa(pupas_iniciales, inicio_etapa, fin_etapa, adultos_finales, id_lotelarva) 
VALUES (398, '2021-03-04', '2021-03-18', 395, 1); 
INSERT INTO fase_pupa(pupas_iniciales, inicio_etapa, fin_etapa, adultos_finales, id_lotelarva) 
VALUES (145, '2021-03-15', '2021-03-26', 142, 2); 


DROP TABLE IF EXISTS fase_adulto;
CREATE TABLE fase_adulto(
    id_loteadulto INT NOT NULL AUTO_INCREMENT,
    numfinal_adultos INT NOT NULL,
    cantidad_liberacion INT NOT NULL,
    cantidad_mariposario INT NOT NULL,
    id_lotepupa INT NOT NULL,

    PRIMARY KEY (id_loteadulto),
    FOREIGN KEY (id_lotepupa) REFERENCES fase_pupa(id_lotepupa) ON DELETE CASCADE
)ENGINE=InnoDB;
/*ALTER TABLE fase_adulto ADD CONSTRAINT PKid_loteadulto PRIMARY KEY (id_loteadulto);
ALTER TABLE fase_adulto ADD CONSTRAINT FKid_lotepupa FOREIGN KEY(id_lotepupa) REFERENCES fase_pupa(id_lotepupa);*/

INSERT INTO fase_adulto(numfinal_adultos, cantidad_liberacion, cantidad_mariposario, id_lotepupa) 
VALUES (395, 316, 79, 1); 
INSERT INTO fase_adulto(numfinal_adultos, cantidad_liberacion, cantidad_mariposario, id_lotepupa) 
VALUES (142, 86, 56, 2); 
/*
SELECT especie.*, plantahospedera.nombre_planta FROM especie 
INNER JOIN plantahospedera ON especie.id_planta=plantahospedera.id_planta;*/

/*SELECT especie.*, plantahospedera.nombre_planta FROM especie 
INNER JOIN plantahospedera ON especie.id_planta=plantahospedera.id_planta 
WHERE especie.nombre_comun LIKE '%mo%' OR especie.nombre_cientifico LIKE '%mo%';*/

/*SELECT fase_huevo.*, especie.nombre_comun, especie.imagen_especie FROM fase_huevo 
INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie ORDER BY fase_huevo.id_lotehuevo ASC;*/

/*SELECT fase_larva.*, especie.nombre_comun, especie.imagen_especie
FROM fase_larva INNER JOIN fase_huevo ON fase_larva.id_lotehuevo=fase_huevo.id_lotehuevo
INNER JOIN especie ON fase_huevo.id_especie=especie.id_especie; */

