/**
 * 
 */
package MicroInfluencer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParseException, IOException {
	
		List<List<String>> rows = new ArrayList<>();
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
		        
		         JSONArray jsonArr =(JSONArray) jsonObj.get("posts");
		         ArrayList <Post> postList=new ArrayList();
				 for( int i=0; i<jsonArr.size();i++) {
					 
					 //parse post
					 JSONObject o= (JSONObject) jsonArr.get(i);
					 Post post=new Post();
					 post.setUrl((String)o.get("url"));
					 JSONArray tags=(JSONArray)o.get("tags");
					 post.setTagCount(tags.size());
					 String caption= (String)o.get("description");
					 post.setCaptionLength(caption.length());
					 post.setLikeCount(Math.toIntExact((long) o.get("numberLikes")));
					 postList.add(post);
				 }
				 u.setPostList(postList);
				 
				// TODO Calculate influence value
				 u.setLikeValue(cal.calculateLikeCountValue(u));
				 u.setFollowerValue((long)cal.calculateFollowerValue(u));
				 u.setCaptionValue((long)cal.calculateCaptionLengthValue(u));
				 u.setTagValue((long)cal.calculateTagCountValue(u));
				 u.setInfluenceValueA(cal.calculateInfluenceValueA(u));
				 u.setInfluenceValueB(cal.calculateInfluenceValueB(u));

				 //TODO: convert to String add to rows
				 System.out.println(u.getFollowerValue());
				 List<String> userString=Arrays.asList(u.getId(),Integer.toString(u.getFollowersCount())
						 ,Long.toString(u.getLikeValue()),Long.toString(u.getFollowerValue())
						 ,Long.toString(u.getCaptionValue()),Long.toString(u.getTagValue())
						,Long.toString(u.getInfluenceValueA()),Long.toString(u.getInfluenceValueB()));
				 rows.add(userString);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} 
		
	// TODO : write to csv
		FileWriter csvWriter = new FileWriter("result3.csv");
		csvWriter.append("UserName");
		csvWriter.append(",");
		csvWriter.append("FollowerCount");
		csvWriter.append(",");
		csvWriter.append("LikeValue");
		csvWriter.append(",");
		csvWriter.append("FollowerValue");
		csvWriter.append(",");
		csvWriter.append("CaptionValue");
		csvWriter.append(",");
		csvWriter.append("TagValue");
		csvWriter.append(",");
		csvWriter.append("FLCTValue");
		csvWriter.append(",");
		csvWriter.append("ARIMValue");
		csvWriter.append("\n");

		for (List<String> rowData : rows) {
		    csvWriter.append(String.join(",", rowData));
		    csvWriter.append("\n");
		}

		csvWriter.flush();
		csvWriter.close();

	}

}
