// Find Ordenado

db.recipes.find({
    preparetime: { $gte: 30 } 
}).sort("recipename")

db.recipes.find({ }).sort( { recipename : 1, price: -1 } )

db.users.find({ }).sort( "username" )

//Find Limite

db.users.find({ role: "ROLE_PREMIUM" }).sort( { _id : -1 } ).limit(2)

// Find Array

// Na ordem exata
db.recipes.find( { "ingredients": ["carne", "macaxeira", "manteiga"] } )

// Contém
db.recipes.find( { "ingredients": { $all: ["ovo", "leite"] } } )

// Condição múltipla, no array todo
db.recipes.find( { dim_cm: { $gt: 15, $lt: 20 } } )

// Condição múltipla, no mesmo elemento do array 
db.recipes.find( { dim_cm: { $elemMatch: { $gt: 22, $lt: 30 } } } )

// Usando índice do array
db.recipes.find( { "ingredients.1": "macaxeira" } )

// Tamanho
db.recipes.find( { "ingredients": { $size: 3 } } )

// Projections

db.recipes.find( {}, { _id: 0, recipename: 1, price: 1 } )

// Aggregate

db.recipes.aggregate( [
   { $match: { "ingredients": { $size: 3 } } },
   { $group: { _id: "$recipename", totalPrice: { $sum: "$price" } } }
] )
