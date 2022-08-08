package JavaBean;

import java.io.Serializable;

public class userSendMsg  implements Serializable{
	String id;
	String time;
	String sendmsg;
	public userSendMsg(String id, String time, String sendmsg) {
		this.id = id;
		this.time = time;
		this.sendmsg = sendmsg;
	}
	public userSendMsg() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSendmsg() {
		return sendmsg;
	}
	public void setSendmsg(String sendmsg) {
		this.sendmsg = sendmsg;
	}
	@Override
	public String toString() {
		return "userSendMsg [id=" + id + ", time=" + time + ", sendmsg=" + sendmsg + "]";
	}
	
}
