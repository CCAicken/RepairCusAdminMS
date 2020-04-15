package business.impl;

import java.util.List;

import model.TAppointment;
import model.TCustomerApp;
import model.VAppointment;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.AppointmentDAO;

import common.properties.OperType;

@Component("appointmentdao")
public class AppointmentDAOImpl implements AppointmentDAO {
	private iHibBaseDAO bdao;

	public AppointmentDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "查询预约单")
	@Override
	public List<TAppointment> getTAppointmentList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加预约单")
	@Override
	public int addTAppointment(TAppointment tappointment) {
		return (int) bdao.insert(tappointment);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除预约单")
	@Override
	public boolean delTAppointment(int id) {
		TAppointment tappointment = (TAppointment) bdao.findById(
				TAppointment.class, id);

		return bdao.delete(tappointment);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新预约单")
	@Override
	public boolean updateTAppointment(TAppointment tappointment) {
		return bdao.update(tappointment);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据预约单id查询预约单")
	@Override
	public TAppointment getTAppointmentByid(int tappointmentid) {
		return (TAppointment) bdao.findById(TAppointment.class, tappointmentid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询保养预约单信息")
	@Override
	public List<TAppointment> selectAppMainByPage(String opretion, int page,
			int limit) {
		String hql = "from TAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by appointmentid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getAppMainAmount(String opretion) {
		String hql = "select count(appointmentid) from TAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询维修预约单信息")
	@Override
	public List<TAppointment> selectAppRepairByPage(String opretion, int page,
			int limit) {
		String hql = "from TAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by appointmentid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getAppRepairAmount(String opretion) {
		String hql = "select count(appointmentid) from TAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询客户预约单信息")
	@Override
	public List<VAppointment> selectCustomAppByPage(String opretion, int page,
			int limit) {
		String hql = "from VAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by customerappid asc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getCustomAppAmount(String opretion) {
		String hql = "select count(customerappid) from VAppointment ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加客户预约单")
	@Override
	public boolean addCustomerApp(TCustomerApp customerapp) {
		if ((Integer) bdao.insert(customerapp) > 0) {
			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除客户预约单")
	@Override
	public boolean delCustomerApp(int customerappid) {
		TCustomerApp customerapp = (TCustomerApp) bdao.findById(
				TCustomerApp.class, customerappid);
		return bdao.delete(customerapp);

	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新客户预约单")
	@Override
	public boolean updateCustomerApp(TCustomerApp customerapp) {
		return bdao.update(customerapp);
	}

}
