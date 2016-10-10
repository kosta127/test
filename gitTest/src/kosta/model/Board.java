package kosta.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Board implements Serializable{
	private int b_id;
	private String b_password;
	private String b_name;
	private String b_title;
	private String b_contents;
	private String b_hit;
	private Timestamp b_regdate;
	private Timestamp b_deldate;
	private int replyCount;
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_password() {
		return b_password;
	}
	public void setB_password(String b_password) {
		this.b_password = b_password;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_hit() {
		return b_hit;
	}
	public void setB_hit(String b_hit) {
		this.b_hit = b_hit;
	}
	public Timestamp getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Timestamp b_regdate) {
		this.b_regdate = b_regdate;
	}
	public Timestamp getB_deldate() {
		return b_deldate;
	}
	public void setB_deldate(Timestamp b_deldate) {
		this.b_deldate = b_deldate;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	
	
}
