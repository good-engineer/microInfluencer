package MicroInfluencer;

import java.util.ArrayList;

public class User {
	private static String id;
	private static int followersCount;
	private static ArrayList<Post> postList;
	private static int influenceValue=0;
	// TODO number of posts in a period of time 
	// TODO tag relation 
	
	public void User() {
		this.postList=new ArrayList<Post>();
	}
	
	public int getPostListCount() {
		return User.postList.size();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		User.id = id;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		User.followersCount = followersCount;
	}

	public ArrayList<Post> getPostList() {
		return postList;
	}

	public void setPostList(ArrayList<Post> postList) {
		User.postList = postList;
	}
	public void addPost(Post post) {
		User.postList.add(post);
	}
	public int getInfluenceValue() {
		return influenceValue;
	}

	public void setInfluenceValue(int influenceValue) {
		User.influenceValue = influenceValue;
	}
}
