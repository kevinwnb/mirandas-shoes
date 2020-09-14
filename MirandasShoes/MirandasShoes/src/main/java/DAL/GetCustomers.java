/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Customer;
import java.util.ArrayList;
import com.mongodb.*;
import com.mongodb.client.*;
import Models.Shoe;
import java.math.BigDecimal;
import org.bson.Document;

/**
 *
 * @author Kevin
 */
public class GetCustomers {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Customers");
    MongoCursor<Document> cursor = collection.find().iterator();

    public ArrayList<Customer> customerList = GetCustomers(cursor);

    public ArrayList<Customer> GetCustomers(MongoCursor<Document> cursor) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            Customer c = new Customer();
            c.setId(doc.get("_id").toString());
            c.setFirstName(doc.get("FirstName").toString());
            c.setLastName(doc.get("LastName").toString());
            c.setAddress(doc.get("Address").toString());
            c.setEmail(doc.get("Email").toString());
            c.setPhone(doc.get("Phone").toString());
            customerList.add(c);
        }
        return customerList;//Get the shoes
    }
}
