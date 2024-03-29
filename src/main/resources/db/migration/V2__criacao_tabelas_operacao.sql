CREATE TABLE IF NOT EXISTS operacoes
(
    id                   BIGSERIAL PRIMARY KEY,
    documento_usuario    TEXT           NOT NULL,
    cartao_credito_token TEXT           NOT NULL,
    operacao_valor       numeric(18, 2) NOT NULL
);

create sequence if not exists operacoes_seq start with 1 increment by 1;