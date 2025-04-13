CREATE TABLE doctors (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL ,
                         crm VARCHAR(6) NOT NULL UNIQUE,
                         specialty VARCHAR(100) NOT NULL,

                         public_place VARCHAR(100) NOT NULL,
                         neighborhood VARCHAR(100) NOT NULL,
                         cep VARCHAR(9) NOT NULL,
                         complement VARCHAR(100),
                         number VARCHAR(20),
                         uf CHAR(2) NOT NULL,
                         city VARCHAR(100) NOT NULL
);
