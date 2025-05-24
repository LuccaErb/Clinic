CREATE TABLE patients (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL ,
                         cpf VARCHAR(11) NOT NULL UNIQUE,

                         active BOOLEAN NOT NULL DEFAULT true,
                         public_place VARCHAR(100) NOT NULL,
                         neighborhood VARCHAR(100) NOT NULL,
                         cep VARCHAR(9) NOT NULL,
                         complement VARCHAR(100),
                         number VARCHAR(20),
                         uf CHAR(2) NOT NULL,
                         city VARCHAR(100) NOT NULL
);
