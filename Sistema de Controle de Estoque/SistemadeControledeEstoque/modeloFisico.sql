DROP TABLE IF EXISTS itemproduto;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS venda;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS descricaoproduto;

CREATE TABLE funcionario(
  id INT auto_increment,
  Nome VARCHAR(45) NULL,
  senha VARCHAR(45) NULL,
  login VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE venda(
  id INT auto_increment,
  nomecliente VARCHAR(45) NULL,
  cpfcliente VARCHAR(45) NULL,
  valortotal FLOAT NULL,
  data DATE NULL,
  funcionario_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_venda_funcionario
    FOREIGN KEY (funcionario_id)
    REFERENCES funcionario (id));


CREATE TABLE categoria(
  id INT auto_increment,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE descricaoproduto(
  id INT auto_increment,
  descricao VARCHAR(45) NULL,
  PRIMARY KEY (ID));

CREATE TABLE produto(
  id INT auto_increment,
  descricaoproduto_id INT NULL,
  quantidadeestoque INT NULL,
  quantidadecomprada INT NULL,
  precocompra FLOAT NULL,
  precovenda FLOAT NULL,
  datavalidade Date NULL,
  categoria_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_produto_categoria1
    FOREIGN KEY (categoria_id)
    REFERENCES categoria (id),
  CONSTRAINT fk_produto_descricaoproduto1
    FOREIGN KEY (descricaoproduto_id)
    REFERENCES descricaoproduto (id));

CREATE TABLE itemproduto(
  id INT auto_increment,
  valorvenda FLOAT NULL,
  quantidade INT NULL,
  venda_id INT NULL,
  produto_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_itemproduto_venda1
    FOREIGN KEY (venda_id)
    REFERENCES venda (id),
  CONSTRAINT fk_itemproduto_produto1
    FOREIGN KEY (produto_id)
    REFERENCES produto (id));
