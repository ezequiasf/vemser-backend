//Comandos aprendidos na aula 2
db.users.deleteMany({})

db.users.insertMany(
	[
		{
			"username": "flaviosobrinho",
			"password": "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
			"email": "flavio@gmail.com",
			"isactive": true,
			"role": "ROLE_STANDARD",
		}
		,
		{
			"username": "ezeq_ferreira",
			"password": "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
			"email": "ezeq@gmail.com",
			"isactive": false,
			"role": "ROLE_PREMIUM",
		}
		,
		{
			"username": "maic321",
			"password": "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
			"email": "maicon@gmail.com",
			"isactive": true,
			"role": "ROLE_PREMIUM",
		}
	]
)

db.recipes.insertMany(
	[
		{	"author": "ezeq_ferreira",
			"recipename": "Camarão no alho e óleo",
			"image": "",
			"preparerecipe": "Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 32,
			"price": 12.37,
			"calories": 2234,
			"ingredients": ["camarão", "alho", "óleo"],
			"classification":
				[
					{
						"userid": "",
						"stars": 3.7,
						"coment": "Lorem Ipsum is simply dummy text of the printing"
					}
				]
		}
		,
		{	"author": "maic321",
			"recipename": "Carne de sol",
			"image": "",
			"preparerecipe": "Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 21,
			"price": 17.98,
			"calories": 1243,
			"ingredients": ["carne", "macaxeira", "manteiga"],
			"classification":
				[
					{
						"userid": "",
						"stars": 3.7,
						"coment": "Lorem Ipsum is simply dummy text of the printing"
					}
				]
		}
		,
		{	"author": "maic321",
			"recipename": "Bolinho de chuva",
			"image": "",
			"preparerecipe": "Lorem Ipsum is simply dummy text of the printing",
			"preparetime": 43,
			"price": 17.65,
			"calories": 543,
			"ingredients": ["ovo", "leite", "manteiga", "açucar"],
			"classification":
				[
					{
						"userid": "",
						"stars": 3.7,
						"coment": "Lorem Ipsum is simply dummy text of the printing"
					}
				]
		}
	]
)


//Insert one
db.users.insertOne
({
	"username": "zedasquantas",
	"password": "$2a$10$wex6tSCNcfd2m.LGkhnTIunv7eVk7JSrjBmM\/o9rFec.QfZ\/6Lltm",
	"email": "zezin@gmail.com",
	"isactive": true,
	"role": "ROLE_PREMIUM",
})

db.recipes.insertOne
({
	"username": "zedasquantas",
	"recipename": "Morango ao leite",
	"image": "",
	"preparerecipe": "Lorem Ipsum is simply dummy text of the printing",
	"preparetime": 45,
	"price": 13.11,
	"calories": 1287,
	"ingredients": ["morango", "creme de leite", "açucar"],
	"classification":
		[
			{
				"userid": "",
				"stars": 2.4,
				"coment": "Lorem Ipsum is simply dummy text of the printing"
			}
		]
})


//Delete 
db.users.deleteOne( { username: "ana_lucia" } )
db.users.deleteOne( { username: "klebin12" } )


//Find equal 

db.users.find({
    "role": "ROLE_PREMIUM"
})

db.recipes.find({
    "recipename": "Carne de sol"
})


//Find AND

db.users.find({
	"isactive": true,
    "role": "ROLE_STANDARD"
})

db.recipes.find({
	"price": {$lt:15},
    "preparetime": {$gt:20}
})

//OR e AND JUNTOS

db.users.find
({
    $or : 
	[
        {"isactive" : false},
        {"username" : "zedasquantas"},
	],
    "role" : "ROLE_PREMIUM"
 })

db.recipes.find
({
    $or : 
	[
        {"recipename" : "Carne de sol"},
        {"recipename" : "Bolinho de chuva"}
    ],
    "price" : {$gte:13}
 })

// Uso de regex

db.users.find({
    "username": /^ze/ 
})

db.recipes.find({
    "recipename": /^Ca/ 
})

// Find Campos aninhados

db.recipes.find({
   "ingredients.0" : "camarão"
})

db.recipes.find({
   "ingredients.1" : "macaxeira"
})

//UPDATE

db.users.updateOne(
   { username: "maic321" },
   {
     $set: { "isactive": false }           
   }
)

db.recipes.updateOne(
   { recipename: "Morango ao leite" },
   {
     $set: { "preparetime": 33 }           
   }
)


