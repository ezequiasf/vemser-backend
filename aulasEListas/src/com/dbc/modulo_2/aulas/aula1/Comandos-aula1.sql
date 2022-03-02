--Cria a tabela vem ser
--CREATE TABLE VEM_SER.PESSOA (
--id_pessoa NUMBER NOT NULL,
--nome VARCHAR2(255) NOT NULL,
--data_nascimento DATE NOT NULL,
--telefone VARCHAR2(14), -- +5551995249346
--idade NUMBER(3) NOT NULL,
--altura DECIMAL(4,2) NOT NULL,
--cpf CHAR(11) UNIQUE NOT NULL,
--PRIMARY KEY(id_pessoa)
--);

--Cria a sequência ou incremento da tabela
--CREATE SEQUENCE seq_pessoa
--START WITH 1
--INCREMENT BY 1
--NOCACHE NOCYCLE;

--INSERT INTO VEM_SER.PESSOA (ID_PESSOA, NOME, DATA_NASCIMENTO, TELEFONE, IDADE, ALTURA, CPF)
--VALUES(SEQ_PESSOA.nextval, 'Maicon Machado Gerardi', TO_DATE('08-09-1991', 'dd-mm-yyyy'), '519958654566', 30, 1.75, '50799501026');

--SELECT * FROM vem_ser.PESSOA

--SELECT ID_PESSOA
--	   , CPF
--	  , NOME 
--	 FROM VEM_SER.PESSOA;

--SELECT ID_PESSOA  ,    CPF || ' - ' ||   NOME   AS   "NOME do campo"
--FROM VEM_SER.PESSOA; 
	

