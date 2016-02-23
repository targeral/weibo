package L.db;

public class Attented {
	private String UserName;
	private String AttentName;
	private String Summary;
	private String Sign;
	private int PostNumber;
	private int AttentNumber;
	private int AttentedNumber;
	public int getAttentNumber() {
		return AttentNumber;
	}
	public void setAttentNumber(int attentNumber) {
		AttentNumber = attentNumber;
	}
	public int getAttentedNumber() {
		return AttentedNumber;
	}
	public void setAttentedNumber(int attentedNumber) {
		AttentedNumber = attentedNumber;
	}
	public int getPostNumber() {
		return PostNumber;
	}
	public void setPostNumber(int postNumber) {
		PostNumber = postNumber;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getSign() {
		return Sign;
	}
	public void setSign(String sign) {
		Sign = sign;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getAttentName() {
		return AttentName;
	}
	public void setAttentName(String attentName) {
		AttentName = attentName;
	}
}
