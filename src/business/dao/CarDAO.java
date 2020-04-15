package business.dao;

import java.util.List;

import model.TCar;
import model.VCar;

public interface CarDAO {
	/**
	 * ����������ȡ����
	 * 
	 * @return List
	 */
	public List<TCar> getTCarList(String opreation);

	/**
	 * ��ӳ���
	 * 
	 * @param TCar
	 *            ����ʵ��
	 * @return ����id
	 * 
	 */

	public int addTCar(TCar TCar);

	/**
	 * ɾ������
	 * 
	 * @param id
	 *            ����id
	 * @return true false
	 */
	public boolean delTCar(int id);

	/**
	 * �޸ĳ���
	 * 
	 * @param TCar
	 *            ����ʵ��
	 * @return true false
	 */
	public boolean updateTCar(TCar TCar);

	/**
	 * ���ݳ���id��ѯ
	 * 
	 * @param TCarid
	 *            ����id
	 * @return ����ʵ��
	 */
	public TCar getTCarByid(int TCarid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ������Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VCar> selectCarByPage(String opretion, int page, int limit);

	/**
	 * ��������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getCarAmount(String opretion);
}
