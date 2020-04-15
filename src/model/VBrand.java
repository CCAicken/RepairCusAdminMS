package model;

/**
 * VBrand entity. @author MyEclipse Persistence Tools
 */

public class VBrand implements java.io.Serializable {

	// Fields

	private Integer brandid;
	private String brandname;
	private Boolean state;
	private String brandintroduction;
	private Integer brandphoto;
	private String photoname;

	// Constructors

	/** default constructor */
	public VBrand() {
	}

	/** full constructor */
	public VBrand(Integer brandid, String brandname, Boolean state,
			String brandintroduction, Integer brandphoto, String photoname) {
		this.brandid = brandid;
		this.brandname = brandname;
		this.state = state;
		this.brandintroduction = brandintroduction;
		this.brandphoto = brandphoto;
		this.photoname = photoname;
	}

	// Property accessors

	public Integer getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getBrandintroduction() {
		return this.brandintroduction;
	}

	public void setBrandintroduction(String brandintroduction) {
		this.brandintroduction = brandintroduction;
	}

	public Integer getBrandphoto() {
		return this.brandphoto;
	}

	public void setBrandphoto(Integer brandphoto) {
		this.brandphoto = brandphoto;
	}

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

}