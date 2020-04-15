package model;


/**
 * TArticles entity. @author MyEclipse Persistence Tools
 */

public class TArticles implements java.io.Serializable {

	// Fields

	private Integer articlesid;
	private String tite;
	private Integer articlestypeid;
	private String description;
	private Integer photoid;
	private Boolean state;
	private String author;
	private String articlescreatetime;

	// Constructors

	/** default constructor */
	public TArticles() {
	}

	/** full constructor */
	public TArticles(String tite, Integer articlestypeid, String description,
			Integer photoid, Boolean state, String author,
			String articlescreatetime) {
		this.tite = tite;
		this.articlestypeid = articlestypeid;
		this.description = description;
		this.photoid = photoid;
		this.state = state;
		this.author = author;
		this.articlescreatetime = articlescreatetime;
	}

	// Property accessors

	public Integer getArticlesid() {
		return this.articlesid;
	}

	public void setArticlesid(Integer articlesid) {
		this.articlesid = articlesid;
	}

	public String getTite() {
		return this.tite;
	}

	public void setTite(String tite) {
		this.tite = tite;
	}

	public Integer getArticlestypeid() {
		return this.articlestypeid;
	}

	public void setArticlestypeid(Integer articlestypeid) {
		this.articlestypeid = articlestypeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPhotoid() {
		return this.photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArticlescreatetime() {
		return this.articlescreatetime;
	}

	public void setArticlescreatetime(String articlescreatetime) {
		this.articlescreatetime = articlescreatetime;
	}

}