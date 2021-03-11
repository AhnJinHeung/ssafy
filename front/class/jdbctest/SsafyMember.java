package com.ssafy.jdbc;

public class SsafyMember {
	private int idx;
	private String userid;
	private String username;
	private String userpwd;
	private String emailid;
	private String emaildomain;
	private String joindate;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getEmaildomain() {
		return emaildomain;
	}
	public void setEmaildomain(String emaildomain) {
		this.emaildomain = emaildomain;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "SsafyMember [idx=" + idx + ", userid=" + userid + ", username=" + username + ", userpwd=" + userpwd
				+ ", emailid=" + emailid + ", emaildomain=" + emaildomain + ", joindate=" + joindate + "]";
	}
}
