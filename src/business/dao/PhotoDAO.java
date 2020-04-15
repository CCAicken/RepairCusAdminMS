package business.dao;

import java.util.List;

import model.TPhoto;

public interface PhotoDAO {
	/**
	 * ����������ȡͼƬ
	 * 
	 * @return List
	 */
	public List<TPhoto> getTPhotoList(String opreation);

	/**
	 * ���ͼƬ
	 * 
	 * @param TPhoto
	 *            ͼƬʵ��
	 * @return ͼƬid
	 * 
	 */

	public int addTPhoto(TPhoto TPhoto);

	/**
	 * ɾ��ͼƬ
	 * 
	 * @param id
	 *            ͼƬid
	 * @return true false
	 */
	public boolean delTPhoto(int id);

	/**
	 * �޸�ͼƬ
	 * 
	 * @param TPhoto
	 *            ͼƬʵ��
	 * @return true false
	 */
	public boolean updateTPhoto(TPhoto TPhoto);

	/**
	 * ����ͼƬid��ѯ
	 * 
	 * @param TPhotoid
	 *            ͼƬid
	 * @return ͼƬʵ��
	 */
	public TPhoto getTPhotoByid(int TPhotoid);

	/**
	 * ���ݲ�ѯ��ҳ��ȡͼƬ��Ϣ
	 * 
	 * @param
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @return
	 */
	public List<TPhoto> selectTPhotoByPage(String opretion, int page, int limit);

	/**
	 * ͼƬ����
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTPhotoAmount(String opretion);
}
