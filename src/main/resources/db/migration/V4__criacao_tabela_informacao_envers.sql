CREATE TABLE IF NOT EXISTS auditoria.revinfo
(
    rev      INT PRIMARY KEY,
    revtstmp BIGINT
);

CREATE SEQUENCE IF NOT EXISTS revinfo_seq START WITH 1 INCREMENT BY 1;