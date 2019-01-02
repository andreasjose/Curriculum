Insert into categoria (descricao)
values ('Alimentos'),
('Bebidas'),
('Higiene'),
('Limpeza'),
('Brinquedos'),
('Refrigerados');

Insert into funcionario (nome, senha, login)
values ('Ana Caroline Valadares', '111111', '111111'),
('Kleber Machado dos Santos', '222222', '111111'),
('Barbara Sores Reis', '333333', '333333'),
('João batata roxa', '444444', '444444'),
('Julia solimões Pereira', '555555', '555555');

Insert into descricaoproduto(descricao)
values('Arroz Maravilha 5 Kg'),
('Feijão Bom Jesus 2 Kg'),
('Macarrão Corações 1 Kg'),
('Trigo Regina 1Kg'),
('Macarrão Instantaneo Tia Luiza'),
('Suco Uva Gargola 1 L'),
('Skol lata 400 ml'),
('Brahma lata 700 ml'),
('Refrigerante Coroa 2 L'),
('Coca Cola lata 400 ml'),
('Papel Higienico 6 rolos 30 m'),
('Desinfetante margour 700 ml'),
('Peito de Frango com osso'),
('Queijo prato Fazenda Feliz 400g');

Insert into produto (descricaoproduto_id, quantidadeestoque, quantidadecomprada, precocompra, precovenda, datavalidade, categoria_id)
values (1, 200, 200, 12.0, 15.0, '2019-02-28', 1),
(2, 300, 300, 10.0, 12.0, '2019-07-30', 1),
(3, 150 , 150, 4.0, 5.0, '2019-10-05', 1),
(4, 200, 200, 1.5, 2.0, '2019-07-30', 1),
(5, 100, 100,  0.8, 0.99, '2020-12-31', 1),
(6, 50, 50, 6.0, 8.0, '2019-01-30', 2),
(7, 75, 75, 3.5, 5.0, '2019-05-30', 2),
(8, 80, 80, 5.0, 7.0, '2019-07-30', 2),
(9, 150, 150, 2.5, 3.0, '2019-08-30', 2),
(10, 200, 200, 2.0, 2.5, '2019-11-30', 2),
(11, 150, 150, 6.0, 8.0, '2030-01-30', 3),
(12, 100, 100, 12.0, 15.0, '2030-05-30', 4),
(13, 150, 150, 6.0, 8.0, '2019-01-30', 6),
(14, 100, 100, 7.5, 9.0, '2019-01-20', 6);
