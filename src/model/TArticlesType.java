package model;

/**
 * TArticlesType entity. @author MyEclipse Persistence Tools
 */

public class TArticlesType implements java.io.Serializable {

	// Fields

	private Integer articlestypeid;
	private String articlestypename;
	private Boolean state;

	// Constructors

	/** default constructor */
	public TArticlesType() {
	}

	/** full constructor */
	public TArticlesType(String articlestypename, Boolean state) {
		this.articlestypename = articlestypename;
		this.state = state;
	}

	// Property accessors

	public Integer getArticlestypeid() {
		return this.articlestypeid;
	}

	public void setArticlestypeid(Integer articlestypeid) {
		this.articlestypeid = articlestypeid;
	}

	public String getArticlestypename() {
		return this.articlestypename;
	}

	public void setArticlestypename(String articlestypename) {
		this.articlestypename = articlestypename;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}