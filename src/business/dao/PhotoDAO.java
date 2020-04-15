package business.dao;

import java.util.List;

import model.TPhoto;

public interface PhotoDAO {
	/**
	 * 根据条件获取图片
	 * 
	 * @return List
	 */
	public List<TPhoto> getTPhotoList(String opreation);

	/**
	 * 添加图片
	 * 
	 * @param TPhoto
	 *            图片实体
	 * @return 图片id
	 * 
	 */

	public int addTPhoto(TPhoto TPhoto);

	/**
	 * 删除图片
	 * 
	 * @param id
	 *            图片id
	 * @return true false
	 */
	public boolean delTPhoto(int id);

	/**
	 * 修改图片
	 * 
	 * @param TPhoto
	 *            图片实体
	 * @return true false
	 */
	public boolean updateTPhoto(TPhoto TPhoto);

	/**
	 * 根据图片id查询
	 * 
	 * @param TPhotoid
	 *            图片id
	 * @return 图片实体
	 */
	public TPhoto getTPhotoByid(int TPhotoid);

	/**
	 * 根据查询分页获取图片信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<TPhoto> selectTPhotoByPage(String opretion, int page, int limit);

	/**
	 * 图片数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getTPhotoAmount(String opretion);
}
