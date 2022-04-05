//Criação da collection users 
//Uso da função db.users.insertMany()

db.users.insertMany([
{
	"username" : "flaviosobrinho",
	"password" : "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
	"email" : "flavio@gmail.com",
	"isactive" : true,
	"role": "ROLE_STANDARD",
	"recipesCreated":[]
}
,
{
	"username" : "ezeq_ferreira",
	"password" : "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
	"email" : "ezeq@gmail.com",
	"isactive" : false,
	"role": "ROLE_PREMIUM",
	"recipesCreated":
	[
		{			
			"recipename":"Camarão no alho e óleo",
			"image":"",
			"preparerecipe":"Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 32,
			"price": 15.67,
			"calories": 1256,
			"ingredients":["camarão", "alho", "óleo"],
			"classification":
			[
				{
					"userid": "",
					"stars": 5,
					"coment": "Lorem Ipsum is simply dummy text of the printing"
				}
			]
		}
	]
}
,
{
	"username" : "maic321",
	"password" : "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
	"email" : "maicon@gmail.com",
	"isactive" : true,
	"role": "ROLE_PREMIUM",
	"recipesCreated":
	[
		{			
			"recipename":"Bolinho de chuva",
			"image":"",
			"preparerecipe":"Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 43,
			"price": 32.32,
			"calories": 1234,
			"ingredients":["ovo", "leite", "manteiga", "açucar"],
			"classification":
			[
				{
					"userid": "",
					"stars": 3.7,
					"coment": "Lorem Ipsum is simply dummy text of the printing"
				}
			]
		},
		{			
			"recipename":"Acarajé",
			"image":"",
			"preparerecipe":"Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 132,
			"price": 24.56,
			"calories": 2500,
			"ingredients":["ovo", "camarão", "óleo de dênde", "feijão"],
			"classification":
			[
				{
					"userid": "",
					"stars": 4.6,
					"coment": "Lorem Ipsum is simply dummy text of the printing"
				}
			]
		}
	]
}])

//Encontrar todos
db.users.find().pretty()

//Encontrar apenas o especificado
db.users.find(
{ 
  "username" : "maic321"
}
).pretty()

//clausula ou 

db.users.find({
    $or : [
        {"username" : "maic231"},
        {"isactive": true}    
    ]
}).pretty()

// usando o IN

db.users.find({
    "recipesCreated.ingredients" : {
        $in : ["ovo", "camarão"]
        }
})