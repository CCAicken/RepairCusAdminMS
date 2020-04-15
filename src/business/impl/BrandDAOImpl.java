package business.impl;

import java.util.List;

import model.TBrand;
import model.VBrand;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.BrandDAO;

import common.properties.OperType;

@Component("branddao")
public class BrandDAOImpl implements BrandDAO {

	private iHibBaseDAO bdao;

	public BrandDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据条件查询品牌")
	@Override
	public List<TBrand> getTBrandList(String opreation) {
		String hql = "from TBrand ";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by brandid";
		return bdao.select(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加品牌")
	@Override
	public int addTBrand(TBrand TBrand) {
		return (int) bdao.insert(TBrand);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除品牌")
	@Override
	public boolean delTBrand(int id) {
		// TODO Auto-generated method stub
		TBrand TBrand = (TBrand) bdao.findById(TBrand.class, id);

		return bdao.delete(TBrand);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新品牌")
	@Override
	public boolean updateTBrand(TBrand TBrand) {
		return bdao.update(TBrand);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据品牌id查询")
	@Override
	public VBrand getTBrandByid(int TBrandid) {
		// TODO Auto-generated method stub
		return (VBrand) bdao.findById(TBrand.class, TBrandid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询车辆类型信息")
	@Override
	public List<VBrand> selectBrandByPage(String opretion, int page, int limit) {
		String hql = "from VBrand ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by brandid";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getBrandAmount(String opretion) {
		String hql = "select count(brandid) from VBrand ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
