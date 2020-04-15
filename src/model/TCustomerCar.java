package model;

/**
 * TCustomerCar entity. @author MyEclipse Persistence Tools
 */

public class TCustomerCar implements java.io.Serializable {

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
	private String carmileage;

	// Constructors

	/** default constructor */
	public TCustomerCar() {
	}

	/** full constructor */
	public TCustomerCar(String carseries, String chassisnumber, String brand,
			String manufacturer, String licenseplatenumber,
			String enginenumber, Integer cartypeid, Integer photoid,
			Boolean state, String customeraccount, String carname,
			String carmileage) {
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

	public String getCarmileage() {
		return this.carmileage;
	}

	public void setCarmileage(String carmileage) {
		this.carmileage = carmileage;
	}

}