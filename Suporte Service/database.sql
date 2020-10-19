--docker run --name netflix-database -e "POSTGRES_PASSWORD=123456"  -e "POSTGRES_DB=netflix-suporte" -p 5432:5432 -d postgres
--docker exec -it netflix-database bash
--psql -U postgres
--\c netflix-suporte


CREATE TABLE atendente (
	id_atendente SERIAL PRIMARY KEY,
	nome_atendente VARCHAR(250) NOT NULL
);

CREATE TABLE ticket (
	id_ticket SERIAL PRIMARY KEY,
	id_filme SERIAL,
	id_usuario SERIAL,
	desc_erro VARCHAR(250) NOT NULL,
	data_criacao TIMESTAMP NOT NULL,
	id_atendente SERIAL,
	FOREIGN KEY (id_atendente) REFERENCES atendente (id_atendente)
);