package business.impl;

import java.util.List;

import model.TSystemMenu;
import model.VRoleSysModel;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.SystemMenuDAO;

import common.properties.OperType;

@Component("systemmenudao")
public class SystemMenuDAOImpl implements SystemMenuDAO {

	private iHibBaseDAO bdao;

	public SystemMenuDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据查询系统菜单")
	@Override
	public List<TSystemMenu> getTSystemMenuList() {
		String hql = "from TSystemMenu order by parentid,displayorder asc";
		return bdao.select(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据角色id查询系统菜单")
	@Override
	public List<VRoleSysModel> geTSystemMenuByRole(int roleid) {
		String hql = "from VRoleSysModel where roleid=? order by parentid,displayorder asc";
		Object[] param = { roleid };
		return bdao.select(hql, param);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "改变系统菜单状态")
	@Override
	public boolean changeRoleModelState(int rolemodelid) {
		TSystemMenu modelsql = (TSystemMenu) bdao.findById(TSystemMenu.class,
				rolemodelid);
		if (modelsql.getIsdelete()) {

			modelsql.setIsdelete(false);
		} else {
			modelsql.setIsdelete(true);
		}

		return bdao.update(modelsql);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据菜单父id查询系统菜单")
	@Override
	public List<TSystemMenu> getMenuByParentId(int id) {
		String hql = "from TSystemMenu where isdelete=0 and parentid = ? ";
		Object[] para = { id };
		return bdao.select(hql, para);
	}

	// public static void main(String[] args) {
	// SystemMenuDAO sdao = new SystemMenuDAOImpl();
	// List<VRoleSysModel> list = sdao.getSystemMenuByRole(1);
	// for (VRoleSysModel vRoleSysModel : list) {
	// System.out.println(vRoleSysModel.getName());
	// }
	// // List<TSystemMenu> lismenu = sdao.getAllSystemMenu();
	// //
	// // for (TSystemMenu tSystemMenu : lismenu) {
	// // System.out.println(tSystemMenu.get ame());
	// // }
	// }
}
