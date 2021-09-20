package com.boot.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class PojoPersister {

    /*
    To be used when it is necessary to avoid JSON serialization/deserialization
     */

    @Value("${spring.data.mongodb.uri}")
    String mongoDbUri;

    private MongoCollection<PojoPersister> collection;

    public PojoPersister(){}

    public PojoPersister(String databaseName){
        databaseName = databaseName.toLowerCase().replaceAll(" ", "");
        MongoDatabase database = getMongoDatabase(databaseName);
        collection = database.getCollection(this.getClass().getName(), PojoPersister.class);
    }

    public <T> Iterable<T> findAll(String databaseName,T obj){
        MongoDatabase database = getMongoDatabase(databaseName);
        MongoCollection<T> collection = (MongoCollection<T>) database.getCollection(obj.getClass().getSimpleName(), obj.getClass());
        return collection.find();
    }

    public PojoPersister findOne(Document document){
        return collection.find(document).first();
    }
    public <T> void saveObj(String databaseName, T obj){
        MongoDatabase database = getMongoDatabase(databaseName);
        MongoCollection<T> collection = (MongoCollection<T>) database.getCollection(obj.getClass().getSimpleName(), obj.getClass());
        collection.insertOne(obj);
    }

    public MongoDatabase getMongoDatabase(String dbName) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientURI connectionString = new MongoClientURI(mongoDbUri);
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        database = database.withCodecRegistry(pojoCodecRegistry);
        return database;
    }

}
