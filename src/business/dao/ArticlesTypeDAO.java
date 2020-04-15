package business.dao;

import java.util.List;

import model.TArticlesType;

public interface ArticlesTypeDAO {
	/**
	 * 根据条件获取文章类型
	 * 
	 * @return List
	 */
	public List<TArticlesType> getTArticlesTypeList(String opreation);

	/**
	 * 添加文章类型
	 * 
	 * @param TArticlesType
	 *            文章类型实体
	 * @return 文章类型id
	 * 
	 */

	public int addTArticlesType(TArticlesType TArticlesType);

	/**
	 * 删除文章类型
	 * 
	 * @param id
	 *            文章类型id
	 * @return true false
	 */
	public boolean delTArticlesType(int id);

	/**
	 * 修改文章类型
	 * 
	 * @param TArticlesType
	 *            文章类型实体
	 * @return true false
	 */
	public boolean updateTArticlesType(TArticlesType TArticlesType);

	/**
	 * 根据文章类型id查询
	 * 
	 * @param TArticlesTypeid
	 *            文章类型id
	 * @return 文章类型实体
	 */
	public TArticlesType getTArticlesTypeByid(int TArticlesTypeid);

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
	public List<TArticlesType> selectTArticlesTypeByPage(String opretion,
			int page, int limit);

	/**
	 * 文章数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTArticlesAmount(String opretion);
}
