CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       login VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL
);


INSERT INTO users (id, login, password)
VALUES (1, 'admin', '$2a$10$xl2Y.aKRZ92OrxR/ieCnweap7iKv7vODjx.5Xq8U8fHAfWEOuunma');