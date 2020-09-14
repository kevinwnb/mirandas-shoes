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
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Kevin
 */
public class UpdateShoe {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Shoes");

    public void UpdateShoe(Shoe sfilter, Shoe snew) {
        Document sfilterdoc = new Document("_id", new ObjectId(sfilter.getId()));
        //sfilterdoc.append("_id", new ObjectId(sfilter.getId()));
//        sfilterdoc.append("Name", sfilter.getName());
//        sfilterdoc.append("Brand", sfilter.getBrand());
//        sfilterdoc.append("Type", sfilter.getType());
//        sfilterdoc.append("Color", sfilter.getColor());
//        sfilterdoc.append("Size", sfilter.getSize());
//        sfilterdoc.append("Price", sfilter.getPrice());

        Document snewdoc = new Document();
        snewdoc.append("Name", snew.getName());
        snewdoc.append("Brand", snew.getBrand());
        snewdoc.append("Type", snew.getType());
        snewdoc.append("Color", snew.getColor());
        snewdoc.append("Size", snew.getSize());
        snewdoc.append("Price", snew.getPrice());
        
        Document updateDoc = new Document("$set", snewdoc);
        this.collection.updateOne(sfilterdoc, updateDoc);
        JOptionPane.showMessageDialog(null, "Shoe update was successful");
    }
}
