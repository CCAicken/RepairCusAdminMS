package business.impl;

import java.util.List;

import model.TCar;
import model.VCar;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CarDAO;

import common.properties.OperType;

@Component("cardao")
public class CarDAOImpl implements CarDAO {

	private iHibBaseDAO bdao;

	public CarDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ����")
	@Override
	public List<TCar> getTCarList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӳ���")
	@Override
	public int addTCar(TCar TCar) {
		return (int) bdao.insert(TCar);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ������")
	@Override
	public boolean delTCar(int id) {
		// TODO Auto-generated method stub
		TCar TCar = (TCar) bdao.findById(TCar.class, id);

		return bdao.delete(TCar);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "���³���")
	@Override
	public boolean updateTCar(TCar TCar) {
		return bdao.update(TCar);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݳ���id��ѯ")
	@Override
	public TCar getTCarByid(int TCarid) {
		// TODO Auto-generated method stub
		return (TCar) bdao.findById(TCar.class, TCarid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯ������Ϣ")
	@Override
	public List<VCar> selectCarByPage(String opretion, int page, int limit) {
		String hql = "from VCar ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by carid";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getCarAmount(String opretion) {
		String hql = "select count(carid) from VCar ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
