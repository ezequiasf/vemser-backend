-- Criação da tabela

CREATE TABLE VEM_SER.ESTUDANTE (
	id_estudante NUMBER(6) NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY	(id_estudante)
);

-- Sequence

CREATE SEQUENCE VEM_SER.seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_estudante_matricula
START WITH 1000
INCREMENT BY 1
NOCACHE NOCYCLE;

-- Inserção de dados


INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'Genival Lacerda', TO_DATE('08-09-1991', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval , 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES 	(VEM_SER.seq_estudante.nextval, 'Cláudio Rodrigues', TO_DATE('09-10-1995', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'N');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Jana Lopes', TO_DATE('14-01-1993', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Manoel Estevam', TO_DATE('01-09-1990', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Marcos Roberto', TO_DATE('07-04-1996', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Thalita Marcela', TO_DATE('17-05-1991', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Alexsandra Silva', TO_DATE('25-11-1992', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
	
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Kássio Barros', TO_DATE('04-08-1994', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
	
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Marcela Silva', TO_DATE('08-10-1991', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Miguel Araújo', TO_DATE('11-02-1993', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');


-- Consulta simples
	
SELECT * FROM VEM_SER.ESTUDANTE;

-- Consulta específica 

SELECT NOME, DATA_NASCIMENTO AS Nascimento, NR_MATRICULA AS Matricula FROM VEM_SER.ESTUDANTE;

-- Concatenação

SELECT NOME, NR_MATRICULA || ' - ' || ATIVO AS "SITUAÇÃO" FROM VEM_SER.ESTUDANTE;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		