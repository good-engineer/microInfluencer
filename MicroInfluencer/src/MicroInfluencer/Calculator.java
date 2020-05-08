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
	public long calculateLikeCountValue(User u);
	public double calculateFollowerValue(User u) ;
	public double calculateCaptionLengthValue(User u) ;
	public double calculateTagCountValue(User u) ; 
	public long calculateTotalEngagment(User u);
	
}
