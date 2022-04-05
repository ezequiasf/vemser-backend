
-- Criar DB

criar vemserdbc
use vemserdbc
db.createCollection("alunos")

-- Inserir

db.alunos.insert(
    {
        "nome" : "Rafael Lazzari", 
        "DATA_NASCIMENTO" : ISODate( new Date (1990,01,27)
    }
)

-- Remover

db.alunos.remove({ "_id" : ObjectId ("56cb0002b6d75ec12f75d3b5") } )


-- Buscar

- FIND com navegação no documento

db.alunos.find()


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
    $or : [
        {"curso.nome" : "Sistemas de informação"},
        {"curso.nome" : "Artes"}    
    ]
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



------- HW

db.alunos.find({ "status" : "X" })

// Resultado:

{ _id: ObjectId("619c6798f348a5a68d29db15"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  curso: { nome: 'Ciência da computação' },
  notas: [ 10, 9, 7.5 ],
  habilidades: 
   [ { nome: 'inglês', 'nível': 'avançado' },
     { nome: 'jogatina', 'nível': 'intermediário' } ],
  status: 'X' }
{ _id: ObjectId("624b46cc0c78ca8a81b18d0b"),
  nome: 'Rafael',
  data_nascimento: 1994-02-27T03:00:00.000Z,
  idade: 27,
  status: 'X' }



------------
-- Aula 2 --
------------


---- Insert One
db.alunos.insertOne(
{  
  "nome": "Rafael",
  "data_nascimento": new Date (1994,01,27), 
  "idade": 27,
  "curso": {
    "nome": "Ciência da computação"
  },
  "notas": [10.0, 9.0, 7.5],
  "habilidades": [
    {
      "nome": "inglês",
      "nível": "avançado"
    },
    {
      "nome": "jogatina",
      "nível": "intermediário"
    }
  ],
  "status": "A"
})


db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])

---- Delete
db.alunos.deleteOne( { nome: "Rafael", idade: 25 } )
db.alunos.deleteMany({}) // deleta todos documentos


---- Find Equal
{ <field1>: <value1>, ... }
{ status: "D" }

// Ex
SELECT * FROM alunos WHERE status = "D"

db.alunos.find({
    "status": "D"
})

db.alunos.find({
    "habilidades": {nome: "jogatina", "nível": "avançado"}
})


---- Find AND
{ status: "A", idade: { $lt: 25 } }

SELECT * FROM alunos WHERE status = "A" AND idade < 25

db.alunos.find({
    status: "A", 
    idade: { $lt: 25 }
})


---- Find OR / IN
{ <field1>: { <operator1>: <value1> }, ... }
{ status: { $in: [ "A", "D" ] } }

SELECT * FROM alunos WHERE status in ("A", "D")


db.alunos.find({
    $or : [
        {"curso.nome" : "Ciência da computação"},
        {"curso.nome" : "Física"},
        {"curso.nome" : "Artes"}
    ],
    "nome" : "Ana"
 })


---- Find Expressão
{ nome: /^Ra/ } 

SELECT * FROM alunos WHERE nome LIKE "Ra%")

db.alunos.find({
    "nome": /^Ra/ 
})


---- Find Campos aninhados
{"curso.nome" : "Física"}

db.alunos.find({
   "curso.nome" : "Física"
})

db.alunos.find({
   "notas.2" : 9.5
})


---- Update
{
  <update operator>: { <field1>: <value1>, ... },
  <update operator>: { <field2>: <value2>, ... },
  ...
}

db.alunos.updateOne(
   { nome: "Rafael" },
   {
     $set: { "nome": "Rafael", status: "Z" }           
   }
)


------------
-- Aula 3 --
------------

