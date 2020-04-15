package model;

/**
 * TCar entity. @author MyEclipse Persistence Tools
 */

public class TCar implements java.io.Serializable {

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

	// Constructors

	/** default constructor */
	public TCar() {
	}

	/** minimal constructor */
	public TCar(Boolean state, String carname) {
		this.state = state;
		this.carname = carname;
	}

	/** full constructor */
	public TCar(String carseries, String guideprice, Integer brandid,
			String manufacturer, String carstate, String markettime,
			Integer cartypeid, Integer photoid, Boolean state, String carname) {
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

}