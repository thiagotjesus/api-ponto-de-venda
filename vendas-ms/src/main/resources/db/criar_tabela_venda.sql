CREATE TABLE venda (
    id bigserial NOT NULL,
    data_hora timestamp with time zone NOT NULL,
    quantidade_vendida integer NOT NULL,
    valor_total real NOT NULL,
    produto_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_venda_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
)