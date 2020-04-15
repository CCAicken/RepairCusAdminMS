package business.impl;

import java.util.List;

import model.TCarType;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CarTypeDAO;

import common.properties.OperType;

@Component("cartypedao")
public class CarTypeDAOImpl implements CarTypeDAO {

	private iHibBaseDAO bdao;

	public CarTypeDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ��������")
	@Override
	public List<TCarType> getTCarTypeList(String opreation) {
		String hql = "from TCarType ";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by cartypeid";
		return bdao.select(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӳ�������")
	@Override
	public int addTCarType(TCarType TCarType) {
		return (int) bdao.insert(TCarType);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ����������")
	@Override
	public boolean delTCarType(int id) {
		// TODO Auto-generated method stub
		TCarType TCarType = (TCarType) bdao.findById(TCarType.class, id);

		return bdao.delete(TCarType);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "���³�������")
	@Override
	public boolean updateTCarType(TCarType TCarType) {
		return bdao.update(TCarType);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݳ�������id��ѯ")
	@Override
	public TCarType getTCarTypeByid(int TCarTypeid) {
		// TODO Auto-generated method stub
		return (TCarType) bdao.findById(TCarType.class, TCarTypeid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯ����������Ϣ")
	@Override
	public List<TCarType> selectCarTypeByPage(String opretion, int page,
			int limit) {
		String hql = "from TCarType ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by cartypeid";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getTCarTypeAmount(String opretion) {
		String hql = "select count(cartypeid) from TCarType ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
