/**
 * 
 */
package MicroInfluencer;

import java.util.ArrayList;

/**
 * @author Maryam
 *
 */
public class InfluenceCalculator implements Calculator {
	
	public long calculateInfluenceValueA(User u) { //total my algorithm : FLCT
		long fraction=(long)Math.exp((double)1/u.getPostListCount());
		return calculateTotalEngagment(u)*fraction;
	}
	public long calculateInfluenceValueB(User u) { //total paper algorithm (only by like) ARIM
		long fraction=(long)Math.exp((double)1/u.getPostListCount());
		return calculateLikeCountValue(u)*fraction;
	}
	
	//TODO : edit
	@Override
	public long calculateTotalEngagment(User u) {
		double total=0;
		double temp= calculateFollowerValue(u);
		
		if (calculateFollowerValue(u)>0) {
			total= calculateLikeCountValue(u)+calculateFollowerValue(u)+calculateCaptionLengthValue(u)+calculateTagCountValue(u);
		}
		return (long) total;
	}
	
	public long calculateLikeCountValue(User u) { //like
		ArrayList<Post> postList = u.getPostList();
        long total=0;
        
		if (postList.isEmpty()) {
			return 0;
		}
		for (Post p:postList) {
			total+= p.getLikeCount();;
		}
		return total/postList.size();
	}
	public double calculateFollowerValue(User u) { //follower count
		double value;

		if(u.getFollowersCount()<999) { // not enough followers
			value=0;
		}
		else if (u.getFollowersCount()<1000000) {
			//micro influencer
			double rate=10*(double) calculateLikeCountValue(u)/u.getFollowersCount();
			value= rate*calculateLikeCountValue(u);
			
		}else {
			// celebrity , we do not want to detect celebrity 
			value=0;
			
		}
		return value;
	}
	public double calculateCaptionLengthValue(User u) { //caption length
		// 138~150 length is ideal for caption
		double value=0;
        int length=0;
        ArrayList<Post> postList = u.getPostList();
		if (postList.isEmpty()) {
			return 0;
		}	
		for (Post p:postList) {
			length+= p.getCaptionLength();
		}
		int avgLength= length/postList.size();
		
		if(avgLength>137 && avgLength<151) {
			value= calculateFollowerValue(u);
		}else {
			value=0.5*calculateFollowerValue(u);
		}
		return value;
	}
	public double calculateTagCountValue(User u) { //tag count
		// According to research 5~10 tags is ideal 
		double value=0;
        int count=0;
        ArrayList<Post> postList = u.getPostList();
		if (postList.isEmpty()) {
			return 0;
		}	
		for (Post p:postList) {
			count+= p.getCaptionLength();
		}
		int avgCount= count/postList.size();
		
		if(avgCount>4 && avgCount<11) {
			value= calculateFollowerValue(u);
		}else {
			value=0.5*calculateFollowerValue(u);
		}
		return value;
	}


}
