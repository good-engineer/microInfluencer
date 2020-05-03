package MicroInfluencer;

public class Post {
	private static String url;
	private static int likeCount;
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Post.url = url;
	}
	public static int getLikeCount() {
		return likeCount;
	}
	public static void setLikeCount(int likeCount) {
		Post.likeCount = likeCount;
	}
}
