package business.dao;

import java.util.List;

import model.TBrand;
import model.VBrand;

public interface BrandDAO {
	/**
	 * ����������ȡƷ��
	 * 
	 * @return List
	 */
	public List<TBrand> getTBrandList(String opreation);

	/**
	 * ���Ʒ��
	 * 
	 * @param TBrand
	 *            Ʒ��ʵ��
	 * @return Ʒ��id
	 * 
	 */

	public int addTBrand(TBrand TBrand);

	/**
	 * ɾ��Ʒ��
	 * 
	 * @param id
	 *            Ʒ��id
	 * @return true false
	 */
	public boolean delTBrand(int id);

	/**
	 * �޸�Ʒ��
	 * 
	 * @param TBrand
	 *            Ʒ��ʵ��
	 * @return true false
	 */
	public boolean updateTBrand(TBrand TBrand);

	/**
	 * ����Ʒ��id��ѯ
	 * 
	 * @param TBrandid
	 *            Ʒ��id
	 * @return Ʒ��ʵ��
	 */
	public VBrand getTBrandByid(int TBrandid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡ����Ʒ����Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<VBrand> selectBrandByPage(String opretion, int page, int limit);

	/**
	 * ����Ʒ������
	 * 
	 * @param opretion
	 * @return
	 */
	public int getBrandAmount(String opretion);
}
