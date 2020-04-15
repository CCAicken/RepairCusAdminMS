package model;


/**
 * VRoleSysModel entity. @author MyEclipse Persistence Tools
 */

public class VRoleSysModel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Boolean isedit;
	private Integer sysid;
	private String createdate;
	private String name;
	private String navurl;
	private Integer parentid;
	private Integer deepth;
	private String imageurl;
	private Integer displayorder;
	private Boolean isdelete;
	private String rolename;
	private String description;
	private Boolean rolestate;

	// Constructors

	/** default constructor */
	public VRoleSysModel() {
	}

	/** minimal constructor */
	public VRoleSysModel(Integer id, Integer roleid, Boolean isedit,
			Integer sysid, String createdate, String rolename,
			String description, Boolean rolestate) {
		this.id = id;
		this.roleid = roleid;
		this.isedit = isedit;
		this.sysid = sysid;
		this.createdate = createdate;
		this.rolename = rolename;
		this.description = description;
		this.rolestate = rolestate;
	}

	/** full constructor */
	public VRoleSysModel(Integer id, Integer roleid, Boolean isedit,
			Integer sysid, String createdate, String name, String navurl,
			Integer parentid, Integer deepth, String imageurl,
			Integer displayorder, Boolean isdelete, String rolename,
			String description, Boolean rolestate) {
		this.id = id;
		this.roleid = roleid;
		this.isedit = isedit;
		this.sysid = sysid;
		this.createdate = createdate;
		this.name = name;
		this.navurl = navurl;
		this.parentid = parentid;
		this.deepth = deepth;
		this.imageurl = imageurl;
		this.displayorder = displayorder;
		this.isdelete = isdelete;
		this.rolename = rolename;
		this.description = description;
		this.rolestate = rolestate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Boolean getIsedit() {
		return this.isedit;
	}

	public void setIsedit(Boolean isedit) {
		this.isedit = isedit;
	}

	public Integer getSysid() {
		return this.sysid;
	}

	public void setSysid(Integer sysid) {
		this.sysid = sysid;
	}

	public String getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNavurl() {
		return this.navurl;
	}

	public void setNavurl(String navurl) {
		this.navurl = navurl;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getDeepth() {
		return this.deepth;
	}

	public void setDeepth(Integer deepth) {
		this.deepth = deepth;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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