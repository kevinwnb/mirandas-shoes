/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Models.Purchase;
import java.util.ArrayList;
import com.mongodb.*;
import com.mongodb.client.*;
import Models.Shoe;
import java.math.BigDecimal;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Kevin
 */
public class AddPurchase {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collectionShoes = db.getCollection("Shoes");
    MongoCollection<Document> collection = db.getCollection("Purchases");
    MongoCursor<Document> cursor = collection.find().iterator();

    public void AddPurchase(ArrayList<Purchase> purchases) {
        for (Purchase p : purchases) {
            Document doc = new Document();
            doc.append("ShoeID", p.getShoeID());
            doc.append("Customer", p.getCustomer());
            doc.append("Total", p.getTotal());
            this.collection.insertOne(doc);
            this.collectionShoes.deleteOne(new Document("_id", new ObjectId(p.getShoeID())));
        }
    }
}
