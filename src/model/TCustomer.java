package model;

/**
 * TCustomer entity. @author MyEclipse Persistence Tools
 */

public class TCustomer implements java.io.Serializable {

	// Fields

	private String customeraccount;
	private String pasword;
	private String customername;
	private String tel;
	private String gender;
	private Boolean state;
	private String customercreatetime;

	// Constructors

	/** default constructor */
	public TCustomer() {
	}

	/** full constructor */
	public TCustomer(String customeraccount, String pasword,
			String customername, String tel, String gender, Boolean state,
			String customercreatetime) {
		this.customeraccount = customeraccount;
		this.pasword = pasword;
		this.customername = customername;
		this.tel = tel;
		this.gender = gender;
		this.state = state;
		this.customercreatetime = customercreatetime;
	}

	// Property accessors

	public String getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(String customeraccount) {
		this.customeraccount = customeraccount;
	}

	public String getPasword() {
		return this.pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getCustomercreatetime() {
		return this.customercreatetime;
	}

	public void setCustomercreatetime(String customercreatetime) {
		this.customercreatetime = customercreatetime;
	}

}