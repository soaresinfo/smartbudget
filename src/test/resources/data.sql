insert ignore into budget.expense (id_expense, planned_value, description)
values
(UUID_TO_BIN('c96adcca-00d5-49da-9261-dcbd0156d064'), 0, 'Supermercado'),
(UUID_TO_BIN('35712e6d-48bd-4b98-aa4b-5924d71462b5'), 0, 'Entretenimento'),
(UUID_TO_BIN('c91d30f7-d16e-4ef7-bdde-69827f73c319'), 0, 'Transporte'),
(UUID_TO_BIN('d117c5b6-3af7-4f75-96b9-ce64386d48c1'), 0, 'Saúde'),
(UUID_TO_BIN('5e6c1734-9e11-4eae-ba77-8fb75fce559c'), 0, 'Fastfood'),
(UUID_TO_BIN('6a70131a-ba75-4031-b47b-bb0ea34dd9ff'), 0, 'Contas utilidade pública'),
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