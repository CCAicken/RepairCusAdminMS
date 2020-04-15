package model;

/**
 * VCustomerCarId entity. @author MyEclipse Persistence Tools
 */

public class VCustomerCarId implements java.io.Serializable {

	// Fields

	private Integer customercarid;
	private String carseries;
	private String chassisnumber;
	private String brand;
	private String manufacturer;
	private String licenseplatenumber;
	private String enginenumber;
	private Integer cartypeid;
	private Integer photoid;
	private Boolean state;
	private String customeraccount;
	private String carname;
	private String photoname;
	private String customername;
	private Long tel;
	private String gender;
	private String cartypename;
	private String carmileage;

	// Constructors

	/** default constructor */
	public VCustomerCarId() {
	}

	/** full constructor */
	public VCustomerCarId(Integer customercarid, String carseries,
			String chassisnumber, String brand, String manufacturer,
			String licenseplatenumber, String enginenumber, Integer cartypeid,
			Integer photoid, Boolean state, String customeraccount,
			String carname, String photoname, String customername, Long tel,
			String gender, String cartypename, String carmileage) {
		this.customercarid = customercarid;
		this.carseries = carseries;
		this.chassisnumber = chassisnumber;
		this.brand = brand;
		this.manufacturer = manufacturer;
		this.licenseplatenumber = licenseplatenumber;
		this.enginenumber = enginenumber;
		this.cartypeid = cartypeid;
		this.photoid = photoid;
		this.state = state;
		this.customeraccount = customeraccount;
		this.carname = carname;
		this.photoname = photoname;
		this.customername = customername;
		this.tel = tel;
		this.gender = gender;
		this.cartypename = cartypename;
		this.carmileage = carmileage;
	}

	// Property accessors

	public Integer getCustomercarid() {
		return this.customercarid;
	}

	public void setCustomercarid(Integer customercarid) {
		this.customercarid = customercarid;
	}

	public String getCarseries() {
		return this.carseries;
	}

	public void setCarseries(String carseries) {
		this.carseries = carseries;
	}

	public String getChassisnumber() {
		return this.chassisnumber;
	}

	public void setChassisnumber(String chassisnumber) {
		this.chassisnumber = chassisnumber;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLicenseplatenumber() {
		return this.licenseplatenumber;
	}

	public void setLicenseplatenumber(String licenseplatenumber) {
		this.licenseplatenumber = licenseplatenumber;
	}

	public String getEnginenumber() {
		return this.enginenumber;
	}

	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}

	public Integer getCartypeid() {
		return this.cartypeid;
	}

