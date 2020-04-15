package model;

import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String name;
	private String description;
	private Boolean rolestate;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(String name, String description, Boolean rolestate) {
		this.name = name;
		this.description = description;
		this.rolestate = rolestate;
	}

	/** full constructor */
	public TRole(String name, String description, Boolean rolestate,
			Set TRoleSysModels, Set TUsers) {
		this.name = name;
		this.description = description;
		this.rolestate = rolestate;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getRolestate() {
		return this.rolestate;
	}

	public void setRolestate(Boolean rolestate) {
		this.rolestate = rolestate;
	}
}