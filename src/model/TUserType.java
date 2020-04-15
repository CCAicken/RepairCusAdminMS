package model;

/**
 * TUserType entity. @author MyEclipse Persistence Tools
 */

public class TUserType implements java.io.Serializable {

	// Fields

	private Integer usertypeid;
	private String typename;
	private String description;
	private Boolean state;

	// Constructors

	/** default constructor */
	public TUserType() {
	}

	/** full constructor */
	public TUserType(String typename, String description, Boolean state) {
		this.typename = typename;
		this.description = description;
		this.state = state;
	}

	// Property accessors

	public Integer getUsertypeid() {
		return this.usertypeid;
	}

	public void setUsertypeid(Integer usertypeid) {
		this.usertypeid = usertypeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}