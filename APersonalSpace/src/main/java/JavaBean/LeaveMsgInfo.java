package JavaBean;

import java.io.Serializable;

public class LeaveMsgInfo implements Serializable {
	String id;
	String targetid;
	String text;

	public LeaveMsgInfo() {
	}

	public LeaveMsgInfo(String id, String targetid, String text) {
		this.id = id;
		this.targetid = targetid;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
