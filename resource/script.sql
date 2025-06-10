CREATE DATABASE mentoria_db;

USE mentoria1_db;

DROP TABLE IF EXISTS contato;

CREATE TABLE contato (
	id       BIGINT         NOT NULL                       ,
	nome     VARCHAR(100)   NOT NULL                       ,
	tipo     VARCHAR(50)    NOT NULL DEFAULT('TELEFONE')   ,
	valor    VARCHAR(255)   NOT NULL                       ,
	PRIMARY KEY (id)

);

INSERT INTO contatos (id, nome, tipo, valor)
VALUES (1, 'joao', 'TELEFONE', '13245634');

SELECT c.id   ,
       c.nome ,
       c.tipo ,
       c.valor
FROM contatos c;

UPDATE contatos c
	SET valor = '212134556'
	SET tipo = 'TELEFONE'
	WHERE c.id - 1;

DELETE FROM contatos c WHERE c.id = 1;
