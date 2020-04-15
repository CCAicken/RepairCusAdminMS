package business.dao;

import java.util.List;

import model.TCar;
import model.VCar;

public interface CarDAO {
	/**
	 * 根据条件获取车辆
	 * 
	 * @return List
	 */
	public List<TCar> getTCarList(String opreation);

	/**
	 * 添加车辆
	 * 
	 * @param TCar
	 *            车辆实体
	 * @return 车辆id
	 * 
	 */

	public int addTCar(TCar TCar);

	/**
	 * 删除车辆
	 * 
	 * @param id
	 *            车辆id
	 * @return true false
	 */
	public boolean delTCar(int id);

	/**
	 * 修改车辆
	 * 
	 * @param TCar
	 *            车辆实体
	 * @return true false
	 */
	public boolean updateTCar(TCar TCar);

	/**
	 * 根据车辆id查询
	 * 
	 * @param TCarid
	 *            车辆id
	 * @return 车辆实体
	 */
	public TCar getTCarByid(int TCarid);

	/**
	 * 根据查询分页获取车辆信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VCar> selectCarByPage(String opretion, int page, int limit);

	/**
	 * 车辆数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCarAmount(String opretion);
}
