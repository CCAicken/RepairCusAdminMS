package business.dao;

import java.util.List;

import model.TRole;

public interface RoleDAO {
	/**
	 * ����������ȡ����Ա��ɫ�б�
	 * 
	 * @return List
	 */
	public List<TRole> getaAdminUserList(String opreation);

	/**
	 * ���ݹ���Ա��ɫid ɾ����ɫ
	 * 
	 * @return true or false
	 */
	public boolean delAdminRole(TRole role);

	/**
	 * ��ӹ���Ա��ɫͬʱ���Ȩ��
	 * 
	 * @return true or false
	 */
	public boolean addAdminRole(TRole role);

	/**
	 * �༭����Ա��ɫ
	 * 
	 * @return true or false
	 */
	public boolean edlAdminRole(TRole role);

	/**
	 * ��ӹ���Ա��ɫ
	 * 
	 * @return true or false
	 */
	public boolean addRole(TRole role);
}
