package lecture16.chat;

import java.time.ZonedDateTime;

public class Message {
	enum MessageStatus{
		NEVER_SENT, SENT
	}
	String content;
	ZonedDateTime created;
	MessageStatus status;
	User author;
	public Message() {
		status = MessageStatus.NEVER_SENT;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ZonedDateTime getCreated() {
		return created;
	}
	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}
	public MessageStatus getStatus() {
		return status;
	}
	public void setStatus(MessageStatus status) {
		this.status = status;
	}
	

}
