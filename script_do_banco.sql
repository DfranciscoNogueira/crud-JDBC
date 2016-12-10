CREATE SCHEMA `estudo` ;

-- Criando tabela de pessoas

CREATE TABLE `estudo`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `profissao` VARCHAR(30) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Tabela de Pessoas';