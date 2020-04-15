package business.impl;

import java.util.List;

import model.TArticlesContent;
import model.VArticlesContent;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.ArticlesContentDAO;

import common.properties.OperType;

@Component("articlescontentdao")
public class ArticlesContentDAOImpl implements ArticlesContentDAO {
	private iHibBaseDAO bdao;

	public ArticlesContentDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ��������")
	@Override
	public List<TArticlesContent> getTArticlesContentList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "�����������")
	@Override
	public int addTArticlesContent(TArticlesContent TArticlesContent) {
		return (int) bdao.insert(TArticlesContent);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ����������")
	@Override
	public boolean delTArticlesContent(int id) {
		// TODO Auto-generated method stub
		TArticlesContent TArticlesContent = (TArticlesContent) bdao.findById(
				TArticlesContent.class, id);

		return bdao.delete(TArticlesContent);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "������������")
	@Override
	public boolean updateTArticlesContent(TArticlesContent TArticlesContent) {
		return bdao.update(TArticlesContent);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "������������id��ѯ")
	@Override
	public TArticlesContent getTArticlesContentByid(int TArticlesContentid) {
		// TODO Auto-generated method stub
		return (TArticlesContent) bdao.findById(TArticlesContent.class,
				TArticlesContentid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "��������id��ѯ��������")
	@Override
	public List<TArticlesContent> getTArticlesContentByParentid(int TArticlesid) {
		String hqlstr = "from TArticlesContent where articlesid=?";
		Object[] para = { TArticlesid };
		return bdao.select(hqlstr, para);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "��������id��ѯ������ͼ����")
	@Override
	public List<VArticlesContent> getVArticlesContentByParentid(int TArticlesid) {
		String hqlstr = "from VArticlesContent where articlesid=?  order by articlescontentid asc";
		Object[] para = { TArticlesid };
		return bdao.select(hqlstr, para);
	}

}
