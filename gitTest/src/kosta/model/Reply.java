package kosta.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reply implements Serializable {
	private int r_id;
	private String r_password;
	private String r_name;
	private String r_contents;
	private Timestamp r_regdate;
	private Timestamp r_deldate;
	private int b_id;
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_password() {
		return r_password;
	}
	public void setR_password(String r_password) {
		this.r_password = r_password;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public Timestamp getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(Timestamp r_regdate) {
		this.r_regdate = r_regdate;
	}
	public Timestamp getR_deldate() {
		return r_deldate;
	}
	public void setR_deldate(Timestamp r_deldate) {
		this.r_deldate = r_deldate;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	
	
}
