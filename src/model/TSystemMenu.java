package model;

/**
 * TSystemMenu entity. @author MyEclipse Persistence Tools
 */

public class TSystemMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String navurl;
	private Integer deepth;
	private Integer parentid;
	private Integer displayorder;
	private String imageurl;
	private Boolean isdelete;

	// Constructors

	/** default constructor */
	public TSystemMenu() {
	}

	/** full constructor */
	public TSystemMenu(String name, String navurl, Integer deepth,
			Integer parentid, Integer displayorder, String imageurl,
			Boolean isdelete) {
		this.name = name;
		this.navurl = navurl;
		this.deepth = deepth;
		this.parentid = parentid;
		this.displayorder = displayorder;
		this.imageurl = imageurl;
		this.isdelete = isdelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDeepth() {
		return this.deepth;
	}

	public void setDeepth(Integer deepth) {
		this.deepth = deepth;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(Integer displayorder) {
		this.displayorder = displayorder;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public Boolean getIsdelete() {
		return this.isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

}