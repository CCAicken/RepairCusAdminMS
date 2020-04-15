package model;


/**
 * VArticles entity. @author MyEclipse Persistence Tools
 */

public class VArticles implements java.io.Serializable {
	// Fields

	private Integer articlesid;
	private String tite;
	private Integer articlestypeid;
	private String description;
	private Integer photoid;
	private Boolean state;
	private String author;
	private String articlescreatetime;
	private String photoname;
	private String articlestypename;

	// Constructors

	/** default constructor */
	public VArticles() {
	}

	/** full constructor */
	public VArticles(Integer articlesid, String tite, Integer articlestypeid,
			String description, Integer photoid, Boolean state, String author,
			String articlescreatetime, String photoname, String articlestypename) {
		this.articlesid = articlesid;
		this.tite = tite;
		this.articlestypeid = articlestypeid;
		this.description = description;
		this.photoid = photoid;
		this.state = state;
		this.author = author;
		this.articlescreatetime = articlescreatetime;
		this.photoname = photoname;
		this.articlestypename = articlestypename;
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

	public String getPhotoname() {
		return this.photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getArticlestypename() {
		return this.articlestypename;
	}

	public void setArticlestypename(String articlestypename) {
		this.articlestypename = articlestypename;
	}

}