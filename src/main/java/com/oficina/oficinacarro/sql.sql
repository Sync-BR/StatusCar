
CREATE SCHEMA `oficina`;

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
    UNIQUE (`cpf`)
);

CREATE TABLE `oficina`.`veiculo`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `cliente_id` INT        NOT NULL,
    `veiculo`   VARCHAR(45) NOT NULL,
    `placa`     VARCHAR(10) NOT NULL,
    `modelo`    VARCHAR(45) NOT NULL,
    `ano`       INT         NOT NULL,
    `status`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`cliente_id`) REFERENCES `cliente`(`id`) ON DELETE CASCADE
);


ALTER TABLE veiculo MODIFY cliente INT DEFAULT 0;

