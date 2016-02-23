package L.db;

public class User {
	private String UserName;
	private String Password;
	private String RealName;
	private String Sex;
	private int Age;
	private String Summary;
	private String Sign;
	private String Email;
	private String PhoneNumber;
	private String Address;
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPostNumber() {
		return PostNumber;
	}
	public void setPostNumber(int postNumber) {
		PostNumber = postNumber;
	}
}