	public void setCartypeid(Integer cartypeid) {
		this.cartypeid = cartypeid;
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

	public String getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(String customeraccount) {
		this.customeraccount = customeraccount;
	}

	public String getCarname() {
		return this.carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Long getTel() {
		return this.tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCartypename() {
		return this.cartypename;
	}

	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}

	public String getCarmileage() {
		return this.carmileage;
	}

	public void setCarmileage(String carmileage) {
		this.carmileage = carmileage;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VCustomerCarId))
			return false;
		VCustomerCarId castOther = (VCustomerCarId) other;

		return ((this.getCustomercarid() == castOther.getCustomercarid()) || (this
				.getCustomercarid() != null
				&& castOther.getCustomercarid() != null && this
				.getCustomercarid().equals(castOther.getCustomercarid())))
				&& ((this.getCarseries() == castOther.getCarseries()) || (this
						.getCarseries() != null
						&& castOther.getCarseries() != null && this
						.getCarseries().equals(castOther.getCarseries())))
				&& ((this.getChassisnumber() == castOther.getChassisnumber()) || (this
						.getChassisnumber() != null
						&& castOther.getChassisnumber() != null && this
						.getChassisnumber()
						.equals(castOther.getChassisnumber())))
				&& ((this.getBrand() == castOther.getBrand()) || (this
						.getBrand() != null && castOther.getBrand() != null && this
						.getBrand().equals(castOther.getBrand())))
				&& ((this.getManufacturer() == castOther.getManufacturer()) || (this
						.getManufacturer() != null
						&& castOther.getManufacturer() != null && this
						.getManufacturer().equals(castOther.getManufacturer())))
				&& ((this.getLicenseplatenumber() == castOther
						.getLicenseplatenumber()) || (this
						.getLicenseplatenumber() != null
						&& castOther.getLicenseplatenumber() != null && this
						.getLicenseplatenumber().equals(
								castOther.getLicenseplatenumber())))
				&& ((this.getEnginenumber() == castOther.getEnginenumber()) || (this
						.getEnginenumber() != null
						&& castOther.getEnginenumber() != null && this
						.getEnginenumber().equals(castOther.getEnginenumber())))
				&& ((this.getCartypeid() == castOther.getCartypeid()) || (this
						.getCartypeid() != null
						&& castOther.getCartypeid() != null && this
						.getCartypeid().equals(castOther.getCartypeid())))
				&& ((this.getPhotoid() == castOther.getPhotoid()) || (this
						.getPhotoid() != null && castOther.getPhotoid() != null && this
						.getPhotoid().equals(castOther.getPhotoid())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())))
				&& ((this.getCustomeraccount() == castOther
						.getCustomeraccount()) || (this.getCustomeraccount() != null
						&& castOther.getCustomeraccount() != null && this
						.getCustomeraccount().equals(
								castOther.getCustomeraccount())))
				&& ((this.getCarname() == castOther.getCarname()) || (this
						.getCarname() != null && castOther.getCarname() != null && this
						.getCarname().equals(castOther.getCarname())))
				&& ((this.getPhotoname() == castOther.getPhotoname()) || (this
						.getPhotoname() != null
						&& castOther.getPhotoname() != null && this
						.getPhotoname().equals(castOther.getPhotoname())))
				&& ((this.getCustomername() == castOther.getCustomername()) || (this
						.getCustomername() != null
						&& castOther.getCustomername() != null && this
						.getCustomername().equals(castOther.getCustomername())))
				&& ((this.getTel() == castOther.getTel()) || (this.getTel() != null
						&& castOther.getTel() != null && this.getTel().equals(
						castOther.getTel())))
				&& ((this.getGender() == castOther.getGender()) || (this
						.getGender() != null && castOther.getGender() != null && this
						.getGender().equals(castOther.getGender())))
				&& ((this.getCartypename() == castOther.getCartypename()) || (this
						.getCartypename() != null
						&& castOther.getCartypename() != null && this
						.getCartypename().equals(castOther.getCartypename())))
				&& ((this.getCarmileage() == castOther.getCarmileage()) || (this
						.getCarmileage() != null
						&& castOther.getCarmileage() != null && this
						.getCarmileage().equals(castOther.getCarmileage())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCustomercarid() == null ? 0 : this.getCustomercarid()
						.hashCode());
		result = 37 * result
				+ (getCarseries() == null ? 0 : this.getCarseries().hashCode());
		result = 37
				* result
				+ (getChassisnumber() == null ? 0 : this.getChassisnumber()
						.hashCode());
		result = 37 * result
				+ (getBrand() == null ? 0 : this.getBrand().hashCode());
		result = 37
				* result
				+ (getManufacturer() == null ? 0 : this.getManufacturer()
						.hashCode());
		result = 37
				* result
				+ (getLicenseplatenumber() == null ? 0 : this
						.getLicenseplatenumber().hashCode());
		result = 37
				* result
				+ (getEnginenumber() == null ? 0 : this.getEnginenumber()
						.hashCode());
		result = 37 * result
				+ (getCartypeid() == null ? 0 : this.getCartypeid().hashCode());
		result = 37 * result
				+ (getPhotoid() == null ? 0 : this.getPhotoid().hashCode());
		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		result = 37
				* result
				+ (getCustomeraccount() == null ? 0 : this.getCustomeraccount()
						.hashCode());
		result = 37 * result
				+ (getCarname() == null ? 0 : this.getCarname().hashCode());
		result = 37 * result
				+ (getPhotoname() == null ? 0 : this.getPhotoname().hashCode());
		result = 37
				* result
				+ (getCustomername() == null ? 0 : this.getCustomername()
						.hashCode());
		result = 37 * result
				+ (getTel() == null ? 0 : this.getTel().hashCode());
		result = 37 * result
				+ (getGender() == null ? 0 : this.getGender().hashCode());
		result = 37
				* result
				+ (getCartypename() == null ? 0 : this.getCartypename()
						.hashCode());
		result = 37
				* result
				+ (getCarmileage() == null ? 0 : this.getCarmileage()
						.hashCode());
		return result;
	}

}