package business.dao;

import java.util.List;

import model.TUser;
import model.VUser;

public interface UserDAO {
	/**
	 * ����������ȡԱ��
	 * 
	 * @return List
	 */
	public List<TUser> getTUserList(String opreation);

	/**
	 * ���Ա��
	 * 
	 * @param TUser
	 *            Ա��ʵ��
	 * @return Ա��id
	 * 
	 */

	public String addTUser(TUser TUser);

	/**
	 * ɾ��Ա��
	 * 
	 * @param id
	 *            Ա��id
	 * @return true false
	 */
	public boolean delTUser(String id);

	/**
	 * �޸�Ա��
	 * 
	 * @param TUser
	 *            Ա��ʵ��
	 * @return true false
	 */
	public boolean updateTUser(TUser TUser);

	/**
	 * ����Ա��id��ѯ
	 * 
	 * @param TUserid
	 *            Ա��id
	 * @return Ա��ʵ��
	 */
	public TUser getTUserByid(int TUserid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ�û���Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VUser> selectUserByPage(String opretion, int page, int limit);

	/**
	 * Ա������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getUserAmount(String opretion);

	/**
	 * ʵ���û���¼
	 * 
	 * @param user
	 * @return
	 */
	public VUser login(VUser user);
}
