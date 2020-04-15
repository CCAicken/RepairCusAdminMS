package business.dao;

import java.util.List;

import model.TSystemMenu;
import model.VRoleSysModel;

public interface SystemMenuDAO {
	/**
	 * ��ȡ��վ���еĲ˵����б�
	 * 
	 * @return
	 */
	public List<TSystemMenu> getTSystemMenuList();

	/**
	 * ���ս�ɫѡ���ȡ��Ӧ�Ĳ˵����б�
	 * 
	 * @param roleid
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSysModel> geTSystemMenuByRole(int roleid);

	/**
	 * ���ݲ˵�id �ı�˵��Ƿ�ɾ��
	 * 
	 * @param rolemodelid
	 * @return true or false
	 */
	public boolean changeRoleModelState(int rolemodelid);

	/**
	 * ����һ���˵���Ż�ȡ�����˵�
	 * 
	 * @param id
	 * @return
	 */
	public List<TSystemMenu> getMenuByParentId(int id);
}
