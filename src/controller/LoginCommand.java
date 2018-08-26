package controller;

public class LoginCommand {
	//파라미터명과 일치 시키자
	//※속성(멤버변수)는 소문자로 시작해야한다
	private String userID;
	private String userPWD;
	//게터/세터
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		userID = userID;
	}
	public String getUserPWD() {
		return userPWD;
	}
	public void setUserPWD(String userPWD) {
		userPWD = userPWD;
	}

	
}
