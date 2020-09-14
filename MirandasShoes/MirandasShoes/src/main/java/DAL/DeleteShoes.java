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
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Kevin
 */
public class DeleteShoes {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Shoes");
    MongoCursor<Document> cursor = collection.find().iterator();

    public void DeleteShoe(ArrayList<Shoe> shoesToDelete) {
        for (Shoe s : shoesToDelete) {
            this.collection.deleteOne(new Document("_id", new ObjectId(s.getId())));
        }
    }
}
