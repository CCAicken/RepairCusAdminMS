package business.dao;

import java.util.List;

import model.TAppointment;
import model.TCustomerApp;
import model.VAppointment;

public interface AppointmentDAO {
	/**
	 * 根据条件获取预约单
	 * 
	 * @return List
	 */
	public List<TAppointment> getTAppointmentList(String opreation);

	/**
	 * 添加预约单
	 * 
	 * @param tappointment
	 *            预约实体
	 * @return 预约id
	 * 
	 */

	public int addTAppointment(TAppointment tappointment);

	/**
	 * 删除预约单
	 * 
	 * @param id
	 *            预约单id
	 * @return true false
	 */
	public boolean delTAppointment(int id);

	/**
	 * 修改预约单
	 * 
	 * @param tappointment
	 *            预约单实体
	 * @return true false
	 */
	public boolean updateTAppointment(TAppointment tappointment);

	/**
	 * 根据预约单id查询
	 * 
	 * @param tappointmentid
	 *            预约单id
	 * @return 预约单实体
	 */
	public TAppointment getTAppointmentByid(int tappointmentid);

	/**
	 * 根据查询保养预约单信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<TAppointment> selectAppMainByPage(String opretion, int page,
			int limit);

	/**
	 * 保养预约单数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getAppMainAmount(String opretion);

	/**
	 * 根据查询维修预约单信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<TAppointment> selectAppRepairByPage(String opretion, int page,
			int limit);

	/**
	 * 维修预约单数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getAppRepairAmount(String opretion);

	/**
	 * 添加客户预约单
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean addCustomerApp(TCustomerApp customerapp);

	/**
	 * 删除客户预约单
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean delCustomerApp(int customerappid);

	/**
	 * 更新客户预约单
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean updateCustomerApp(TCustomerApp customerapp);

	/**
	 * 根据客户预约单预约单信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VAppointment> selectCustomAppByPage(String opretion, int page,
			int limit);

	/**
	 * 获取客户预约单数量
	 * 
	 * @param opretion
	 *            查询条件
	 * @return
	 */
	public int getCustomAppAmount(String opretion);
}
