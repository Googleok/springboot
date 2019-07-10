package com.cafe24.mysite.vo;

public class ModalVo {
	
	private Long no;
	private String email;
	private String password;
	private String contents;
	private String regDate;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ModalVo [no=" + no + ", email=" + email + ", password=" + password + ", contents=" + contents
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}
