package model;

/**
 * TArticlesContent entity. @author MyEclipse Persistence Tools
 */

public class TArticlesContent implements java.io.Serializable {

	// Fields

	private Integer articlescontentid;
	private Integer articlesid;
	private Integer ordernum;
	private Integer photoid;
	private Boolean issign;
	private Boolean state;
	private String articlesidcontent;

	// Constructors

	/** default constructor */
	public TArticlesContent() {
	}

	/** full constructor */
	public TArticlesContent(Integer articlesid, Integer ordernum,
			Integer photoid, Boolean issign, Boolean state,
			String articlesidcontent) {
		this.articlesid = articlesid;
		this.ordernum = ordernum;
		this.photoid = photoid;
		this.issign = issign;
		this.state = state;
		this.articlesidcontent = articlesidcontent;
	}

	// Property accessors

	public Integer getArticlescontentid() {
		return this.articlescontentid;
	}

	public void setArticlescontentid(Integer articlescontentid) {
		this.articlescontentid = articlescontentid;
	}

	public Integer getArticlesid() {
		return this.articlesid;
	}

	public void setArticlesid(Integer articlesid) {
		this.articlesid = articlesid;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public Boolean getIssign() {
		return this.issign;
	}

	public void setIssign(Boolean issign) {
		this.issign = issign;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getArticlesidcontent() {
		return this.articlesidcontent;
	}

	public void setArticlesidcontent(String articlesidcontent) {
		this.articlesidcontent = articlesidcontent;
	}

}