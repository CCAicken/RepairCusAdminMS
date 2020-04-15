package business.dao;

import java.util.List;

import model.TAppointment;
import model.TCustomerApp;
import model.VAppointment;

public interface AppointmentDAO {
	/**
	 * ����������ȡԤԼ��
	 * 
	 * @return List
	 */
	public List<TAppointment> getTAppointmentList(String opreation);

	/**
	 * ���ԤԼ��
	 * 
	 * @param tappointment
	 *            ԤԼʵ��
	 * @return ԤԼid
	 * 
	 */

	public int addTAppointment(TAppointment tappointment);

	/**
	 * ɾ��ԤԼ��
	 * 
	 * @param id
	 *            ԤԼ��id
	 * @return true false
	 */
	public boolean delTAppointment(int id);

	/**
	 * �޸�ԤԼ��
	 * 
	 * @param tappointment
	 *            ԤԼ��ʵ��
	 * @return true false
	 */
	public boolean updateTAppointment(TAppointment tappointment);

	/**
	 * ����ԤԼ��id��ѯ
	 * 
	 * @param tappointmentid
	 *            ԤԼ��id
	 * @return ԤԼ��ʵ��
	 */
	public TAppointment getTAppointmentByid(int tappointmentid);

	/**
	 * ���ݲ�ѯ����ԤԼ����Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<TAppointment> selectAppMainByPage(String opretion, int page,
			int limit);

	/**
	 * ����ԤԼ������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getAppMainAmount(String opretion);

	/**
	 * ���ݲ�ѯά��ԤԼ����Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<TAppointment> selectAppRepairByPage(String opretion, int page,
			int limit);

	/**
	 * ά��ԤԼ������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getAppRepairAmount(String opretion);

	/**
	 * ��ӿͻ�ԤԼ��
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean addCustomerApp(TCustomerApp customerapp);

	/**
	 * ɾ���ͻ�ԤԼ��
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean delCustomerApp(int customerappid);

	/**
	 * ���¿ͻ�ԤԼ��
	 * 
	 * @param customerapp
	 * @return
	 */
	public boolean updateCustomerApp(TCustomerApp customerapp);

	/**
	 * ���ݿͻ�ԤԼ��ԤԼ����Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VAppointment> selectCustomAppByPage(String opretion, int page,
			int limit);

	/**
	 * ��ȡ�ͻ�ԤԼ������
	 * 
	 * @param opretion
	 *            ��ѯ����
	 * @return
	 */
	public int getCustomAppAmount(String opretion);
}
