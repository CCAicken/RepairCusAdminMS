package business.impl;

import java.util.List;

import model.TRole;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.RoleDAO;

import common.properties.OperType;

@Component("roledao")
public class RoleDAOImpl implements RoleDAO {
	private iHibBaseDAO bdao;

	public RoleDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = false)
	@Override
	public List<TRole> getaAdminUserList(String opreation) {
		String hql = "from TRole";
		if (opreation != null && !opreation.equals("")) {
			hql += opreation;
		}
		hql += " order by id asc";
		List<TRole> list = bdao.select(hql);
		return list;

	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除管理员角色")
	@Override
	public boolean delAdminRole(TRole role) {
		TRole rolesql = (TRole) bdao.findById(TRole.class, role.getRoleid());

		return bdao.delete(rolesql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加管理员角色")
	@Override
	public boolean addAdminRole(TRole role) {
		Object[] para = { role.getName(), role.getDescription() };
		if (Integer
				.parseInt(bdao.executeProduce("up_addRole", para).toString()) > 0) {

			return true;
		}
		return false;
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "编辑管理员角色")
	@Override
	public boolean edlAdminRole(TRole role) {
		TRole rolesql = (TRole) bdao.findById(TRole.class, role.getRoleid());
		rolesql.setName(role.getName());
		rolesql.setDescription(role.getDescription());

		return bdao.update(rolesql);
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加管理员角色")
	@Override
	public boolean addRole(TRole role) {
		String procname = "up_addRole(?,?)";
		Object[] para = { role.getName(), role.getDescription() };
		int row = (Integer) bdao.executeProduce(procname, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}
