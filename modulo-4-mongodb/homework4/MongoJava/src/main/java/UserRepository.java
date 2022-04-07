import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;



public class UserRepository {

    private final static String DATABASE = "recipes";
    private final static String COLLECTION = "users";
    public final static String URL = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";

    public String findUser(String username) {
        MongoClient client = ConnectionMongo.createConnection(URL);
        String json = getCollectionUser(client).find(new Document("username", username)).first().toJson();
        ConnectionMongo.closeConnection(client);
        return json;
    }

    public void aggregatingUser (Bson pipeline, Bson... options){
        MongoClient client = ConnectionMongo.createConnection(URL);
        List<Bson> aggregation = new ArrayList<>();
        aggregation.add(pipeline);
        for (Bson opt: options)
            aggregation.add(opt);
        getCollectionUser(client).aggregate(aggregation).forEach(doc-> System.out.println(doc.toJson()));
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
