/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

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
public class AddShoe {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Shoes");
    MongoCursor<Document> cursor = collection.find().iterator();

    public void AddShoe(Shoe s) {
        Document doc = new Document();
        doc.append("Name", s.getName());
        doc.append("Brand", s.getBrand());
        doc.append("Type", s.getType());
        doc.append("Color", s.getColor());
        doc.append("Size", s.getSize());
        doc.append("Price", s.getPrice());
        this.collection.insertOne(doc);
        JOptionPane.showMessageDialog(null, "Shoe insert was successful");
    }
}
