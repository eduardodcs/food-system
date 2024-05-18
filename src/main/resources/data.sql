-- CARGA DE LANCHES
INSERT INTO LANCHE (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'X Bacon', 'Pão, hambuguer, bacon, queijo', 29.9, true WHERE 'X Bacon' NOT IN (SELECT NOME FROM LANCHE)
INSERT INTO LANCHE (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'X Salada', 'Pão, hambuguer, alface, tomate', 21.9, true WHERE 'X Salada' NOT IN (SELECT NOME FROM LANCHE)
INSERT INTO LANCHE (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'X Egg', 'Pão, hambuguer, queijo, queijo', 23.9, true WHERE 'X Egg' NOT IN (SELECT NOME FROM LANCHE)
INSERT INTO LANCHE (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'X Frango', 'Pão, frango, alface, queijo', 25.9, true WHERE 'X Frango' NOT IN (SELECT NOME FROM LANCHE)


-- CARGA DE SOBREMESA
INSERT INTO SOBREMESA (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'Banana flambada', 'Deliciosa banada caramelizada com sorvete de creme', 18.50, true WHERE 'Banana flambada' NOT IN (SELECT NOME FROM SOBREMESA)
INSERT INTO SOBREMESA (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'Açai da casa', 'Açaí com banana, leite ninho e mel', 21.0, true WHERE 'Açai da casa' NOT IN (SELECT NOME FROM SOBREMESA)
INSERT INTO SOBREMESA (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'Torta alemã', 'Maravilhosa torta com o toque especial da casa', 18.50, true WHERE 'Torta alemã' NOT IN (SELECT NOME FROM SOBREMESA)
INSERT INTO SOBREMESA (NOME, DESCRICAO, PRECO, STATUS_ATIVO) SELECT 'Mousse de limão', 'A sobremesa mais queridinha depois da refeição', 18.50, true WHERE 'Mousse de limão' NOT IN (SELECT NOME FROM SOBREMESA)