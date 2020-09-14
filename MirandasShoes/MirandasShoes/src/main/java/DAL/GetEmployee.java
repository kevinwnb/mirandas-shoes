/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Employee;
import Models.Shoe;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Kevin
 */
public class GetEmployee {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Employees");

    public Employee getEmployee(String username, String password) throws Exception {
        FindIterable<Document> findIterable = collection.find(new Document("Username", username).append("Password", password));
        MongoCursor<Document> cursor = findIterable.iterator();
        Employee e = new Employee();
        if (cursor.hasNext()) {
            Document doc = cursor.next();
            //ArrayList<Object> o = new ArrayList<>(doc.values());
            e.setId(doc.get("_id").toString());
            e.setName(doc.get("Name").toString());
            e.setAddress(doc.get("Address").toString());
            e.setEmail(doc.get("Email").toString());
            e.setPhone(doc.get("Phone").toString());
            e.setUsername(doc.get("Username").toString());
            e.setPassword(doc.get("Password").toString());
            return e;//Get the shoes
        }
        else{
            throw new Exception("Login failed");
        }
    }
}
