CREATE TABLE IF NOT EXISTS auditoria.aud_operacoes
(
    id             BIGINT         NOT NULL,
    rev_id         INT,
    rev_type       INT2,
    operacao_valor numeric(18, 2) NOT NULL,
    PRIMARY KEY (id, rev_id)
);

ALTER TABLE IF EXISTS auditoria.aud_operacoes
    ADD CONSTRAINT aud_operacoes_fk
        FOREIGN KEY (rev_id)
            REFERENCES auditoria.revinfo;