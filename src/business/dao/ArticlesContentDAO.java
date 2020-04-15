package business.dao;

import java.util.List;

import model.TArticlesContent;
import model.VArticlesContent;

public interface ArticlesContentDAO {
	/**
	 * 根据条件获取文章内容
	 * 
	 * @return List
	 */
	public List<TArticlesContent> getTArticlesContentList(String opreation);

	/**
	 * 添加文章内容
	 * 
	 * @param TArticlesContent
	 *            文章实体
	 * @return 文章id
	 * 
	 */

	public int addTArticlesContent(TArticlesContent TArticlesContent);

	/**
	 * 删除文章内容
	 * 
	 * @param id
	 *            文章内容id
	 * @return true false
	 */
	public boolean delTArticlesContent(int id);

	/**
	 * 修改文章内容
	 * 
	 * @param TArticlesContent
	 *            文章内容实体
	 * @return true false
	 */
	public boolean updateTArticlesContent(TArticlesContent TArticlesContent);

	/**
	 * 根据文章内容id查询
	 * 
	 * @param TArticlesContentid
	 *            文章内容id
	 * @return 文章内容实体
	 */
	public TArticlesContent getTArticlesContentByid(int TArticlesContentid);

	/**
	 * 根据文章id查询文章内容
	 * 
	 * @param TArticlesid
	 *            文章id
	 * @return 文章内容实体
	 */
	public List<TArticlesContent> getTArticlesContentByParentid(int TArticlesid);

	/**
	 * 根据文章id查询文章内容
	 * 
	 * @param TArticlesid
	 *            文章id
	 * @return 文章内容实体
	 */
	public List<VArticlesContent> getVArticlesContentByParentid(int TArticlesid);

}
