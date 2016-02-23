package L.db;

public class Reply {
	private int PostID;
	private int ReplyID;
	private String UserName;
	private String Instance;
	private String DateTime;
	public int getPostID() {
		return PostID;
	}
	public void setPostID(int postID) {
		PostID = postID;
	}
	public int getReplyID() {
		return ReplyID;
	}
	public void setReplyID(int replyID) {
		ReplyID = replyID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getInstance() {
		return Instance;
	}
	public void setInstance(String instance) {
		Instance = instance;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
}
