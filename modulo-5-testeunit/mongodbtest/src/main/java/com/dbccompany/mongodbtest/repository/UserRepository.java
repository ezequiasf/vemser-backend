package com.dbccompany.mongodbtest.repository;

import com.dbccompany.mongodbtest.config.ConnectionMongo;
import com.dbccompany.mongodbtest.entity.UserEntity;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;


public class UserRepository {

    private final static String DATABASE = "recipes";
    private final static String COLLECTION = "users";
    public final static String URL = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";


    public void findById (BsonValue obj){
        MongoClient client = ConnectionMongo.createConnection(URL);

        Document doc = getCollectionUser(client).find(obj.asObjectId().asDocument()).first();

        System.out.println(doc.toJson());
        ConnectionMongo.closeConnection(client);
    }





    public String findBy(String field, String condition) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        String json = getCollectionUser(client).find(new Document(field, condition)).first().toJson();
        ConnectionMongo.closeConnection(client);
        return json;
    }

    public void aggregatingUser(Bson pipeline, Bson... options) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        List<Bson> aggregation = new ArrayList<>();
        aggregation.add(pipeline);
        aggregation.addAll(Arrays.asList(options));
        getCollectionUser(client).aggregate(aggregation).forEach(doc -> System.out.println(doc.toJson()));
        ConnectionMongo.closeConnection(client);
    }

    public void findAllProjection(String... fields) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        Bson projection = fields(Projections.include(fields), Projections.excludeId());
        FindIterable<Document> users = getCollectionUser(client).find().projection(projection);
        Iterator<Document> it = users.iterator();
        while (it.hasNext())
            System.out.println(it.next().toJson());
        ConnectionMongo.closeConnection(client);
    }

    public void saveUser(UserEntity user) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        getCollectionUser(client).insertOne(
                new Document("username", user.getUsername())
                        .append("email", user.getEmail())
                        .append("password", user.getPassword())
                        .append("role", user.getRole())
                        .append("isactive", user.isIsactive())
        );
        ConnectionMongo.closeConnection(client);
    }

    public void updateUser(String username, String attr, String value) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        getCollectionUser(client).updateOne(eq("username", username),
                new Document("$set", new Document(attr, value)));
        ConnectionMongo.closeConnection(client);
    }

    public void deleteUser(String username) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        getCollectionUser(client).deleteOne(eq("username", username));
        ConnectionMongo.closeConnection(client);
    }

    private MongoCollection<Document> getCollectionUser(MongoClient client) {
        return client.getDatabase(DATABASE).getCollection(COLLECTION);
    }

}
