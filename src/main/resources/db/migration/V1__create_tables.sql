

CREATE TABLE tb_users (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    documento VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario VARCHAR(20) NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0.00
);


CREATE TABLE tb_transactions(
    id SERIAL PRIMARY KEY,
    amount DECIMAL(10, 2),
    sender_id INTEGER NOT NULL,
    receiver_id INTEGER NOT NULL,
    tempo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (receiver_id) REFERENCES tb_users(id),
    FOREIGN KEY (sender_id) REFERENCES tb_users(id)
);

