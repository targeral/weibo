package L.db;

public class Post {
	private int PostID;
	private String UserName;
	private String Instance;
	private String DateTime;
	private int ReplyNumber;
	private int ResendNumber;
	private int Zan;
	private int ResendFlag;
	public int getResendFlag() {
		return ResendFlag;
	}
	public void setResendFlag(int resendFlag) {
		ResendFlag = resendFlag;
	}
	public int getZan() {
		return Zan;
	}
	public void setZan(int zan) {
		Zan = zan;
	}
	public int getPostID() {
		return PostID;
	}
	public void setPostID(int postID) {
		PostID = postID;
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
	public int getReplyNumber() {
		return ReplyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		ReplyNumber = replyNumber;
	}
	public int getResendNumber() {
		return ResendNumber;
	}
	public void setResendNumber(int resendNumber) {
		ResendNumber = resendNumber;
	}
}
