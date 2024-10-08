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
                                     data_fim_status TIMESTAMP NULL DEFAULT NULl,
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


-- INSERTS PARA TESTES

INSERT INTO cliente (id, nome_cliente, cpf_cliente, telefone_cliente, email_cliente, endereco_cliente, senha_cliente, tipo_usuario) VALUES
(1, 'João Silva', '123.456.789-00', '(11) 98765-4321', 'joao.silva@example.com', 'Rua A, 123', 'senha123', 'Cliente'),
(2, 'Maria Oliveira', '234.567.890-11', '(11) 97654-3210', 'maria.oliveira@example.com', 'Rua B, 456', 'senha456', 'Cliente'),
(3, 'Carlos Santos', '345.678.901-22', '(11) 96543-2109', 'carlos.santos@example.com', 'Rua C, 789', 'senha789', 'Cliente'),
(4, 'Ana Souza', '456.789.012-33', '(11) 95432-1098', 'ana.souza@example.com', 'Rua D, 101', 'senha101', 'Cliente'),
(5, 'Lucas Pereira', '567.890.123-44', '(11) 94321-0987', 'lucas.pereira@example.com', 'Rua E, 202', 'senha202', 'Cliente');
 SELECT * FROM cliente;


 INSERT INTO oficinacarro.status (id_status, descricao_status, data_inicio_status) VALUES
 (1, 'Aguardando chegada', CURRENT_TIMESTAMP),
 (2, 'Ausente', CURRENT_TIMESTAMP),
 (3, 'Atrasado', CURRENT_TIMESTAMP),
 (4, 'Em Triagem', CURRENT_TIMESTAMP),
 (5, 'Em manutenção', CURRENT_TIMESTAMP),
 (6, 'Em lavagem', CURRENT_TIMESTAMP),
 (7, 'Em preparação', CURRENT_TIMESTAMP),
 (8, 'Pronto', CURRENT_TIMESTAMP),
 (9, 'Entregue', CURRENT_TIMESTAMP);
 select * from status

 INSERT INTO oficinacarro.veiculo (id_veiculo, id_cliente, modelo_veiculo, placa_veiculo, marca_veiculo, ano_veiculo) VALUES
 (1, 1, 'Palio', 'ABC1234', 'FIAT', 2002),
 (2, 1, 'Gol', 'DEF5678', 'VOLKSWAGEN', 2021),
 (3, 2, 'Celta', 'GHI9012', 'Chevrolet', 2015);
 SELECT * FROM oficinacarro.veiculo;

-- INSERT DA TABELA ABAIXO SERÁ O ULTIMO POIS ELA PRECISA DAS OUTRAS ABASTECIDAS DE DADOS

 INSERT INTO statusVeiculos (id_status_veiculo, id_cliente, id_veiculo, id_status) VALUES
 (1, 1, 1, 1),  -- Exemplo de status para o veículo 1 do cliente 1
 (2, 1, 1, 2),  -- Exemplo de status diferente para o mesmo veículo
 (3, 2, 2, 1),  -- Exemplo de status para o veículo 2 do cliente 2
 (4, 2, 3, 3);  -- Exemplo de status para o veículo 3 do cliente 2
  SELECT * FROM statusVeiculos



