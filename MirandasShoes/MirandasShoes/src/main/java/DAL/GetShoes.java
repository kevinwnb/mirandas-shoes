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

/**
 *
 * @author Kevin
 */
public class GetShoes {

    MongoClient mongoClient = MongoClients.create();
    MongoDatabase db = mongoClient.getDatabase("MirandasShoes");
    MongoCollection<Document> collection = db.getCollection("Shoes");
    MongoCursor<Document> cursor = collection.find().iterator();

    public ArrayList<Shoe> shoeList = GetShoes(cursor);

    private ArrayList<Shoe> GetShoes(MongoCursor<Document> c) {
        ArrayList<Shoe> shoeList = new ArrayList<Shoe>();
        while (c.hasNext()) {
            Document doc = c.next();
            ArrayList<Object> shoe = new ArrayList<>(doc.values());
            Shoe s = new Shoe();
            s.setId(shoe.get(0).toString());
            s.setName(shoe.get(1).toString());
            s.setBrand(shoe.get(2).toString());
            s.setType(shoe.get(3).toString());
            s.setColor(shoe.get(4).toString());
            s.setSize((double) shoe.get(5));
            s.setPrice((double) shoe.get(6));
            shoeList.add(s);
        }
        return shoeList;//Get the shoes
    }
}
