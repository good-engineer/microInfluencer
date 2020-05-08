package MicroInfluencer;

public class Post {
	private static String url;
	private static int likeCount;
	private static int tagCount;
	private static int captionLength;
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
	public static int getCaptionLength() {
		return captionLength;
	}
	public static void setCaptionLength(int captionLength) {
		Post.captionLength = captionLength;
	}
	public static int getTagCount() {
		return tagCount;
	}
	public static void setTagCount(int tagCount) {
		Post.tagCount = tagCount;
	}
}
