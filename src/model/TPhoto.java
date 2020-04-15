package model;


/**
 * TPhoto entity. @author MyEclipse Persistence Tools
 */

public class TPhoto implements java.io.Serializable {

	// Fields

	private Integer photoid;
	private Boolean state;
	private String photoname;
	private String byuser;
	private String photocreatetime;

	// Constructors

	/** default constructor */
	public TPhoto() {
	}

	/** minimal constructor */
	public TPhoto(Boolean state, String photoname, String byuser,
			String photocreatetime) {
		this.state = state;
		this.photoname = photoname;
		this.byuser = byuser;
		this.photocreatetime = photocreatetime;
	}

	// Property accessors

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

	public String getByuser() {
		return this.byuser;
	}

	public void setByuser(String byuser) {
		this.byuser = byuser;
	}

	public String getPhotocreatetime() {
		return this.photocreatetime;
	}

	public void setPhotocreatetime(String photocreatetime) {
		this.photocreatetime = photocreatetime;
	}
}