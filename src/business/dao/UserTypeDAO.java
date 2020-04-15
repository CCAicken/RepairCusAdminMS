package business.dao;

import java.util.List;

import model.TUserType;

public interface UserTypeDAO {
	/**
	 * 根据条件获取员工职位
	 * 
	 * @return List
	 */
	public List<TUserType> getTUserTypeList(String opreation);

	/**
	 * 添加员工职位
	 * 
	 * @param TUserType
	 *            员工职位实体
	 * @return 员工职位id
	 * 
	 */

	public int addTUserType(TUserType TUserType);

	/**
	 * 删除员工职位
	 * 
	 * @param id
	 *            员工职位id
	 * @return true false
	 */
	public boolean delTUserType(int id);

	/**
	 * 修改员工职位
	 * 
	 * @param TUserType
	 *            员工职位实体
	 * @return true false
	 */
	public boolean updateTUserType(TUserType TUserType);

	/**
	 * 根据员工职位id查询
	 * 
	 * @param TUserTypeid
	 *            员工职位id
	 * @return 员工职位实体
	 */
	public TUserType getTUserTypeByid(int TUserTypeid);

}
