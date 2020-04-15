package business.dao;

import java.util.List;

import model.TArticlesType;

public interface ArticlesTypeDAO {
	/**
	 * ����������ȡ��������
	 * 
	 * @return List
	 */
	public List<TArticlesType> getTArticlesTypeList(String opreation);

	/**
	 * �����������
	 * 
	 * @param TArticlesType
	 *            ��������ʵ��
	 * @return ��������id
	 * 
	 */

	public int addTArticlesType(TArticlesType TArticlesType);

	/**
	 * ɾ����������
	 * 
	 * @param id
	 *            ��������id
	 * @return true false
	 */
	public boolean delTArticlesType(int id);

	/**
	 * �޸���������
	 * 
	 * @param TArticlesType
	 *            ��������ʵ��
	 * @return true false
	 */
	public boolean updateTArticlesType(TArticlesType TArticlesType);

	/**
	 * ������������id��ѯ
	 * 
	 * @param TArticlesTypeid
	 *            ��������id
	 * @return ��������ʵ��
	 */
	public TArticlesType getTArticlesTypeByid(int TArticlesTypeid);

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
	public List<TArticlesType> selectTArticlesTypeByPage(String opretion,
			int page, int limit);

	/**
	 * ��������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTArticlesAmount(String opretion);
}
