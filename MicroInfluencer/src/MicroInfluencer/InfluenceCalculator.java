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
	
	public long calculateInfluenceValue(User u) {
		long fraction=(long)Math.exp((double)1/u.getPostListCount());
		return calculateTotalEngagment(u.getPostList())*fraction;
	}
	public long calculateTotalEngagment(ArrayList<Post> postList) {
		long total=0;
		
		for (Post p:postList) {
			total+=calculatePostEngagment(p);
		}
		if (postList.isEmpty()) {
			return 0;
		}
		return total/postList.size();
	}
	public long calculatePostEngagment(Post p) {
		return p.getLikeCount();
	}

}
