package business.dao;

import java.util.List;

import model.TBrand;
import model.VBrand;

public interface BrandDAO {
	/**
	 * 根据条件获取品牌
	 * 
	 * @return List
	 */
	public List<TBrand> getTBrandList(String opreation);

	/**
	 * 添加品牌
	 * 
	 * @param TBrand
	 *            品牌实体
	 * @return 品牌id
	 * 
	 */

	public int addTBrand(TBrand TBrand);

	/**
	 * 删除品牌
	 * 
	 * @param id
	 *            品牌id
	 * @return true false
	 */
	public boolean delTBrand(int id);

	/**
	 * 修改品牌
	 * 
	 * @param TBrand
	 *            品牌实体
	 * @return true false
	 */
	public boolean updateTBrand(TBrand TBrand);

	/**
	 * 根据品牌id查询
	 * 
	 * @param TBrandid
	 *            品牌id
	 * @return 品牌实体
	 */
	public VBrand getTBrandByid(int TBrandid);

	/**
	 * 根据查询分页获取车辆品牌信息
	 * 
	 * @param
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @return
	 */
	public List<VBrand> selectBrandByPage(String opretion, int page, int limit);

	/**
	 * 车辆品牌数量
	 * 
	 * @param opretion
	 * @return
	 */
	public int getBrandAmount(String opretion);
}
