//Criação da collection users 
//Uso da função db.users.insertMany()
db.users.insertMany([
	{
		"username" : "flaviosobrinho",
		"password" : "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
		"email" : "flavio@gmail.com",
		"isactive" : true,
	},
	{
		"username" : "ezeq21",
		"password" : "$2a$10$TZ3RaSkBh3u5LTomUF7sM.zJcUcu4QAKhj5dF1UmZ5Bnr35GjJtZ.",
		"email" : "ezequias@gmail.com",
			"isactive" : true,
	},
	{
		"username" : "carlosalm",
		"password" : "$2a$10$.P7v9IHm61IX8Fut2K9\/RuTX3Pi6fN4uZso0Shl2tNjulb7Em7gz.",
		"email" : "teste@gmail.com",
		"isactive" : false,
	},
	{
		"username" : "maicon23",
		"password" : "$2a$10$Sji0vFz3Q6ouzudYBFqRc.1jSHJdmRSogkCLL1lV5i.N9bFyzjaF2",
		"email" : "string@gmail.com",
		"isactive" : true,
	}
])

//inserção da collection de receitas
db.recipes.insertMany([
	{
		"recipename" : "Pão com ovo",
		"image" : "",
		"preparerecipe" : "Lorem Ipsum is simply dummy text of the printing",
		"preparetime" : 12,
		"price" : 10.43,
		"calories" : 3241.00,
		"userid" : 3,
		"ingredients":["pão", "ovo"]
	},
	{
		"recipename" : "Camarão com leite",
		"image" : "",
		"preparerecipe" : "Lorem Ipsum is simply dummy text of the printing",
		"preparetime" : 15,
		"price" : 32.43,
		"calories" : 321.00,
		"userid" : 1,
		"ingredients":["camarão", "leite de côco"]
	},
	{
		"recipename" : "Ovo com queijo",
		"image" : "",
		"preparerecipe" : "Lorem Ipsum is simply dummy text of the printing",
		"preparetime" : 32,
		"price" : 12.45,
		"calories" : 213.00,
		"userid" : 1,
		"ingredients":["ovo", "queijo"]
	}
])


//Encontrar todos
db.users.find().pretty()

//Encontrar apenas o especificado
db.users.find(
{ 
  "username" : "maicon23"
}
).pretty()

//clausula ou 

db.users.find({
    $or : [
        {"username" : "maicon23"},
        {"isactive": true}    
    ]
}).pretty()

// usando o IN

db.recipes.find({
    "ingredients" : {
        $in : ["ovo", "camarão"]
        }
})