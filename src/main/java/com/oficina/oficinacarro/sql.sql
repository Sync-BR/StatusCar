CREATE SCHEMA oficinacarro;
CREATE TABLE oficinacarro.cliente (
                                      id INT NOT NULL AUTO_INCREMENT,
                                      nome_cliente VARCHAR(45) NOT NULL,
                                      cpf_cliente VARCHAR(15) NOT NULL,
                                      telefone_cliente VARCHAR(45) NOT NULL,
                                      email_cliente VARCHAR(45) NOT NULL,
                                      endereco_cliente VARCHAR(45) NOT NULL,
                                      senha_cliente VARCHAR(45) NOT NULL,
                                      tipo_usuario TINYINT(1) NOT NULL,
                                      PRIMARY KEY (id),
                                      UNIQUE (cpf_cliente)
);

CREATE TABLE oficinacarro.veiculo (
                                      id_veiculo INT NOT NULL AUTO_INCREMENT,
                                      id_cliente INT NOT NULL,
                                      modelo_veiculo VARCHAR(45) NOT NULL,
                                      placa_veiculo VARCHAR(10) NOT NULL,
                                      marca_veiculo VARCHAR(45) NOT NULL,
                                      ano_veiculo INT NOT NULL,
                                      PRIMARY KEY (id_veiculo),
                                      FOREIGN KEY (id_cliente) REFERENCES oficinacarro.cliente (id) ON DELETE CASCADE
);

CREATE TABLE oficinacarro.status (
                                     id_status INT NOT NULL ,
                                     descricao_status VARCHAR(45) NOT NULL,
                                     data_inicio_status TIMESTAMP NOT NULL,
                                     data_fim_status TIMESTAMP DEFAULT NULL,
                                     PRIMARY KEY (id_status)
);

CREATE TABLE oficinacarro.statusVeiculos (
                                             id_status_veiculo INT NOT NULL AUTO_INCREMENT,
                                             id_cliente INT NOT NULL,
                                             id_veiculo INT NOT NULL,
                                             id_status INT NOT NULL,
                                             PRIMARY KEY (id_status_veiculo),
                                             FOREIGN KEY (id_cliente) REFERENCES oficinacarro.cliente (id) ON DELETE CASCADE,
                                             FOREIGN KEY (id_veiculo) REFERENCES oficinacarro.veiculo (id_veiculo) ON DELETE CASCADE,
                                             FOREIGN KEY (id_status) REFERENCES oficinacarro.status (id_status) ON DELETE NO ACTION
);

CREATE TABLE oficinacarro.autenticacao (
                                           id_cliente_aut INT NOT NULL,
                                           cpf_cliente_aut VARCHAR(15) NOT NULL,
                                           senha_cliente_aut VARCHAR(45) NOT NULL,
                                           PRIMARY KEY (id_cliente_aut),
                                           FOREIGN KEY (id_cliente_aut) REFERENCES oficinacarro.cliente (id) ON DELETE CASCADE
);

-- 1. Consulta Completa
SELECT
    sv.id_status_veiculo,
    c.nome_cliente,
    v.modelo_veiculo,
    v.placa_veiculo,
    v.marca_veiculo,
    v.ano_veiculo,
    s.descricao_status
FROM
    oficina.statusVeiculos sv
        JOIN
    oficina.cliente c ON sv.id_cliente = c.id_cliente
        JOIN
    oficina.veiculo v ON sv.id_veiculo = v.id_veiculo
        JOIN
    oficina.status s ON sv.id_status = s.id_status;
 -- 2. Filtrando por Cliente
SELECT
    sv.id_status_veiculo,
    v.modelo_veiculo,
    v.placa_veiculo,
    s.descricao_status
FROM
    oficina.statusVeiculos sv
        JOIN
    oficina.veiculo v ON sv.id_veiculo = v.id_veiculo
        JOIN
    oficina.status s ON sv.id_status = s.id_status
WHERE
    sv.id_cliente = 1;  -- Substitua 1 pelo ID do cliente desejado

--3. Filtrando por Veículo
SELECT
    sv.id_status_veiculo,
    c.nome_cliente,
    s.descricao_status
FROM
    oficina.statusVeiculos sv
        JOIN
    oficina.cliente c ON sv.id_cliente = c.id_cliente
        JOIN
    oficina.status s ON sv.id_status = s.id_status
WHERE
    sv.id_veiculo = 2;  -- Substitua 2 pelo ID do veículo desejado

-- 3. Stored Procedures
-- Mostrar Status na tela
DELIMITER //

CREATE PROCEDURE getStatusVeiculo(
    IN p_id_veiculo INT
)
BEGIN
    SELECT
        sv.id_status_veiculo,
        v.modelo_veiculo,
        s.descricao_status,
        sv.id_cliente,
        c.nome_cliente,
        sv.id_status,
        s.data_inicio_status,
        s.data_fim_status
    FROM
        oficinacarro.statusVeiculos sv
    JOIN oficinacarro.veiculo v ON sv.id_veiculo = v.id_veiculo
    JOIN oficinacarro.status s ON sv.id_status = s.id_status
    JOIN oficinacarro.cliente c ON sv.id_cliente = c.id
    WHERE sv.id_veiculo = p_id_veiculo;

END //

DELIMITER ;

-- Alterar Status
DELIMITER //

CREATE PROCEDURE updateStatusVeiculo(
    IN p_id_veiculo INT,
    IN p_novo_status INT
)
BEGIN
    -- Atualiza o campo data_fim_status do status anterior
    UPDATE oficinacarro.status
    SET data_fim_status = NOW()
    WHERE id_status = (SELECT id_status FROM oficinacarro.statusVeiculos WHERE id_veiculo = p_id_veiculo)
    AND data_fim_status IS NULL;

    -- Atualiza o status do veículo
    UPDATE oficinacarro.statusVeiculos
    SET id_status = p_novo_status
    WHERE id_veiculo = p_id_veiculo;

    -- Define a data de início do novo status
    UPDATE oficinacarro.status
    SET data_inicio_status = NOW(), data_fim_status = NULL
    WHERE id_status = p_novo_status;

END //

DELIMITER ;


