-- Gerado por Oracle SQL Developer Data Modeler 19.2.0.182.1216
--   em:        2022-06-13 15:00:15 BRT
--   site:      Oracle Database 12cR2
--   tipo:      Oracle Database 12cR2


CREATE SEQUENCE tb_estabelecimento_seq INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;

CREATE SEQUENCE tipo_estabelecimento_seq INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;

CREATE SEQUENCE usuario_seq INCREMENT BY 1 MAXVALUE 9999999999999999999999999999 MINVALUE 1 CACHE 20;

CREATE TABLE avaliacao (
    id_estabelecimento   NUMBER(*, 0) NOT NULL,
    id_usuario           NUMBER(*, 0) NOT NULL,
    dh_avaliacao         TIMESTAMP,
    nota                 NUMBER(*, 0)
)
PCTFREE 10 PCTUSED 40 TABLESPACE tbspc_alunos LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
    DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX avaliacao_pk ON
    avaliacao (
        id_estabelecimento
    ASC,
        id_usuario
    ASC )
        TABLESPACE tbspc_alunos PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE avaliacao
    ADD CONSTRAINT avaliacao_pk PRIMARY KEY ( id_estabelecimento,
                                              id_usuario )
        USING INDEX avaliacao_pk;

CREATE TABLE estabelecimento (
    id_estabelecimento        NUMBER(*, 0) NOT NULL,
    nome_estabelecimento      VARCHAR2(50 BYTE),
    id_tipo_estabelecimento   NUMBER(*, 0)
)
PCTFREE 10 PCTUSED 40 TABLESPACE tbspc_alunos LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
    DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX estabelecimento_pk ON
    estabelecimento (
        id_estabelecimento
    ASC )
        TABLESPACE tbspc_alunos PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE estabelecimento
    ADD CONSTRAINT estabelecimento_pk PRIMARY KEY ( id_estabelecimento )
        USING INDEX estabelecimento_pk;

CREATE TABLE tipo_estabelecimento (
    id_tipo_estabelecimento     NUMBER(*, 0) NOT NULL,
    nome_tipo_estabelecimento   VARCHAR2(50 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE tbspc_alunos LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
    DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX tipo_estabelecimento_pk ON
    tipo_estabelecimento (
        id_tipo_estabelecimento
    ASC )
        TABLESPACE tbspc_alunos PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE tipo_estabelecimento
    ADD CONSTRAINT tipo_estabelecimento_pk PRIMARY KEY ( id_tipo_estabelecimento )
        USING INDEX tipo_estabelecimento_pk;

CREATE TABLE usuario (
    id_usuario      NUMBER(*, 0) NOT NULL,
    nome_usuario    VARCHAR2(50 BYTE),
    senha_usuario   VARCHAR2(255 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE tbspc_alunos LOGGING
    STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
    DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX usuario_pk ON
    usuario (
        id_usuario
    ASC )
        TABLESPACE tbspc_alunos PCTFREE 10
            STORAGE ( INITIAL 65536 NEXT 1048576 PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS 2147483645 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL
            DEFAULT )
        LOGGING;

ALTER TABLE usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario )
        USING INDEX usuario_pk;

ALTER TABLE avaliacao
    ADD CONSTRAINT avaliacao_fk1 FOREIGN KEY ( id_estabelecimento )
        REFERENCES estabelecimento ( id_estabelecimento )
    NOT DEFERRABLE;

ALTER TABLE avaliacao
    ADD CONSTRAINT avaliacao_fk2 FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario )
    NOT DEFERRABLE;

ALTER TABLE estabelecimento
    ADD CONSTRAINT estabelecimento_fk1 FOREIGN KEY ( id_tipo_estabelecimento )
        REFERENCES tipo_estabelecimento ( id_tipo_estabelecimento )
    NOT DEFERRABLE;



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             4
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          3
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        1
-- CREATE USER                              1
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 1
