package business.dao;

import java.util.List;

import model.TArticlesContent;
import model.VArticlesContent;

public interface ArticlesContentDAO {
	/**
	 * ����������ȡ��������
	 * 
	 * @return List
	 */
	public List<TArticlesContent> getTArticlesContentList(String opreation);

	/**
	 * �����������
	 * 
	 * @param TArticlesContent
	 *            ����ʵ��
	 * @return ����id
	 * 
	 */

	public int addTArticlesContent(TArticlesContent TArticlesContent);

	/**
	 * ɾ����������
	 * 
	 * @param id
	 *            ��������id
	 * @return true false
	 */
	public boolean delTArticlesContent(int id);

	/**
	 * �޸���������
	 * 
	 * @param TArticlesContent
	 *            ��������ʵ��
	 * @return true false
	 */
	public boolean updateTArticlesContent(TArticlesContent TArticlesContent);

	/**
	 * ������������id��ѯ
	 * 
	 * @param TArticlesContentid
	 *            ��������id
	 * @return ��������ʵ��
	 */
	public TArticlesContent getTArticlesContentByid(int TArticlesContentid);

	/**
	 * ��������id��ѯ��������
	 * 
	 * @param TArticlesid
	 *            ����id
	 * @return ��������ʵ��
	 */
	public List<TArticlesContent> getTArticlesContentByParentid(int TArticlesid);

	/**
	 * ��������id��ѯ��������
	 * 
	 * @param TArticlesid
	 *            ����id
	 * @return ��������ʵ��
	 */
	public List<VArticlesContent> getVArticlesContentByParentid(int TArticlesid);

}
