package business.dao;

import java.util.List;

import model.TSystemMenu;
import model.VRoleSysModel;

public interface SystemMenuDAO {
	/**
	 * 获取网站所有的菜单项列表
	 * 
	 * @return
	 */
	public List<TSystemMenu> getTSystemMenuList();

	/**
	 * 按照角色选择获取对应的菜单项列表
	 * 
	 * @param roleid
	 * @return List<VRoleSystemModel>
	 */
	public List<VRoleSysModel> geTSystemMenuByRole(int roleid);

	/**
	 * 根据菜单id 改变菜单是否删除
	 * 
	 * @param rolemodelid
	 * @return true or false
	 */
	public boolean changeRoleModelState(int rolemodelid);

	/**
	 * 根据一级菜单编号获取二级菜单
	 * 
	 * @param id
	 * @return
	 */
	public List<TSystemMenu> getMenuByParentId(int id);
}
