insert ignore into budget.expense (id_expense, planned_value, description)
values
(UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064'), 0, 'Supermercado'),
(UUID_TO_BIN('35712e6d-48bd-4b98-aa4b-5924d71462b5'), 0, 'Entretenimento'),
(UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319'), 0, 'Transporte'),
(UUID_TO_BIN('d117c5b6-3af7-4f75-96b9-ce64386d48c1'), 0, 'Saúde'),
(UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c'), 0, 'Fastfood'),
(UUID_TO_BIN('6a70131a-ba75-4031-b47b-bb0ea34dd9ff'), 0, 'Contas Gerais'),
(UUID_TO_BIN('3e37b6f9-22e5-4951-a889-38cba1f293d7'), 0, 'Programa em casal'),
(UUID_TO_BIN('7c6c5e40-7e1f-4b03-8ef3-594a23e2254e'), 0, 'Programa em amigos'),
(UUID_TO_BIN('3c9d63e6-d94d-4e46-b72a-0ec4fec5d68f'), 0, 'Outros');

INSERT ignore INTO `budget`.`transaction` (`id_transaction`,`value_transaction`, `description`, `transaction_date`, `id_expense`)
VALUES
 (UUID_TO_BIN(UUID()), '100', 'Hamburger', '2023-07-02', UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c')),
 (UUID_TO_BIN(UUID()), '100', 'Sorvete', now(), UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c')),
 (UUID_TO_BIN(UUID()), '100', 'Mercado', '2023-07-02', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
 (UUID_TO_BIN(UUID()), '100', 'Emporio', now(), UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064'))
;
-- Inserindo mais transações para o ano de 2025
INSERT IGNORE INTO `budget`.`transaction` (`id_transaction`,`value_transaction`, `description`, `transaction_date`, `id_expense`)
VALUES
-- Janeiro 2025
(UUID_TO_BIN(UUID()), '350.50', 'Compras do mês', '2025-01-10', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
(UUID_TO_BIN(UUID()), '85.00', 'Uber para o trabalho', '2025-01-15', UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319')),
(UUID_TO_BIN(UUID()), '150.00', 'Conta de Luz', '2025-01-20', UUID_TO_BIN('6a70131a-ba75-4031-b47b-bb0ea34dd9ff')),

-- Fevereiro 2025
(UUID_TO_BIN(UUID()), '45.90', 'Pizza com amigos', '2025-02-05', UUID_TO_BIN('7c6c5e40-7e1f-4b03-8ef3-594a23e2254e')),
(UUID_TO_BIN(UUID()), '200.00', 'Farmácia', '2025-02-12', UUID_TO_BIN('d117c5b6-3af7-4f75-96b9-ce64386d48c1')),
(UUID_TO_BIN(UUID()), '75.20', 'Cinema', '2025-02-22', UUID_TO_BIN('3e37b6f9-22e5-4951-a889-38cba1f293d7')),

-- Março 2025
(UUID_TO_BIN(UUID()), '420.00', 'Supermercado da quinzena', '2025-03-08', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
(UUID_TO_BIN(UUID()), '55.00', 'Lanche da tarde', '2025-03-18', UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c')),

-- Abril 2025
(UUID_TO_BIN(UUID()), '120.00', 'Show', '2025-04-01', UUID_TO_BIN('35712e6d-48bd-4b98-aa4b-5924d71462b5')),
(UUID_TO_BIN(UUID()), '95.40', 'Gasolina', '2025-04-11', UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319')),
(UUID_TO_BIN(UUID()), '300.00', 'Presente de aniversário', '2025-04-25', UUID_TO_BIN('3c9d63e6-d94d-4e46-b72a-0ec4fec5d68f')),

-- Maio 2025
(UUID_TO_BIN(UUID()), '280.80', 'Feira semanal', '2025-05-05', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
(UUID_TO_BIN(UUID()), '180.00', 'Conta de Internet', '2025-05-21', UUID_TO_BIN('6a70131a-ba75-4031-b47b-bb0ea34dd9ff')),

-- Junho 2025
(UUID_TO_BIN(UUID()), '65.00', 'Jantar romântico', '2025-06-12', UUID_TO_BIN('3e37b6f9-22e5-4951-a889-38cba1f293d7')),
(UUID_TO_BIN(UUID()), '500.00', 'Consulta médica', '2025-06-20', UUID_TO_BIN('d117c5b6-3af7-4f75-96b9-ce64386d48c1')),

-- Julho 2025
(UUID_TO_BIN(UUID()), '90.00', 'Almoço com a equipe', '2025-07-07', UUID_TO_BIN('7c6c5e40-7e1f-4b03-8ef3-594a23e2254e')),
(UUID_TO_BIN(UUID()), '30.00', 'Café', '2025-07-15', UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c')),

-- Agosto 2025
(UUID_TO_BIN(UUID()), '600.00', 'Compras de mercado maiores', '2025-08-10', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
(UUID_TO_BIN(UUID()), '40.50', 'Metrô/Ônibus', '2025-08-18', UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319')),

-- Setembro 2025
(UUID_TO_BIN(UUID()), '250.00', 'Peça de teatro', '2025-09-05', UUID_TO_BIN('35712e6d-48bd-4b98-aa4b-5924d71462b5')),
(UUID_TO_BIN(UUID()), '88.00', 'Jantar com amigos', '2025-09-20', UUID_TO_BIN('7c6c5e40-7e1f-4b03-8ef3-594a23e2254e')),

-- Outubro 2025
(UUID_TO_BIN(UUID()), '320.00', 'Remédios', '2025-10-14', UUID_TO_BIN('d117c5b6-3af7-4f75-96b9-ce64386d48c1')),
(UUID_TO_BIN(UUID()), '70.00', 'Ifood', '2025-10-22', UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c')),

-- Novembro 2025
(UUID_TO_BIN(UUID()), '450.00', 'Compras para casa', '2025-11-11', UUID_TO_BIN('3c9d63e6-d94d-4e46-b72a-0ec4fec5d68f')),
(UUID_TO_BIN(UUID()), '220.00', 'Conta de Água', '2025-11-20', UUID_TO_BIN('6a70131a-ba75-4031-b47b-bb0ea34dd9ff')),

-- Dezembro 2025
(UUID_TO_BIN(UUID()), '800.00', 'Ceia de Natal', '2025-12-24', UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064')),
(UUID_TO_BIN(UUID()), '150.00', 'Viagem de fim de ano', '2025-12-28', UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319'));

-- Inserindo locais de investimento (bancos)
INSERT IGNORE INTO `budget`.`location` (`id_location`, `description`)
VALUES
(UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 'Itaú Unibanco'),
(UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 'Bradesco'),
(UUID_TO_BIN('8a1e3e8e-6a2e-4f3b-8e1e-3e8e6a2e4f3b'), 'Banco do Brasil'),
(UUID_TO_BIN('b2c3d4e5-f6a1-b2c3-d4e5-f6a1b2c3d4e5'), 'Caixa Econômica Federal'),
(UUID_TO_BIN('c3d4e5f6-a1b2-c3d4-e5f6-a1b2c3d4e5f6'), 'Santander'),
(UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 'BTG Pactual'),
(UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 'Nubank'),
(UUID_TO_BIN('f6a1b2c3-d4e5-f6a1-b2c3-d4e5f6a1b2c3'), 'Banco Inter'),
(UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 'XP Inc.');

-- Inserindo tipos de investimento (do mais conservador ao mais arriscado)
INSERT IGNORE INTO `budget`.`investment_type` (`id_investment_type`, `description`)
VALUES
-- Renda Fixa (Conservador)
(UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), 'Tesouro Selic'),
(UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), 'CDB / RDB'),
(UUID_TO_BIN('c3c3d4d4-e5e5-4f4f-8a8a-b2b2c3c3d4d4'), 'LCI / LCA'),
-- Multimercado (Moderado)
(UUID_TO_BIN('d4d4e5e5-f6f6-4a4a-8b8b-c3c3d4d4e5e5'), 'Fundos de Renda Fixa'),
(UUID_TO_BIN('e5e5f6f6-a1a1-4b4b-8c8c-d4d4e5e5f6f6'), 'Fundos Multimercado'),
(UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), 'Fundos Imobiliários (FIIs)'),
-- Renda Variável (Arriscado/Agressivo)
(UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), 'Ações'),
(UUID_TO_BIN('b3c4d5e6-f1a2-4b2c-8d3e-f4a5b6c7d8e9'), 'BDRs'),
(UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), 'Criptomoedas'),
(UUID_TO_BIN('d5e6f1a2-b3c4-4d4e-8f5a-b6c7d8e9f0a1'), 'Opções e Derivativos');

-- Inserindo investimentos de exemplo, combinando tipos e locais
-- Inserindo investimentos de exemplo com histórico mensal
-- Para cada investimento, são criados registros para o mês atual e os 3 meses anteriores,
-- simulando a evolução do saldo e do rendimento ao longo do tempo.

-- 1. Investimento Conservador no Itaú (Tesouro Selic)
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Mês atual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 15000.75, 150.00, NOW()),
-- 1 mês atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 14850.50, 148.00, DATE_SUB(NOW(), INTERVAL 1 MONTH)),
-- 2 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 14700.25, 147.00, DATE_SUB(NOW(), INTERVAL 2 MONTH)),
-- 3 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 14550.00, 145.00, DATE_SUB(NOW(), INTERVAL 3 MONTH));

-- 2. Fundo Imobiliário no Nubank
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Mês atual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 7500.50, 75.00, NOW()),
-- 1 mês atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 7425.00, 74.00, DATE_SUB(NOW(), INTERVAL 1 MONTH)),
-- 2 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 7350.80, 73.00, DATE_SUB(NOW(), INTERVAL 2 MONTH)),
-- 3 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 7280.00, 72.00, DATE_SUB(NOW(), INTERVAL 3 MONTH));

-- 3. Carteira de Ações na XP
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Mês atual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 22345.00, 223.00, NOW()),
-- 1 mês atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 22100.00, -50.00, DATE_SUB(NOW(), INTERVAL 1 MONTH)), -- Simulando uma pequena perda
-- 2 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 22150.50, 300.00, DATE_SUB(NOW(), INTERVAL 2 MONTH)),
-- 3 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 21850.00, 180.00, DATE_SUB(NOW(), INTERVAL 3 MONTH));

-- 4. Criptomoedas no BTG Pactual
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Mês atual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 5800.20, 580.00, NOW()),
-- 1 mês atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 5220.00, -200.00, DATE_SUB(NOW(), INTERVAL 1 MONTH)), -- Simulando volatilidade
-- 2 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 5420.00, 420.00, DATE_SUB(NOW(), INTERVAL 2 MONTH)),
-- 3 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 5000.00, 500.00, DATE_SUB(NOW(), INTERVAL 3 MONTH));

-- 5. CDB no Bradesco
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Mês atual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 31000.00, 310.00, NOW()),
-- 1 mês atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 30690.00, 306.00, DATE_SUB(NOW(), INTERVAL 1 MONTH)),
-- 2 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 30380.00, 303.00, DATE_SUB(NOW(), INTERVAL 2 MONTH)),
-- 3 meses atrás
(UUID_TO_BIN(UUID()), UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 30070.00, 300.00, DATE_SUB(NOW(), INTERVAL 3 MONTH));