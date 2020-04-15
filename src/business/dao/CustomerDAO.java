package business.dao;

import java.util.List;

import model.TCustomer;
import model.TCustomerCar;
import model.VCustomerCar;

public interface CustomerDAO {
	/**
	 * ����������ȡ�ͻ�
	 * 
	 * @return List
	 */
	public List<TCustomer> getTCustomerList(String opreation);

	/**
	 * ��ӿͻ�
	 * 
	 * @param TCustomer
	 *            �ͻ�ʵ��
	 * @return �ͻ�id
	 * 
	 */

	public String addTCustomer(TCustomer TCustomer);

	/**
	 * ɾ���ͻ�
	 * 
	 * @param id
	 *            �ͻ�id
	 * @return true false
	 */
	public boolean delTCustomer(String id);

	/**
	 * �޸Ŀͻ�
	 * 
	 * @param TCustomer
	 *            �ͻ�ʵ��
	 * @return true false
	 */
	public boolean updateTCustomer(TCustomer TCustomer);

	/**
	 * ���ݿͻ�id��ѯ
	 * 
	 * @param TCustomerid
	 *            �ͻ�id
	 * @return �ͻ�ʵ��
	 */
	public TCustomer getTCustomerByid(int TCustomerid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ�ͻ���Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<TCustomer> selectCustomerByPage(String opretion, int page,
			int limit);

	/**
	 * �ͻ�����
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCustomerAmount(String opretion);

	/**
	 * ��ӿͻ�����
	 * 
	 * @param TCustomercar
	 *            �ͻ�carʵ��
	 * @return �ͻ�carid
	 * 
	 */

	public int addTCustomerCar(TCustomerCar TCustomercar);

	/**
	 * ɾ���ͻ�����
	 * 
	 * @param id
	 *            �ͻ�����id
	 * @return true false
	 */
	public boolean delTCustomerCar(int id);

	/**
	 * �޸Ŀͻ�����
	 * 
	 * @param TCustomerCar
	 *            �ͻ�����ʵ��
	 * @return true false
	 */
	public boolean updateTCustomerCar(TCustomerCar TCustomercar);

	/**
	 * ���ݿͻ�����id��ѯ
	 * 
	 * @param TCustomercarid
	 *            �ͻ�����id
	 * @return �ͻ�����ʵ��
	 */
	public TCustomerCar getTCustomerCarByid(int TCustomerCarid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ�ͻ�������Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VCustomerCar> selectCustomerCarByPage(String opretion,
			int page, int limit);

	/**
	 * �ͻ���������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCustomerCarAmount(String opretion);
}
