-- Cria o esquema 'oficina'
CREATE SCHEMA `oficina`;

-- Tabela de clientes
CREATE TABLE `oficina`.`cliente`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `nome`     VARCHAR(45) NOT NULL,
    `cpf`      VARCHAR(15) NOT NULL,
    `telefone` VARCHAR(45) NOT NULL,
    `email`    VARCHAR(45) NOT NULL,
    `endereco` VARCHAR(45) NOT NULL,
    `login`    VARCHAR(45) NOT NULL,
    `senha`    VARCHAR(45) NOT NULL,
    `rank` TINYINT(1) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`cpf`) -- CPF é único
);

-- Tabela de veículos, referenciando o cliente
CREATE TABLE `oficina`.`veiculo`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `cliente_id` INT        NOT NULL, -- chave estrangeira para cliente
    `veiculo`   VARCHAR(45) NOT NULL,
    `placa`     VARCHAR(10) NOT NULL,
    `modelo`    VARCHAR(45) NOT NULL,
    `ano`       INT         NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cliente_id`) REFERENCES `cliente`(`id`) ON DELETE CASCADE
);
