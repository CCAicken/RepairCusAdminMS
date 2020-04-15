package business.impl;

import java.util.List;

import model.TArticlesType;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArticlesTypeDAO;

import common.properties.OperType;

@Component("articlestypedao")
public class ArticlesTypeDAOImpl implements ArticlesTypeDAO {

	private iHibBaseDAO bdao;

	public ArticlesTypeDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据条件查询文章类型")
	@Override
	public List<TArticlesType> getTArticlesTypeList(String opreation) {
		String hql = "from TArticlesType ";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by articlestypeid";
		return bdao.select(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加文章类型")
	@Override
	public int addTArticlesType(TArticlesType TArticlesType) {
		return (int) bdao.insert(TArticlesType);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除文章类型")
	@Override
	public boolean delTArticlesType(int id) {
		// TODO Auto-generated method stub
		TArticlesType TArticlesType = (TArticlesType) bdao.findById(
				TArticlesType.class, id);

		return bdao.delete(TArticlesType);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新文章类型")
	@Override
	public boolean updateTArticlesType(TArticlesType TArticlesType) {
		return bdao.update(TArticlesType);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据文章类型id查询")
	@Override
	public TArticlesType getTArticlesTypeByid(int TArticlesTypeid) {
		// TODO Auto-generated method stub
		return (TArticlesType) bdao.findById(TArticlesType.class,
				TArticlesTypeid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询文章类型信息")
	@Override
	public List<TArticlesType> selectTArticlesTypeByPage(String opretion,
			int page, int limit) {
		String hql = "from TArticlesType ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by articlestypeid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getTArticlesAmount(String opretion) {
		String hql = "select count(articlestypeid) from TArticlesType ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
