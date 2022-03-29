-- ============================ HOMEWORK 2 =====================
SELECT * FROM ENDERECO e;

--1 Selecionar todos os países ordenados por nome decrescente
SELECT * FROM PAIS ORDER BY NOME DESC; 

/*2 Selecionar logradouro e cep dos endereços. Porém, somente os logradouros 
que comecem com a letra ‘a’ (maiúsculo ou minúsculo)*/
SELECT LOGRADOURO, CEP FROM ENDERECO e 
WHERE UPPER(LOGRADOURO) LIKE 'A%';

--3 Selecionar todos os endereços que tenham cep com final ‘0’
SELECT * FROM ENDERECO WHERE CEP LIKE '%0';

--4 Selecionar todos os endereços que tenham números entre 1 e 100
SELECT * FROM ENDERECO WHERE NUMERO BETWEEN 1 AND 100;

/* 5 Selecionar todos os endereços que comecem por “RUA” 
e ordenar pelo cep de forma decrescente */
SELECT * FROM ENDERECO WHERE UPPER(LOGRADOURO) LIKE 'RUA%'
ORDER BY CEP DESC 

--6 Selecionar a quantidade de endereços cadastrados na tabela
SELECT COUNT(*) AS "NÚMERO DE ENDEREÇOS" FROM ENDERECO e;

--7 Selecionar a quantidade de endereços cadastrados agrupados pelo id da cidade
SELECT B.ID_CIDADE, COUNT(*) AS "ENDEREÇOS" FROM ENDERECO E INNER JOIN 
BAIRRO B ON E.ID_BAIRRO = B.ID_BAIRRO
GROUP BY ID_CIDADE;


























