INSERT INTO Categoria (nome) VALUES 
('Frutas'),
('Bebidas'),
('Carnes'),
('Cereais'),
('Laticínios'),
('Legumes'),
('Doces'),
('Congelados'),
('Hortaliças'),
('Padaria');

INSERT INTO Fabricante (nome) VALUES
('Pepsi'),
('The Coca-Cola Company'),
('Nestlé'),
('Unilever'),
('Ambev'),
('Danone'),
('Mondelez'),
('Heineken'),
('Bunge'),
('BRF');

INSERT INTO Cliente (cpf, nome) VALUES
('12339641926', 'Luis'),
('98765432100', 'Ana'),
('45678912300', 'Carlos'),
('32165498700', 'Mariana'),
('78912345600', 'Pedro'),
('65498732100', 'Beatriz'),
('14725836900', 'Felipe'),
('96385274100', 'Juliana'),
('25836914700', 'Rafael'),
('36914725800', 'Sofia');

INSERT INTO Funcionario (cpf, nome) VALUES
('28256348201', 'Ana'),
('39485710294', 'Bruno'),
('48572910385', 'Carla'),
('59283710476', 'Diego'),
('67829140567', 'Eduarda'),
('78910350648', 'Fernando'),
('89123460739', 'Gabriela'),
('91234570820', 'Henrique'),
('10293840911', 'Isabela'),
('20384751002', 'João');

INSERT INTO Produto (nome, preco, quantidade, validade, categoria_codigo, fabricante_codigo) VALUES 
('Coca Cola 2 Litros', 12.00, 15, '2025-12-20', 2, 2),
('Pepsi 2 Litros', 11.50, 20, '2025-11-15', 2, 1),
('Suco de Laranja 1 Litro', 8.00, 30, '2025-10-10', 2, 3),
('Maçã', 4.50, 50, '2025-09-25', 1, 4),
('Banana', 3.50, 60, '2025-09-20', 1, 4),
('Arroz 5kg', 25.00, 40, '2026-01-30', 4, 9),
('Feijão Preto 1kg', 10.00, 45, '2026-02-15', 4, 9),
('Pão Francês 500g', 6.00, 25, '2025-09-15', 10, 7),
('Leite Integral 1L', 5.50, 35, '2025-09-18', 5, 6),
('Queijo Mussarela 1kg', 30.00, 20, '2025-10-05', 5, 6),
('Frango Congelado 1kg', 15.00, 25, '2025-11-01', 3, 10);

INSERT INTO ItemVenda (Produto_codigo, quantidadeParcial, valorParcial) VALUES
(1, 2, 24.00),
(2, 1, 11.50),
(3, 5, 40.00),
(4, 3, 13.50),
(5, 2, 7.00),
(6, 1, 25.00),
(7, 4, 40.00),
(8, 2, 12.00),
(9, 1, 5.50),
(10, 3, 90.00),
(11, 2, 30.00);

INSERT INTO Venda (Cliente_codigo, Funcionario_codigo, quantidadeTotal, valorTotal, horario) VALUES
(1, 1, 5, 120.00, '2025-09-10 10:30:00'),
(2, 2, 3, 75.00, '2025-09-10 11:00:00'),
(3, 3, 2, 40.00, '2025-09-10 11:30:00'),
(4, 4, 6, 150.00, '2025-09-10 12:00:00'),
(5, 5, 4, 90.00, '2025-09-10 12:30:00'),
(6, 6, 7, 175.00, '2025-09-10 13:00:00'),
(7, 7, 3, 60.00, '2025-09-10 13:30:00'),
(8, 8, 5, 125.00, '2025-09-10 14:00:00'),
(9, 9, 2, 50.00, '2025-09-10 14:30:00'),
(10, 10, 6, 180.00, '2025-09-10 15:00:00');