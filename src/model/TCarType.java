package model;

/**
 * TCarType entity. @author MyEclipse Persistence Tools
 */

public class TCarType implements java.io.Serializable {

	// Fields

	private Integer cartypeid;
	private String cartypename;
	private Boolean state;

	// Constructors

	/** default constructor */
	public TCarType() {
	}

	/** full constructor */
	public TCarType(String cartypename, Boolean state) {
		this.cartypename = cartypename;
		this.state = state;
	}

	// Property accessors

	public Integer getCartypeid() {
		return this.cartypeid;
	}

	public void setCartypeid(Integer cartypeid) {
		this.cartypeid = cartypeid;
	}

	public String getCartypename() {
		return this.cartypename;
	}

	public void setCartypename(String cartypename) {
		this.cartypename = cartypename;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}