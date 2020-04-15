package business.dao;

import java.util.List;

import model.TUser;
import model.VUser;

public interface UserDAO {
	/**
	 * 根据条件获取员工
	 * 
	 * @return List
	 */
	public List<TUser> getTUserList(String opreation);

	/**
	 * 添加员工
	 * 
	 * @param TUser
	 *            员工实体
	 * @return 员工id
	 * 
	 */

	public String addTUser(TUser TUser);

	/**
	 * 删除员工
	 * 
	 * @param id
	 *            员工id
	 * @return true false
	 */
	public boolean delTUser(String id);

	/**
	 * 修改员工
	 * 
	 * @param TUser
	 *            员工实体
	 * @return true false
	 */
	public boolean updateTUser(TUser TUser);

	/**
	 * 根据员工id查询
	 * 
	 * @param TUserid
	 *            员工id
	 * @return 员工实体
	 */
	public TUser getTUserByid(int TUserid);

	/**
	 * 根据查询分页获取用户信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VUser> selectUserByPage(String opretion, int page, int limit);

	/**
	 * 员工数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getUserAmount(String opretion);

	/**
	 * 实现用户登录
	 * 
	 * @param user
	 * @return
	 */
	public VUser login(VUser user);
}
