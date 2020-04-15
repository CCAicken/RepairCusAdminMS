package business.impl;

import java.util.List;

import model.TUser;
import model.VUser;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.UserDAO;

import common.properties.OperType;

@Component("userdao")
public class UserDAOImpl implements UserDAO {

	private iHibBaseDAO bdao;

	public UserDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据条件查询员工")
	@Override
	public List<TUser> getTUserList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "添加员工")
	@Override
	public String addTUser(TUser TUser) {
		return (String) bdao.insert(TUser);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "删除员工")
	@Override
	public boolean delTUser(String id) {
		// TODO Auto-generated method stub
		TUser TUser = (TUser) bdao.findById(TUser.class, id);

		return bdao.delete(TUser);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "更新员工")
	@Override
	public boolean updateTUser(TUser TUser) {
		return bdao.update(TUser);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据员工id查询")
	@Override
	public TUser getTUserByid(int TUserid) {
		// TODO Auto-generated method stub
		return (TUser) bdao.findById(TUser.class, TUserid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "根据分页查询员工信息")
	@Override
	public List<VUser> selectUserByPage(String opretion, int page, int limit) {
		String hql = "from VUser ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by userid";
		return bdao.selectByPage(hql, page, limit);
	}

	@Log(isSaveLog = false)
	@Override
	public int getUserAmount(String opretion) {
		String hql = "select count(userid) from VUser ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "用户登录")
	@Override
	public VUser login(VUser user) {
		VUser loginuser = (VUser) bdao.findById(VUser.class, user.getUserid());
		if (user.getUserid().equals(loginuser.getUserid())
				&& user.getUserpassword().equals(loginuser.getUserpassword())) {
			return loginuser;
		}
		return null;

	}

}
