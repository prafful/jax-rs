package com.jersey.friends;

import java.io.IOException;
import java.sql.SQLException;

import org.bson.Document;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FriendDAOMongo {
	
	MongoClient mongoClient = null;
	ObjectMapper mapper; 
	String pojoToJson;
	Document doc;
	MongoCollection<Document> collection = null;
	
	public void connect(){
		
		mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("friends");
		System.out.println("Connecting to 'friends' database...");
		
		collection = db.getCollection("details");
		System.out.println("Collection: " + collection);

		
	}
	

	public void disconnect(){
		mongoClient.close();
	}
	
	
	
	public void insertFriend(){
		connect();
		//Friend Insert One
		final Friend friend = new Friend();
		friend.setId(1);
		friend.setName("yuko");
		friend.setLocation("Yokohama");
		
		 // Use Jackson to convert Object to JSON String
		mapper = new ObjectMapper();
		try {
			pojoToJson = mapper.writeValueAsString(friend);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doc = Document.parse(pojoToJson);
		collection.insertOne(doc);
		disconnect();
	}
	

}
