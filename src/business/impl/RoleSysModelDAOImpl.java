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

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据条件查询角色菜单关系")
	@Override
	public List<TRoleSysModel> getTRoleSysModelList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加角色菜单关系")
	@Override
	public int addTRoleSysModel(TRoleSysModel TRoleSysModel) {
		return (int) bdao.insert(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除角色菜单关系")
	@Override
	public boolean delTRoleSysModel(int id) {
		// TODO Auto-generated method stub
		TRoleSysModel TRoleSysModel = (TRoleSysModel) bdao.findById(
				TRoleSysModel.class, id);

		return bdao.delete(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新角色菜单关系")
	@Override
	public boolean updateTRoleSysModel(TRoleSysModel TRoleSysModel) {
		return bdao.update(TRoleSysModel);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据角色菜单关系id查询")
	@Override
	public TRoleSysModel getTRoleSysModelByid(int TRoleSysModelid) {
		// TODO Auto-generated method stub
		return (TRoleSysModel) bdao.findById(TRoleSysModel.class,
				TRoleSysModelid);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新权限一条记录")
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
