package business.impl;

import java.util.List;

import model.TUserType;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.UserTypeDAO;

import common.properties.OperType;

@Component("usertypedao")
public class UserTypeDAOImpl implements UserTypeDAO {

	private iHibBaseDAO bdao;

	public UserTypeDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯԱ��ְ��")
	@Override
	public List<TUserType> getTUserTypeList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "���Ա��ְ��")
	@Override
	public int addTUserType(TUserType TUserType) {
		return (int) bdao.insert(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ��Ա��ְ��")
	@Override
	public boolean delTUserType(int id) {
		// TODO Auto-generated method stub
		TUserType TUserType = (TUserType) bdao.findById(TUserType.class, id);

		return bdao.delete(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "����Ա��ְ��")
	@Override
	public boolean updateTUserType(TUserType TUserType) {
		return bdao.update(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����Ա��ְ��id��ѯ")
	@Override
	public TUserType getTUserTypeByid(int TUserTypeid) {
		// TODO Auto-generated method stub
		return (TUserType) bdao.findById(TUserType.class, TUserTypeid);
	}
}
