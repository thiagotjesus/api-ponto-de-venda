CREATE TABLE produto(
    id bigserial NOT NULL,
    nome text NOT NULL,
    valor real NOT NULL,
    quantidade_estoque integer NOT NULL,
    PRIMARY KEY (id)
)