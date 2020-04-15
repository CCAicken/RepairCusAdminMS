package business.dao;

import java.util.List;

import model.TRoleSysModel;

public interface RoleSysModelDAO {
	/**
	 * 根据条件获取角色菜单关系
	 * 
	 * @return List
	 */
	public List<TRoleSysModel> getTRoleSysModelList(String opreation);

	/**
	 * 添加角色菜单关系
	 * 
	 * @param TRoleSysModel
	 *            角色菜单关系实体
	 * @return 角色菜单关系id
	 * 
	 */

	public int addTRoleSysModel(TRoleSysModel TRoleSysModel);

	/**
	 * 删除角色菜单关系
	 * 
	 * @param id
	 *            角色菜单关系id
	 * @return true false
	 */
	public boolean delTRoleSysModel(int id);

	/**
	 * 修改角色菜单关系
	 * 
	 * @param TRoleSysModel
	 *            角色菜单关系实体
	 * @return true false
	 */
	public boolean updateTRoleSysModel(TRoleSysModel TRoleSysModel);

	/**
	 * 根据角色菜单关系id查询
	 * 
	 * @param TRoleSysModelid
	 *            角色菜单关系id
	 * @return 角色菜单关系实体
	 */
	public TRoleSysModel getTRoleSysModelByid(int TRoleSysModelid);

	/**
	 * 更新权限
	 * 
	 * @param rolemodel
	 *            权限对应实体
	 * @return
	 */
	public boolean updataRoleModel(int rolemodelid);
}
