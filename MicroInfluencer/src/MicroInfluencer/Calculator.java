/**
 * 
 */
package MicroInfluencer;

import java.util.ArrayList;

/**
 * @author Maryam
 *
 */
public interface Calculator {
	public long calculateInfluenceValue(User u);
	public long calculateTotalEngagment(ArrayList<Post> postList);
	public long calculatePostEngagment(Post p);
	
}
