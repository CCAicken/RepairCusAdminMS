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

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据条件查询员工职务")
	@Override
	public List<TUserType> getTUserTypeList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加员工职务")
	@Override
	public int addTUserType(TUserType TUserType) {
		return (int) bdao.insert(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除员工职务")
	@Override
	public boolean delTUserType(int id) {
		// TODO Auto-generated method stub
		TUserType TUserType = (TUserType) bdao.findById(TUserType.class, id);

		return bdao.delete(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新员工职务")
	@Override
	public boolean updateTUserType(TUserType TUserType) {
		return bdao.update(TUserType);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据员工职务id查询")
	@Override
	public TUserType getTUserTypeByid(int TUserTypeid) {
		// TODO Auto-generated method stub
		return (TUserType) bdao.findById(TUserType.class, TUserTypeid);
	}
}
