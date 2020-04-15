package business.dao;

import java.util.List;

import model.TRoleSysModel;

public interface RoleSysModelDAO {
	/**
	 * ����������ȡ��ɫ�˵���ϵ
	 * 
	 * @return List
	 */
	public List<TRoleSysModel> getTRoleSysModelList(String opreation);

	/**
	 * ��ӽ�ɫ�˵���ϵ
	 * 
	 * @param TRoleSysModel
	 *            ��ɫ�˵���ϵʵ��
	 * @return ��ɫ�˵���ϵid
	 * 
	 */

	public int addTRoleSysModel(TRoleSysModel TRoleSysModel);

	/**
	 * ɾ����ɫ�˵���ϵ
	 * 
	 * @param id
	 *            ��ɫ�˵���ϵid
	 * @return true false
	 */
	public boolean delTRoleSysModel(int id);

	/**
	 * �޸Ľ�ɫ�˵���ϵ
	 * 
	 * @param TRoleSysModel
	 *            ��ɫ�˵���ϵʵ��
	 * @return true false
	 */
	public boolean updateTRoleSysModel(TRoleSysModel TRoleSysModel);

	/**
	 * ���ݽ�ɫ�˵���ϵid��ѯ
	 * 
	 * @param TRoleSysModelid
	 *            ��ɫ�˵���ϵid
	 * @return ��ɫ�˵���ϵʵ��
	 */
	public TRoleSysModel getTRoleSysModelByid(int TRoleSysModelid);

	/**
	 * ����Ȩ��
	 * 
	 * @param rolemodel
	 *            Ȩ�޶�Ӧʵ��
	 * @return
	 */
	public boolean updataRoleModel(int rolemodelid);
}
