package business.dao;

import java.util.List;

import model.TArticles;
import model.VArticles;

public interface ArticlesDAO {
	/**
	 * ����������ȡ����
	 * 
	 * @return List
	 */
	public List<TArticles> getTArticlesList(String opreation);

	/**
	 * �������
	 * 
	 * @param TArticles
	 *            ����ʵ��
	 * @return ����id
	 * 
	 */

	public int addTArticles(TArticles TArticles);

	/**
	 * ɾ������
	 * 
	 * @param id
	 *            ����id
	 * @return true false
	 */
	public boolean delTArticles(int id);

	/**
	 * �޸�����
	 * 
	 * @param TArticles
	 *            ����ʵ��
	 * @return true false
	 */
	public boolean updateTArticles(TArticles TArticles);

	/**
	 * ��������id��ѯ
	 * 
	 * @param TArticlesid
	 *            ����id
	 * @return ����ʵ��
	 */
	public TArticles getTArticlesByid(int TArticlesid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ������Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VArticles> selectTArticlesByPage(String opretion, int page,
			int limit);

	/**
	 * ��������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTArticlesAmount(String opretion);
}
