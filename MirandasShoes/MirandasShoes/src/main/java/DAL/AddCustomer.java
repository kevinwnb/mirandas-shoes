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
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Kevin
 */
public class AddCustomer {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Customers");
    MongoCursor<Document> cursor = collection.find().iterator();

    public void AddCustomer(Customer c) {
        Document doc = new Document();
        doc.append("FirstName", c.getFirstName());
        doc.append("LastName", c.getLastName());
        doc.append("Address", c.getAddress());
        doc.append("Email", c.getEmail());
        doc.append("Phone", c.getPhone());
        this.collection.insertOne(doc);
        JOptionPane.showMessageDialog(null, "Customer insert was successful");
    }
}
