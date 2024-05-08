package lecture16.chat;

public class User {
	enum UserStatus {
		ONLINE, OFFLINE, IDLE
	}
	private static long NEXT_USER_UUID = 0L; 
	UserStatus status;
	String username;
	long userId;
	public long getUserId() {
		return userId;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public User(String username) {
		this.username = username;
		this.status = UserStatus.ONLINE;
		this.userId=NEXT_USER_UUID++;
	}

}
