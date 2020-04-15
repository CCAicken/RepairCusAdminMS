package business.dao;

import java.util.List;

import model.TCarType;

public interface CarTypeDAO {
	/**
	 * 根据条件获取车辆类型
	 * 
	 * @return List
	 */
	public List<TCarType> getTCarTypeList(String opreation);

	/**
	 * 添加车辆类型
	 * 
	 * @param TCarType
	 *            车辆类型实体
	 * @return 车辆类型id
	 * 
	 */

	public int addTCarType(TCarType TCarType);

	/**
	 * 删除车辆类型
	 * 
	 * @param id
	 *            车辆类型id
	 * @return true false
	 */
	public boolean delTCarType(int id);

	/**
	 * 修改车辆类型
	 * 
	 * @param TCarType
	 *            车辆类型实体
	 * @return true false
	 */
	public boolean updateTCarType(TCarType TCarType);

	/**
	 * 根据车辆类型id查询
	 * 
	 * @param TCarTypeid
	 *            车辆类型id
	 * @return 车辆类型实体
	 */
	public TCarType getTCarTypeByid(int TCarTypeid);

	/**
	 * 根据查询分页获取车辆类型信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<TCarType> selectCarTypeByPage(String opretion, int page,
			int limit);

	/**
	 * 车辆品牌数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTCarTypeAmount(String opretion);

}
