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
INSERT IGNORE INTO `budget`.`investment` (`id_investment`, `id_investment_type`, `id_location`, `balance`, `month_revenue`, `last_update_date`)
VALUES
-- Investimento Conservador no Itaú
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a1a1b2b2-c3c3-4d4d-8e8e-f0f0a1a1b2b2'), UUID_TO_BIN('1e695212-3559-444b-98b7-1165a3356e4a'), 15000.75,150.00, NOW()),

-- Fundo Imobiliário no Nubank
(UUID_TO_BIN(UUID()), UUID_TO_BIN('f6f6a1a1-b2b2-4c4c-8d8d-e5e5f6f6a1a1'), UUID_TO_BIN('e5f6a1b2-c3d4-e5f6-a1b2-c3d4e5f6a1b2'), 7500.50,75.00, NOW()),

-- Carteira de Ações na XP
(UUID_TO_BIN(UUID()), UUID_TO_BIN('a2b2c3d4-e5f6-4a1b-8c2d-e3f4a5b6c7d8'), UUID_TO_BIN('a2b3c4d5-e6f1-a2b3-c4d5-e6f1a2b3c4d5'), 22345.00,223.00, NOW()),

-- Criptomoedas no BTG Pactual
(UUID_TO_BIN(UUID()), UUID_TO_BIN('c4d5e6f1-a2b3-4c3d-8e4f-a5b6c7d8e9f0'), UUID_TO_BIN('d4e5f6a1-b2c3-d4e5-f6a1-b2c3d4e5f6a1'), 5800.20,58.00, NOW()),

-- CDB no Bradesco
(UUID_TO_BIN(UUID()), UUID_TO_BIN('b2b2c3c3-d4d4-4e4e-8f8f-a1a1b2b2c3c3'), UUID_TO_BIN('f4a2e82c-642d-4b17-bb0e-27b58f6a8b5a'), 31000.00,310.00, NOW());