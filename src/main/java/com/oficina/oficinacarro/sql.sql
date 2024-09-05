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
    `veiculo`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`, `cpf`)
);
