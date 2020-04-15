package model;


/**
 * VAppointment entity. @author MyEclipse Persistence Tools
 */

public class VAppointment implements java.io.Serializable {

	// Fields

	private Integer customerappid;
	private String customeraccount;
	private Integer appointmentid;
	private String appointmenttype;
	private String appointmentname;
	private String appointmenttime;
	private Boolean state;
	private String appcreatetime;
	private String remark;
	private String price;
	private String createby;
	private String customername;
	private Long tel;
	private String gender;

	// Constructors

	/** default constructor */
	public VAppointment() {
	}

	/** full constructor */
	public VAppointment(Integer customerappid, String customeraccount,
			Integer appointmentid, String appointmenttype,
			String appointmentname, String appointmenttime, Boolean state,
			String appcreatetime, String remark, String price, String createby,
			String customername, Long tel, String gender) {
		this.customerappid = customerappid;
		this.customeraccount = customeraccount;
		this.appointmentid = appointmentid;
		this.appointmenttype = appointmenttype;
		this.appointmentname = appointmentname;
		this.appointmenttime = appointmenttime;
		this.state = state;
		this.appcreatetime = appcreatetime;
		this.remark = remark;
		this.price = price;
		this.createby = createby;
		this.customername = customername;
		this.tel = tel;
		this.gender = gender;
	}

	// Property accessors

	public Integer getCustomerappid() {
		return this.customerappid;
	}

	public void setCustomerappid(Integer customerappid) {
		this.customerappid = customerappid;
	}

	public String getCustomeraccount() {
		return this.customeraccount;
	}

	public void setCustomeraccount(String customeraccount) {
		this.customeraccount = customeraccount;
	}

	public Integer getAppointmentid() {
		return this.appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public String getAppointmenttype() {
		return this.appointmenttype;
	}

	public void setAppointmenttype(String appointmenttype) {
		this.appointmenttype = appointmenttype;
	}

	public String getAppointmentname() {
		return this.appointmentname;
	}

	public void setAppointmentname(String appointmentname) {
		this.appointmentname = appointmentname;
	}

	public String getAppointmenttime() {
		return this.appointmenttime;
	}

	public void setAppointmenttime(String appointmenttime) {
		this.appointmenttime = appointmenttime;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getAppcreatetime() {
		return this.appcreatetime;
	}

	public void setAppcreatetime(String appcreatetime) {
		this.appcreatetime = appcreatetime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCreateby() {
		return this.createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
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

}