package business.dao;

import java.util.List;

import model.TCarType;

public interface CarTypeDAO {
	/**
	 * ����������ȡ��������
	 * 
	 * @return List
	 */
	public List<TCarType> getTCarTypeList(String opreation);

	/**
	 * ��ӳ�������
	 * 
	 * @param TCarType
	 *            ��������ʵ��
	 * @return ��������id
	 * 
	 */

	public int addTCarType(TCarType TCarType);

	/**
	 * ɾ����������
	 * 
	 * @param id
	 *            ��������id
	 * @return true false
	 */
	public boolean delTCarType(int id);

	/**
	 * �޸ĳ�������
	 * 
	 * @param TCarType
	 *            ��������ʵ��
	 * @return true false
	 */
	public boolean updateTCarType(TCarType TCarType);

	/**
	 * ���ݳ�������id��ѯ
	 * 
	 * @param TCarTypeid
	 *            ��������id
	 * @return ��������ʵ��
	 */
	public TCarType getTCarTypeByid(int TCarTypeid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ����������Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<TCarType> selectCarTypeByPage(String opretion, int page,
			int limit);

	/**
	 * ����Ʒ������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTCarTypeAmount(String opretion);

}
