package business.dao;

import java.util.List;

import model.TRole;

public interface RoleDAO {
	/**
	 * 根据条件获取管理员角色列表
	 * 
	 * @return List
	 */
	public List<TRole> getaAdminUserList(String opreation);

	/**
	 * 根据管理员角色id 删除角色
	 * 
	 * @return true or false
	 */
	public boolean delAdminRole(TRole role);

	/**
	 * 添加管理员角色同时添加权限
	 * 
	 * @return true or false
	 */
	public boolean addAdminRole(TRole role);

	/**
	 * 编辑管理员角色
	 * 
	 * @return true or false
	 */
	public boolean edlAdminRole(TRole role);

	/**
	 * 添加管理员角色
	 * 
	 * @return true or false
	 */
	public boolean addRole(TRole role);
}
