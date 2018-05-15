package com.jersey.friends.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.friends.service.FriendsCollectionService;

@Path("/friends")
public class FriendsController {
	
	FriendsCollectionService friendsCollectionService = new FriendsCollectionService();
	
	//CRUD for friends
	
	//get the list of all friends
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllFriends(){
		List allfriends = friendsCollectionService.getAllFriends();
		return allfriends;
	}
	
	//get the name of friend by id
	public void getFriendById(){
		
	}
	
	//update the friend
	public void updateFriend(){
		
	}
	
	//delete the friend
	public void deleteFriend(){
		
	}

}
