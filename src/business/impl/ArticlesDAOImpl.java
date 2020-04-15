package business.impl;

import java.util.List;

import model.TArticles;
import model.VArticles;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArticlesDAO;

import common.properties.OperType;

@Component("articlesdao")
public class ArticlesDAOImpl implements ArticlesDAO {
	private iHibBaseDAO bdao;

	public ArticlesDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ����")
	@Override
	public List<TArticles> getTArticlesList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "�������")
	@Override
	public int addTArticles(TArticles TArticles) {
		return (int) bdao.insert(TArticles);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ������")
	@Override
	public boolean delTArticles(int id) {
		// TODO Auto-generated method stub
		TArticles TArticles = (TArticles) bdao.findById(TArticles.class, id);

		return bdao.delete(TArticles);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "��������")
	@Override
	public boolean updateTArticles(TArticles TArticles) {
		return bdao.update(TArticles);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "��������id��ѯ")
	@Override
	public TArticles getTArticlesByid(int TArticlesid) {
		// TODO Auto-generated method stub
		return (TArticles) bdao.findById(TArticles.class, TArticlesid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯ������Ϣ")
	@Override
	public List<VArticles> selectTArticlesByPage(String opretion, int page,
			int limit) {
		String hql = "from VArticles ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by articlesid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getTArticlesAmount(String opretion) {
		String hql = "select count(articlesid) from VArticles ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
