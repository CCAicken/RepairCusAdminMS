package business.impl;

import java.util.List;

import model.TRoleSysModel;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RoleSysModelDAO;

import common.properties.OperType;

@Component("rolesysmodeldao")
public class RoleSysModelDAOImpl implements RoleSysModelDAO {

	private iHibBaseDAO bdao;

	public RoleSysModelDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯ��ɫ�˵���ϵ")
	@Override
	public List<TRoleSysModel> getTRoleSysModelList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "��ӽ�ɫ�˵���ϵ")
	@Override
	public int addTRoleSysModel(TRoleSysModel TRoleSysModel) {
		return (int) bdao.insert(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ����ɫ�˵���ϵ")
	@Override
	public boolean delTRoleSysModel(int id) {
		// TODO Auto-generated method stub
		TRoleSysModel TRoleSysModel = (TRoleSysModel) bdao.findById(
				TRoleSysModel.class, id);

		return bdao.delete(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "���½�ɫ�˵���ϵ")
	@Override
	public boolean updateTRoleSysModel(TRoleSysModel TRoleSysModel) {
		return bdao.update(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݽ�ɫ�˵���ϵid��ѯ")
	@Override
	public TRoleSysModel getTRoleSysModelByid(int TRoleSysModelid) {
		// TODO Auto-generated method stub
		return (TRoleSysModel) bdao.findById(TRoleSysModel.class,
				TRoleSysModelid);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "����Ȩ��һ����¼")
	@Override
	public boolean updataRoleModel(int rolemodelid) {
		TRoleSysModel rolemodelsql = (TRoleSysModel) bdao.findById(
				TRoleSysModel.class, rolemodelid);
		if (rolemodelsql.getIsedit()) {
			rolemodelsql.setIsedit(false);
		} else {
			rolemodelsql.setIsedit(true);
		}
		return bdao.update(rolemodelsql);
	}
}
