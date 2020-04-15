package model;

import java.sql.Timestamp;

/**
 * VUser entity. @author MyEclipse Persistence Tools
 */

public class VUser implements java.io.Serializable {

	// Fields

	private String userid;
	private String userpassword;
	private Integer usertel;
	private String gender;
	private String realname;
	private Timestamp usercreatetime;
	private Integer photoid;
	private Boolean state;
	private String photoname;
	private String name;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public VUser() {
	}

	/** full constructor */
	public VUser(String userid, String userpassword, Integer usertel,
			String gender, String realname, Timestamp usercreatetime,
			Integer photoid, Boolean state, String photoname, String name,
			Integer roleid) {
		this.userid = userid;
		this.userpassword = userpassword;
		this.usertel = usertel;
		this.gender = gender;
		this.realname = realname;
		this.usercreatetime = usercreatetime;
		this.photoid = photoid;
		this.state = state;
		this.photoname = photoname;
		this.name = name;
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

	public Integer getUsertel() {
		return this.usertel;
	}

	public void setUsertel(Integer usertel) {
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

	public Timestamp getUsercreatetime() {
		return this.usercreatetime;
	}

	public void setUsercreatetime(Timestamp usercreatetime) {
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

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}