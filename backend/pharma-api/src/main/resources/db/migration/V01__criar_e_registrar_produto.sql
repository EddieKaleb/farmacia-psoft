CREATE TABLE `LOTE_SITUACAO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `DESCONTO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(50) NOT NULL,
  `PORCENTAGEM` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CATEGORIA` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(30) NOT NULL,
  `DESCONTO_ID` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_DESCONTO_CATEGORIA` (`DESCONTO_ID` ASC),
  CONSTRAINT `fk_CATEGORIA_DESCONTO1`
    FOREIGN KEY (`DESCONTO_ID`)
    REFERENCES `DESCONTO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PRODUTO_SITUACAO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `PRODUTO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(100) NOT NULL,
  `NOME_FABRICANTE` VARCHAR(50) NOT NULL,
  `CAMINHO_IMAGEM` VARCHAR(3000),
  `PRECO` DECIMAL NOT NULL,
  `CATEGORIA_ID` INT NOT NULL,
  `PRODUTO_SITUACAO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_CATEGORIA_PRODUTO` (`CATEGORIA_ID` ASC),
  INDEX `FK_PRODUTO_SITUACAO_PRODUTO` (`PRODUTO_SITUACAO_ID` ASC),
  CONSTRAINT `fk_PRODUTO_CATEGORIA1`
    FOREIGN KEY (`CATEGORIA_ID`)
    REFERENCES `CATEGORIA` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUTO_PRODUTO_SITUACAO1`
    FOREIGN KEY (`PRODUTO_SITUACAO_ID`)
    REFERENCES `PRODUTO_SITUACAO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `LOTE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `QUANTIDADE` INT NOT NULL,
  `GTIN` VARCHAR(45) NOT NULL,
  `VALIDADE` DATE NOT NULL,
  `LOTE_SITUACAO_ID` INT NOT NULL,
  `PRODUTO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `GTIN_UNIQUE` (`GTIN` ASC),
  INDEX `FK_LOTE_SITUACAO_LOTE` (`LOTE_SITUACAO_ID` ASC),
  INDEX `FK_PRODUTO_LOTE` (`PRODUTO_ID` ASC),
  CONSTRAINT `fk_LOTE_LOTE_SITUACAO1`
    FOREIGN KEY (`LOTE_SITUACAO_ID`)
    REFERENCES `LOTE_SITUACAO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LOTE_PRODUTO1`
    FOREIGN KEY (`PRODUTO_ID`)
    REFERENCES `PRODUTO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ESTOQUE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `QUANTIDADE` INT NOT NULL,
  `SITUACAO` VARCHAR(50) NOT NULL,
  `RECEITA` DECIMAL NOT NULL,
  `PRODUTO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_PRODUTO_ESTOQUE` (`PRODUTO_ID` ASC),
  CONSTRAINT `fk_ESTOQUE_PRODUTO1`
    FOREIGN KEY (`PRODUTO_ID`)
    REFERENCES `PRODUTO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO LOTE_SITUACAO (NOME) VALUES
("Válido"), 
("Vencido");

INSERT INTO DESCONTO (NOME,PORCENTAGEM) VALUES
("Sem desconto",1.00), 
("Bom desconto",0.90), 
("Ótimo desconto",0.75), 
("Super desconto",0.5); 

INSERT INTO PRODUTO_SITUACAO (NOME) VALUES
("Disponível"), 
("Indisponível"); 

INSERT INTO CATEGORIA (NOME,DESCONTO_ID) VALUES
("Medicamentos",1), 
("Higiene Pessoal",1), 
("Cosméticos",1), 
("Alimentos",1); 

