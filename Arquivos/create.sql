
CREATE TABLE t_cliente (
    id INT IDENTITY(1,1) PRIMARY KEY,
    email NVARCHAR(255),
    senha NVARCHAR(255)
);

CREATE TABLE t_dispositivo (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome NVARCHAR(255),
    tipo NVARCHAR(255),
    consumo_medio DECIMAL(10, 2),
    data_instalacao DATE,
    cliente_id INT
);

ALTER TABLE t_dispositivo
ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES t_cliente(id);

CREATE TABLE t_rotina (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome NVARCHAR(255),
    descricao NVARCHAR(255),
    hora_inicio NVARCHAR(255),
    hora_fim NVARCHAR(255),
    dispositivo_id INT
);

ALTER TABLE t_rotina
ADD CONSTRAINT fk_dispositivo FOREIGN KEY (dispositivo_id) REFERENCES t_dispositivo(id);
