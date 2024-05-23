INSERT INTO t_tipo_lancamento(id, descricao, idplanoconta, tipotransacao) 
SELECT * FROM (
    VALUES 
(1,'Vendas em Especie',1,'RECEITA'),
(2,'Vendas em Cartão Debito',1,'RECEITA'),
(3,'Vendas em Cartão 1x',1,'RECEITA'),
(4,'Vendas em Ifood',1,'RECEITA'),
(5,'Vendas em Cartão Parcelado',1,'RECEITA'),
(6,'Vendas em Pix',1,'RECEITA'),
(7,'Outras Receitas',1,'RECEITA'),
(8,'Taxas Adm. Pix',2,'DESPESA'),
(9,'Taxas Adm. Debito',2,'DESPESA'),
(10,'Taxas Adm. Credito 1x',2,'DESPESA'),
(11,'Taxas Adm. Ifood',2,'DESPESA'),
(12,'Taxas Descontos',2,'DESPESA'),
(13,'Taxas de Dif de Caixa',2,'DESPESA'),
(14,'Custo do Produto',3,'DESPESA'),
(15,'Custo do Licenciamento',3,'DESPESA'),
(16,'Comissão Vendas',3,'DESPESA'),
(17,'CAPAS',3,'DESPESA'),
(18,'Outros Custos',3,'DESPESA'),
(19,'Embalagem',4,'DESPESA'),
(20,'Frete',4,'DESPESA'),
(21,'Viagens Vendas e Outros',4,'DESPESA'),
(22,'Certificado Digital',4,'DESPESA'),
(23,'Cursos e Treinamentos',4,'DESPESA'),
(24,'Despesas com Cartorios',4,'DESPESA'),
(25,'Despesas com Correios',4,'DESPESA'),
(26,'Eventos',4,'DESPESA'),
(27,'Despesas com Viagens',4,'DESPESA'),
(28,'Despesas com Escritorio',4,'DESPESA'),
(29,'Taxa de Sonorização',4,'DESPESA'),
(30,'Compra de Equipamento',4,'DESPESA'),
(31,'Sócios Alimentação',4,'DESPESA'),
(32,'Entregador',4,'DESPESA'),
(33,'Suprimentos - Cartão Empre.',4,'DESPESA'),
(34,'Alvara',4,'DESPESA'),
(35,'IPTU',4,'DESPESA'),
(36,'Manutenção Computadores',4,'DESPESA'),
(37,'Manutenção Predial serviço',4,'DESPESA'),
(38,'Equipamentos',4,'DESPESA'),
(39,'Manutenção Predial Material',4,'DESPESA'),
(40,'Material Copa, Cozinha, Higiene',4,'DESPESA'),
(41,'Material de Expediente',4,'DESPESA'),
(42,'Seguro Imovel/ Veiculo',4,'DESPESA'),
(43,'Despesa Balanço',4,'DESPESA'),
(44,'Reembolso Debito',4,'DESPESA'),
(45,'Marketing e Divulgação',5,'DESPESA'),
(46,'Advogado',5,'DESPESA'),
(47,'Energia ',5,'DESPESA'),
(48,'Água',5,'DESPESA'),
(49,'Aluguel',5,'DESPESA'),
(50,'Assinatura',5,'DESPESA'),
(51,'Consultoria e Assessoria',5,'DESPESA'),
(52,'Contador',5,'DESPESA'),
(53,'Locação - Escritorio',5,'DESPESA'),
(54,'Telefonia',5,'DESPESA'),
(55,'Luva',5,'DESPESA'),
(56,'TI sistemas',5,'DESPESA'),
(57,'Condominio',5,'DESPESA'),
(58,'Fundo de Promoção',5,'DESPESA'),
(59,'Dominio Internet',5,'DESPESA'),
(60,'Custo Implantação',5,'DESPESA'),
(61,'Tarifa Bancaria DOC/TED/PIX',6,'DESPESA'),
(62,'Tarifa Bancaria (MANUT)',6,'DESPESA'),
(63,'Tarifa Cartão empresarial',6,'DESPESA'),
(64,'Seguradora',6,'DESPESA'),
(65,'Emprestimo BNB PRINCIPAL',6,'DESPESA'),
(66,'Emprestimo BNB ENCARGOS',6,'DESPESA'),
(67,'Emprestimo BNB',6,'DESPESA'),
(68,'Contribuição Sindical',7,'DESPESA'),
(69,'Treinamento',7,'DESPESA'),
(70,'Folha de Pagamento',7,'DESPESA'),
(71,'Exame Medico',7,'DESPESA'),
(72,'Fardamento',7,'DESPESA'),
(73,'Pro- Labore',7,'DESPESA'),
(74,'FGTS',7,'DESPESA'),
(75,'Encargos Previdenciarios',7,'DESPESA'),
(76,'Encargos Rescisorios',7,'DESPESA'),
(77,'Beneficio Social',7,'DESPESA'),
(78,'Domingos /Feriados',7,'DESPESA'),
(79,'Eventos ',7,'DESPESA'),
(80,'Alimentação/COMBUSTIVEL',7,'DESPESA'),
(81,'Transporte',7,'DESPESA'),
(82,'INSS',7,'DESPESA'),
(83,'Gratificação',7,'DESPESA'),
(84,'Estagio',7,'DESPESA'),
(85,'Rescisão',7,'DESPESA'),
(86,'Férias',7,'DESPESA'),
(87,'Simples Nacional',8,'DESPESA'),
(88,'ICMS Fronteira Antecipado',8,'DESPESA'),
(89,'ICMS Fronteira',8,'DESPESA'),
(90,'Simples Parcelado',8,'DESPESA')
) AS data(id, descricao, idplanoconta, tipotransacao)
WHERE NOT EXISTS (
    SELECT 1 FROM t_tipo_lancamento where t_tipo_lancamento.id = data.id
);