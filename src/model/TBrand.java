package model;


/**
 * TBrand entity. @author MyEclipse Persistence Tools
 */

public class TBrand implements java.io.Serializable {

	// Fields

	private Integer brandid;
	private String brandname;
	private Boolean state;
	private String brandintroduction;
	private Integer brandphoto;

	// Constructors

	/** default constructor */
	public TBrand() {
	}

	/** full constructor */
	public TBrand(String brandname, Boolean state, String brandintroduction,
			Integer brandphoto) {
		this.brandname = brandname;
		this.state = state;
		this.brandintroduction = brandintroduction;
		this.brandphoto = brandphoto;
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

}