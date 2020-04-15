package business.dao;

import java.util.List;

import model.TUserType;

public interface UserTypeDAO {
	/**
	 * ����������ȡԱ��ְλ
	 * 
	 * @return List
	 */
	public List<TUserType> getTUserTypeList(String opreation);

	/**
	 * ���Ա��ְλ
	 * 
	 * @param TUserType
	 *            Ա��ְλʵ��
	 * @return Ա��ְλid
	 * 
	 */

	public int addTUserType(TUserType TUserType);

	/**
	 * ɾ��Ա��ְλ
	 * 
	 * @param id
	 *            Ա��ְλid
	 * @return true false
	 */
	public boolean delTUserType(int id);

	/**
	 * �޸�Ա��ְλ
	 * 
	 * @param TUserType
	 *            Ա��ְλʵ��
	 * @return true false
	 */
	public boolean updateTUserType(TUserType TUserType);

	/**
	 * ����Ա��ְλid��ѯ
	 * 
	 * @param TUserTypeid
	 *            Ա��ְλid
	 * @return Ա��ְλʵ��
	 */
	public TUserType getTUserTypeByid(int TUserTypeid);

}
