package MicroInfluencer;

import java.util.ArrayList;

public class User{// implements Comparable<User> {
	private static String id;
	private static int followersCount;
	private static ArrayList<Post> postList;
	private static long influenceValueA; // LFCT
	private static long influenceValueB; // ARIM
	private static long LikeValue; //
	private static long followerValue; // 
	private static long CaptionValue; //  
	private static long TagValue; // 
	
	public User()  {
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
	
	public static long getInfluenceValueB() {
		return influenceValueB;
	}

	public static void setInfluenceValueB(long influenceValueB) {
		User.influenceValueB = influenceValueB;
	}

	public static long getInfluenceValueA() {
		return influenceValueA;
	}

	public static void setInfluenceValueA(long influenceValueA) {
		User.influenceValueA = influenceValueA;
	}

	public static long getLikeValue() {
		return LikeValue;
	}

	public static void setLikeValue(long likeValue) {
		LikeValue = likeValue;
	}

	public static long getFollowerValue() {
		return followerValue;
	}

	public static void setFollowerValue(long followerValue) {
		User.followerValue = followerValue;
	}

	public static long getCaptionValue() {
		return CaptionValue;
	}

	public static void setCaptionValue(long captionValue) {
		CaptionValue = captionValue;
	}

	public static long getTagValue() {
		return TagValue;
	}

	public static void setTagValue(long tagValue) {
		TagValue = tagValue;
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
