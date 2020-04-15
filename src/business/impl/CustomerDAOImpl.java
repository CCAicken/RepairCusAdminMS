package business.impl;

import java.util.List;

import model.TCustomer;
import model.TCustomerCar;
import model.VCustomerCar;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.CustomerDAO;

import common.properties.OperType;

@Component("customerdao")
public class CustomerDAOImpl implements CustomerDAO {
	private iHibBaseDAO bdao;

	public CustomerDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ�ͻ�")
	@Override
	public List<TCustomer> getTCustomerList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӿͻ�")
	@Override
	public String addTCustomer(TCustomer TCustomer) {
		return (String) bdao.insert(TCustomer);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ���ͻ�")
	@Override
	public boolean delTCustomer(String id) {
		// TODO Auto-generated method stub
		TCustomer TCustomer = (TCustomer) bdao.findById(TCustomer.class, id);

		return bdao.delete(TCustomer);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "���¿ͻ�")
	@Override
	public boolean updateTCustomer(TCustomer TCustomer) {
		return bdao.update(TCustomer);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݿͻ�id��ѯ")
	@Override
	public TCustomer getTCustomerByid(int TCustomerid) {
		// TODO Auto-generated method stub
		return (TCustomer) bdao.findById(TCustomer.class, TCustomerid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯ�ͻ���Ϣ")
	@Override
	public List<TCustomer> selectCustomerByPage(String opretion, int page,
			int limit) {
		String hql = "from TCustomer ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by customeraccount asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getCustomerAmount(String opretion) {
		String hql = "select count(customeraccount) from TCustomer ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӿͻ�������Ϣ")
	@Override
	public int addTCustomerCar(TCustomerCar TCustomercar) {
		return (int) bdao.insert(TCustomercar);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ���ͻ�������Ϣ")
	@Override
	public boolean delTCustomerCar(int id) {
		TCustomerCar TCustomercar = (TCustomerCar) bdao.findById(
				TCustomerCar.class, id);

		return bdao.delete(TCustomercar);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "���¿ͻ�������Ϣ")
	@Override
	public boolean updateTCustomerCar(TCustomerCar TCustomercar) {
		return bdao.update(TCustomercar);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݿͻ�����id��ѯ")
	@Override
	public TCustomerCar getTCustomerCarByid(int TCustomerCarid) {
		// TODO Auto-generated method stub
		return (TCustomerCar) bdao.findById(TCustomerCar.class, TCustomerCarid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯ�ͻ�������Ϣ")
	@Override
	public List<VCustomerCar> selectCustomerCarByPage(String opretion,
			int page, int limit) {
		String hql = "from VCustomerCar ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by customercarid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getCustomerCarAmount(String opretion) {
		String hql = "select count(customercarid) from VCustomerCar ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
