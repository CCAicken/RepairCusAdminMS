package business.dao;

import java.util.List;

import model.TArticles;
import model.VArticles;

public interface ArticlesDAO {
	/**
	 * 根据条件获取文章
	 * 
	 * @return List
	 */
	public List<TArticles> getTArticlesList(String opreation);

	/**
	 * 添加文章
	 * 
	 * @param TArticles
	 *            文章实体
	 * @return 文章id
	 * 
	 */

	public int addTArticles(TArticles TArticles);

	/**
	 * 删除文章
	 * 
	 * @param id
	 *            文章id
	 * @return true false
	 */
	public boolean delTArticles(int id);

	/**
	 * 修改文章
	 * 
	 * @param TArticles
	 *            文章实体
	 * @return true false
	 */
	public boolean updateTArticles(TArticles TArticles);

	/**
	 * 根据文章id查询
	 * 
	 * @param TArticlesid
	 *            文章id
	 * @return 文章实体
	 */
	public TArticles getTArticlesByid(int TArticlesid);

	/**
	 * 根据查询分页获取文章信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VArticles> selectTArticlesByPage(String opretion, int page,
			int limit);

	/**
	 * 文章数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTArticlesAmount(String opretion);
}
