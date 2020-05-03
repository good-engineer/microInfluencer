/**
 * 
 */
package MicroInfluencer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Maryam
 * dataset by github repository ()
 *
 */
public class MicroInfluencer {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		ArrayList<User> userList=new ArrayList<>();
		JSONParser parser = new JSONParser();
		InfluenceCalculator cal = new InfluenceCalculator ();
		
		try { 
			// TODO read all users
			File dir = new File("C:\\Users\\Maryam\\git\\microInfluencer\\MicroInfluencer\\data");
			for(String file : dir.list()) {
				// TODO read the file
				 Object obj = parser.parse(new FileReader("C:\\Users\\Maryam\\git\\microInfluencer\\MicroInfluencer\\data\\"+file));
		         JSONObject jsonObj = (JSONObject)obj;
		         
		       // TODO parse User
				 User u = new User();
				 u.setId((String)jsonObj.get("alias"));
				 u.setFollowersCount(Math.toIntExact((long) jsonObj.get("numberFollowers")));
		         //System.out.println(u.getId() + " "+ u.getFollowersCount());
		         JSONArray jsonArr =(JSONArray) jsonObj.get("posts");
		         ArrayList <Post> postList=new ArrayList();
				 for( int i=0; i<jsonArr.size();i++) {
					 JSONObject o= (JSONObject) jsonArr.get(i);
					 Post post=new Post();
					 post.setUrl((String)o.get("url"));
					 post.setLikeCount(Math.toIntExact((long) o.get("numberLikes")));
					 postList.add(post);
				 }
				 u.setPostList(postList);
				 
				// TODO Calculate influence value
				 u.setInfluenceValue(cal.calculateInfluenceValue(u));
				 userList.add(u);
				 System.out.println("user: "+ u.getId()+ " followers: "+u.getFollowersCount()+" influence value: " + u.getInfluenceValue());
			
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} 
		// TODO sort Users
//		for(int i=0; i<userList.size();i++) {
//			User u= new User();
//			u=userList.get(i);
//    	    System.out.println(" influence value: " + u.getInfluenceValue()+ " user: "+ u.getId()+ " followers: "+u.getFollowersCount());
//		}
//		Collections.sort(userList);
//		int size= userList.size();
//		for(int i=0; i<userList.size();i++) {
//			User u= new User();
//			u=userList.get(i);
//			 System.out.println(" influence value: " + u.getInfluenceValue()+ " user: "+ u.getId()+ " followers: "+u.getFollowersCount());
//		}


		// TODO print users

	}

}
