package JavaBean;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private String id;
	private String name;
	private String passwd;
	private String text;
	private String other;

	public UserInfo() {
	}

	public UserInfo(String id, String name, String passwd, String text, String other) {
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.text = text;
		this.other = other;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", passwd=" + passwd + ", text=" + text + ", other=" + other
				+ "]";
	}
}
