package model;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String userpassword;
	private String usertel;
	private String gender;
	private String realname;
	private String usercreatetime;
	private Integer photoid;
	private Boolean state;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userid, String userpassword, String usertel,
			String gender, String realname, String usercreatetime,
			Integer photoid, Boolean state, Integer roleid) {
		this.userid = userid;
		this.userpassword = userpassword;
		this.usertel = usertel;
		this.gender = gender;
		this.realname = realname;
		this.usercreatetime = usercreatetime;
		this.photoid = photoid;
		this.state = state;
		this.roleid = roleid;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsertel() {
		return this.usertel;
	}

	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsercreatetime() {
		return this.usercreatetime;
	}

	public void setUsercreatetime(String usercreatetime) {
		this.usercreatetime = usercreatetime;
	}

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}