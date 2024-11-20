
CREATE TABLE IF NOT exists conta (
	id uuid,
	data_vencimento timestamp NOT NULL,
	data_pagamento timestamp,
	valor numeric NULL,
	descricao varchar NOT NULL,
	situacao varchar NOT NULL,
    PRIMARY KEY (id)
);