---- Insert Many
db.alunos.insertMany([
  { "nome": "Rafael", "data_nascimento": new Date (1994,01,27), "idade": 27, "curso": { "nome": "Ciência da computação" }, "notas": [10.0, 9.0, 7.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "intermediário" } ], "status": "A"},
  { "nome": "Miguel", "data_nascimento": new Date (1993,01,27), "idade": 26, "curso": { "nome": "Artes" }, "notas": [8.0, 9.0, 2.5], "habilidades": [ {  "nome": "inglês",  "nível": "básico" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"},
  { "nome": "Gabriel", "data_nascimento": new Date (1992,01,27), "idade": 25, "curso": { "nome": "Matemática" }, "notas": [8.0, 10.0, 6.5], "habilidades": [ {  "nome": "inglês",  "nível": "avançado" }, {  "nome": "jogatina",  "nível": "básico" } ], "status": "I"},
  { "nome": "Ana", "data_nascimento": new Date (1990,01,27), "idade": 23, "curso": { "nome": "Física" }, "notas": [8.0, 9.0, 9.5], "habilidades": [ {  "nome": "inglês",  "nível": "intermediário" }, {  "nome": "jogatina",  "nível": "avançado" } ], "status": "A"}
])

---- Find Ordenado

db.alunos.find({
    notas: { $gte: 9 } 
}).sort("nome")


db.alunos.find({ }).sort( { idade : 1, status: -1 } )


db.alunos.insertMany([
{ "_id" : 1, "nome" : "aaa", "status" : "ID" },
{ "_id" : 2, "nome" : "bbb", "status" : "ID" },
{ "_id" : 3, "nome" : "ccc", "status" : "ID" },
{ "_id" : 5, "nome" : "ddd", "status" : "ID" },
{ "_id" : 4, "nome" : "eee", "status" : "ID" }
])


db.alunos.find({ }).sort( { _id : 1 } )

db.alunos.find({ status: "ID" }).sort( { _id : 1 } )

db.alunos.deleteMany({ _id : { $lte : 5} })

---- Find Limite

db.alunos.find({ status: "ID" }).sort( { _id : -1 } ).limit(3)


---- Find Array

// Busca nos elementos do array
db.alunos.find({
    notas: { $lt: 4 } 
})


-- produtos

db.inventory.insertMany([
   { item: "journal", qty: 25, tags: ["blank", "red"], dim_cm: [ 14, 21 ] },
   { item: "notebook", qty: 50, tags: ["red", "blank"], dim_cm: [ 14, 21 ] },
   { item: "paper", qty: 100, tags: ["red", "blank", "plain"], dim_cm: [ 14, 21 ] },
   { item: "planner", qty: 75, tags: ["blank", "red"], dim_cm: [ 22.85, 30 ] },
   { item: "postcard", qty: 45, tags: ["blue"], dim_cm: [ 10, 15.25 ] }
]);


// Na ordem exata
db.inventory.find( { tags: ["red", "blank"] } )

// Contém
db.inventory.find( { tags: { $all: ["red", "blank"] } } )

db.inventory.find( { tags: "red" } )

db.inventory.find( { dim_cm: { $gt: 25 } } )

// Condição múltipla, no array todo
db.inventory.find( { dim_cm: { $gt: 15, $lt: 20 } } )

// Condição múltipla, no mesmo elemento do array 
db.inventory.find( { dim_cm: { $elemMatch: { $gt: 22, $lt: 30 } } } )

// Usando índice do array, segundo elem > 25
db.inventory.find( { "dim_cm.1": { $gt: 25 } } )

// Tamanho
db.inventory.find( { "tags": { $size: 3 } } )



---- Projections

// Limpar a collection
db.inventory.deleteMany({ })

// Popular a collection
db.inventory.insertMany( [
  { item: "journal", status: "A", size: { h: 14, w: 21, uom: "cm" }, instock: [ { warehouse: "A", qty: 5 } ] },
  { item: "notebook", status: "A",  size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "C", qty: 5 } ] },
  { item: "paper", status: "D", size: { h: 8.5, w: 11, uom: "in" }, instock: [ { warehouse: "A", qty: 60 } ] },
  { item: "planner", status: "D", size: { h: 22.85, w: 30, uom: "cm" }, instock: [ { warehouse: "A", qty: 40 } ] },
  { item: "postcard", status: "A", size: { h: 10, w: 15.25, uom: "cm" }, instock: [ { warehouse: "B", qty: 15 }, { warehouse: "C", qty: 35 } ] }
]);


db.inventory.find( {}, { _id: 0, item: 1, "size.uom": 1 } )


---- Aggregate

db.orders.insertMany( [
   { _id: 0, productName: "Steel beam", status: "new", quantity: 10 },
   { _id: 1, productName: "Steel beam", status: "urgent", quantity: 20 },
   { _id: 2, productName: "Steel beam", status: "urgent", quantity: 30 },
   { _id: 3, productName: "Iron rod", status: "new", quantity: 15 },
   { _id: 4, productName: "Iron rod", status: "urgent", quantity: 50 },
   { _id: 5, productName: "Iron rod", status: "urgent", quantity: 10 }
] )

// urgentes
db.orders.aggregate( [
   { $match: { status: "urgent" } },
   { $group: { _id: "$productName", qtd: { $sum: "$quantity" } } }
] )

