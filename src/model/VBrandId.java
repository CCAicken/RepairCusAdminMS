package model;

/**
 * VBrandId entity. @author MyEclipse Persistence Tools
 */

public class VBrandId implements java.io.Serializable {

	// Fields

	private Integer brandid;
	private String brandname;
	private Boolean state;
	private String brandintroduction;
	private Integer brandphoto;
	private String photoname;

	// Constructors

	/** default constructor */
	public VBrandId() {
	}

	/** full constructor */
	public VBrandId(Integer brandid, String brandname, Boolean state,
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBrandId))
			return false;
		VBrandId castOther = (VBrandId) other;

		return ((this.getBrandid() == castOther.getBrandid()) || (this
				.getBrandid() != null && castOther.getBrandid() != null && this
				.getBrandid().equals(castOther.getBrandid())))
				&& ((this.getBrandname() == castOther.getBrandname()) || (this
						.getBrandname() != null
						&& castOther.getBrandname() != null && this
						.getBrandname().equals(castOther.getBrandname())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())))
				&& ((this.getBrandintroduction() == castOther
						.getBrandintroduction()) || (this
						.getBrandintroduction() != null
						&& castOther.getBrandintroduction() != null && this
						.getBrandintroduction().equals(
								castOther.getBrandintroduction())))
				&& ((this.getBrandphoto() == castOther.getBrandphoto()) || (this
						.getBrandphoto() != null
						&& castOther.getBrandphoto() != null && this
						.getBrandphoto().equals(castOther.getBrandphoto())))
				&& ((this.getPhotoname() == castOther.getPhotoname()) || (this
						.getPhotoname() != null
						&& castOther.getPhotoname() != null && this
						.getPhotoname().equals(castOther.getPhotoname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBrandid() == null ? 0 : this.getBrandid().hashCode());
		result = 37 * result
				+ (getBrandname() == null ? 0 : this.getBrandname().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37
				* result
				+ (getBrandintroduction() == null ? 0 : this
						.getBrandintroduction().hashCode());
		result = 37
				* result
				+ (getBrandphoto() == null ? 0 : this.getBrandphoto()
						.hashCode());
		result = 37 * result
				+ (getPhotoname() == null ? 0 : this.getPhotoname().hashCode());
		return result;
	}

}