package MicroInfluencer;

import java.util.ArrayList;

public class User{// implements Comparable<User> {
	private static String id;
	private static int followersCount;
	private static ArrayList<Post> postList;
	private static long influenceValue=0;
	// TODO number of posts in a period of time 
	// TODO tag relation 
	
	public void User()  {
		//this.postList=new ArrayList();
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
	
	public long getInfluenceValue() {
		return influenceValue;
	}

	public void setInfluenceValue(long influenceValue) {
		User.influenceValue = influenceValue;
	}

//	@Override
//	public int compareTo(User o) {
//		// TODO Auto-generated method stub
//		if(this.getInfluenceValue()>o.getInfluenceValue())
//			return 1;
//		else if(this.getInfluenceValue()<o.getInfluenceValue())
//			return -1;
//		else return 0;
//	}
}
