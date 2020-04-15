package business.dao;

import java.util.List;

import model.TCustomer;
import model.TCustomerCar;
import model.VCustomerCar;

public interface CustomerDAO {
	/**
	 * 根据条件获取客户
	 * 
	 * @return List
	 */
	public List<TCustomer> getTCustomerList(String opreation);

	/**
	 * 添加客户
	 * 
	 * @param TCustomer
	 *            客户实体
	 * @return 客户id
	 * 
	 */

	public String addTCustomer(TCustomer TCustomer);

	/**
	 * 删除客户
	 * 
	 * @param id
	 *            客户id
	 * @return true false
	 */
	public boolean delTCustomer(String id);

	/**
	 * 修改客户
	 * 
	 * @param TCustomer
	 *            客户实体
	 * @return true false
	 */
	public boolean updateTCustomer(TCustomer TCustomer);

	/**
	 * 根据客户id查询
	 * 
	 * @param TCustomerid
	 *            客户id
	 * @return 客户实体
	 */
	public TCustomer getTCustomerByid(int TCustomerid);

	/**
	 * 根据查询分页获取客户信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<TCustomer> selectCustomerByPage(String opretion, int page,
			int limit);

	/**
	 * 客户数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCustomerAmount(String opretion);

	/**
	 * 添加客户车辆
	 * 
	 * @param TCustomercar
	 *            客户car实体
	 * @return 客户carid
	 * 
	 */

	public int addTCustomerCar(TCustomerCar TCustomercar);

	/**
	 * 删除客户车辆
	 * 
	 * @param id
	 *            客户车辆id
	 * @return true false
	 */
	public boolean delTCustomerCar(int id);

	/**
	 * 修改客户车辆
	 * 
	 * @param TCustomerCar
	 *            客户车辆实体
	 * @return true false
	 */
	public boolean updateTCustomerCar(TCustomerCar TCustomercar);

	/**
	 * 根据客户车辆id查询
	 * 
	 * @param TCustomercarid
	 *            客户车辆id
	 * @return 客户车辆实体
	 */
	public TCustomerCar getTCustomerCarByid(int TCustomerCarid);

	/**
	 * 根据查询分页获取客户车辆信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VCustomerCar> selectCustomerCarByPage(String opretion,
			int page, int limit);

	/**
	 * 客户车辆数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCustomerCarAmount(String opretion);
}
