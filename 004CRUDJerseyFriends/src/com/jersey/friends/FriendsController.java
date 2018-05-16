package com.jersey.friends;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/friend")
public class FriendsController {
	
	FriendsCollectionService friendsCollectionService = new FriendsCollectionService();
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome(){
		return "Welcome";
	}
	
	//CRUD for friends
	
	//get the list of all friends
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friend> getAllFriends(){
		List<Friend> allfriends = friendsCollectionService.getAllFriends();
		for(Friend f:allfriends){
			System.out.println(f.id + " " + f.name);
		}
		return allfriends;
	}
	
	//get the name of friend by id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Friend getFriendById(@PathParam("id") int myid){
		Friend f = friendsCollectionService.getFriendById(myid);	
		return f;
	}
	
	//update the friend
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friend> updateFriend(Friend friend){
		Friend f = friendsCollectionService.updateFriend(friend);
		System.out.println("Friend is updated: " + f.getName());
		List<Friend> allfriends = friendsCollectionService.getAllFriends();
		return allfriends;
	}
	
	//delete the friend
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Friend> deleteFriend(@PathParam("id") int myid){
		
		friendsCollectionService.deleteFriend(myid);
		List<Friend> allfriends = friendsCollectionService.getAllFriends();
		return allfriends;
		
		
	}

}
