
-- Criar DB

criar vemserdbc
use vemserdbc
db.createCollection("alunos")


db.alunos.insert(
    {
        "nome" : "Rafael Lazzari", 
        "data_nascimento" : new Date (1990,01,27)
    }
)

- FIND com navegação no documento

db.alunos.find()


-- Buscar

- FIND com navegação no documento

db.alunos.find().pretty()

db.alunos.find(
{ 
  "nome" : "Rafael"
}
).pretty()


// Ex
SELECT a.(*)
    FROM habilidades as h
    JOIN alunos as a ON a.id = h.aluno_id
    WHERE h.nome="inglês"
    AND a.nome = "Rafael";



db.alunos.find(
	{ 
	  "habilidades.nome": "inglês"
	}
)


-- FIND com OR e IN

db.alunos.find({
    "curso.nome" : "Sistemas de informação",
    "curso.nome" : "Engenharia Química"
})

db.alunos.find({
    "curso.nome" : "Sistemas de informação",
    "curso.nome" : "Engenharia Química",
    "curso.nome" : "Física"
})

db.alunos.find({

})


db.alunos.find({
     $or : [
        {"curso.nome" : "Física"},
        {"curso.nome" : "Ciência da computação"},
    ],
    "nome" : "Rafael"
 })

// Ex
SELECT * FROM cursos WHERE nome in ("Sistemas de informação", "Engenharia Química","Moda");

db.alunos.find({
    "curso.nome" : {
        $in : ["Ciência da computação", "Física"]
        }
})

db.alunos.find({ "status" : "X" })

