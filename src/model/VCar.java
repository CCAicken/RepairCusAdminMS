package model;

/**
 * VCar entity. @author MyEclipse Persistence Tools
 */

public class VCar implements java.io.Serializable {

	// Fields

	private Integer carid;
	private String carseries;
	private String guideprice;
	private Integer brandid;
	private String manufacturer;
	private String carstate;
	private String markettime;
	private Integer cartypeid;
	private Integer photoid;
	private Boolean state;
	private String carname;
	private String cartypename;
	private String brandname;
	private String photoname;

	// Constructors

	/** default constructor */
	public VCar() {
	}

	/** minimal constructor */
	public VCar(Integer carid, Boolean state, String carname,
			String cartypename, String brandname, String photoname) {
		this.carid = carid;
		this.state = state;
		this.carname = carname;
		this.cartypename = cartypename;
		this.brandname = brandname;
		this.photoname = photoname;
	}

	/** full constructor */
	public VCar(Integer carid, String carseries, String guideprice,
			Integer brandid, String manufacturer, String carstate,
			String markettime, Integer cartypeid, Integer photoid,
			Boolean state, String carname, String cartypename,
			String brandname, String photoname) {
		this.carid = carid;
		this.carseries = carseries;
		this.guideprice = guideprice;
		this.brandid = brandid;
		this.manufacturer = manufacturer;
		this.carstate = carstate;
		this.markettime = markettime;
		this.cartypeid = cartypeid;
		this.photoid = photoid;
		this.state = state;
		this.carname = carname;
		this.cartypename = cartypename;
		this.brandname = brandname;
		this.photoname = photoname;
	}

	// Property accessors

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public String getCarseries() {
		return this.carseries;
	}

	public void setCarseries(String carseries) {
		this.carseries = carseries;
	}

	public String getGuideprice() {
		return this.guideprice;
	}

	public void setGuideprice(String guideprice) {
		this.guideprice = guideprice;
	}

	public Integer getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCarstate() {
		return this.carstate;
	}

	public void setCarstate(String carstate) {
		this.carstate = carstate;
	}

	public String getMarkettime() {
		return this.markettime;
	}

	public void setMarkettime(String markettime) {
		this.markettime = markettime;
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

	public String getCarname() {
		return this.carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCartypename() {
		return this.cartypename;
	}

	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
}