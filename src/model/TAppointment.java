package model;


/**
 * TAppointment entity. @author MyEclipse Persistence Tools
 */

public class TAppointment implements java.io.Serializable {

	// Fields

	private Integer appointmentid;
	private String appointmenttype;
	private String appointmentname;
	private String appointmenttime;
	private Boolean state;
	private String appcreatetime;
	private String remark;
	private String price;
	private String createby;

	// Constructors

	/** default constructor */
	public TAppointment() {
	}

	/** minimal constructor */
	public TAppointment(String appointmenttype, String appointmentname,
			Boolean state, String appcreatetime, String price, String createby) {
		this.appointmenttype = appointmenttype;
		this.appointmentname = appointmentname;
		this.state = state;
		this.appcreatetime = appcreatetime;
		this.price = price;
		this.createby = createby;
	}

	/** full constructor */
	public TAppointment(String appointmenttype, String appointmentname,
			String appointmenttime, Boolean state, String appcreatetime,
			String remark, String price, String createby) {
		this.appointmenttype = appointmenttype;
		this.appointmentname = appointmentname;
		this.appointmenttime = appointmenttime;
		this.state = state;
		this.appcreatetime = appcreatetime;
		this.remark = remark;
		this.price = price;
		this.createby = createby;
	}

	// Property accessors

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

}