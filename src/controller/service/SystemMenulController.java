package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.LayuiData;
import business.dao.RoleSysModelDAO;
import business.dao.SystemMenuDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * 系统管理菜单业务控制类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/systemmodel")
public class SystemMenulController {

	@RequestMapping(value = "/getsystemmodellist")
	public void getGetSystemModelList(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		SystemMenuDAO smdao = DAOFactory.getSystemMenuDAO();
		List list = smdao.getTSystemMenuList();
		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (list != null) {
			td.code = LayuiData.SUCCESS;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();

	}

	/**
	 * 实现一个管理员权限的查询
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getsystemmodelbyrole")
	public void getRoleSystemModelList(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		HttpSession session = request.getSession();
		VUser loginUser = (VUser) session.getAttribute("loginuser");
		SystemMenuDAO smdao = DAOFactory.getSystemMenuDAO();
		List list = smdao.geTSystemMenuByRole(loginUser.getRoleid());
		LayuiData rj = new LayuiData();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (list != null) {
			td.code = LayuiData.SUCCESS;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}

	/**
	 * 实现根据传入roleid返回所有菜单列表的请求
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getsystemmodelbyrole2")
	public void getRoleSystemModelList2(int roleid, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		SystemMenuDAO smdao = DAOFactory.getSystemMenuDAO();
		List list = smdao.geTSystemMenuByRole(roleid);
		LayuiData rj = new LayuiData();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (list != null) {
			td.code = LayuiData.SUCCESS;
			td.count = list.size();
			td.msg = "查询成功，共查出" + td.count + "条记录";
			td.data = list;
			// System.out.println(JSON.toJSON(list));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "查询失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @param parentid
	 * @throws IOException
	 */
	// @RequestMapping(value = "/getmenubyparentid")
	// public void getMenuByParentId(HttpServletRequest request,
	// HttpServletResponse response, Model model, Integer parentid)
	// throws IOException {
	//
	// SystemModelDAO smdao = new SystemModelDAOImpl();
	// List list = smdao.getMenuByParentId(parentid);
	// ResponseJSON rj = new ResponseJSON();
	//
	// // 回传json字符串
	// response.setCharacterEncoding("utf-8");
	// response.setContentType("application/json");
	// PrintWriter out = response.getWriter();
	// LayuiData td = new LayuiData();
	// if (list != null) {
	// td.code = LayuiData.SUCCESS;
	// td.count = list.size();
	// td.msg = "查询成功，共查出" + td.count + "条记录";
	// td.data = list;
	// System.out.println(JSON.toJSON(list));
	// } else {
	// td.code = LayuiData.ERRR;
	// td.msg = "查询失败";
	// }
	// out.write(JSON.toJSONString(td));
	// // {"code":10001,"msg":"执行成功","result1":"......."}
	// out.flush();
	// out.close();
	// }

	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
	 *
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "/changerolemodel")
	public void changeRoleModelState(Integer rolemodelid,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		RoleSysModelDAO smdao = DAOFactory.getRoleSysModelDAO();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.updataRoleModel(rolemodelid)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "授权成功";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "授权失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}

	/**
	 * 实现根据传入rolemodelid改变该id功能菜单是否可用
	 *
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 * */
	@RequestMapping(value = "/changemenustate")
	public void changeMenuState(Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		SystemMenuDAO smdao = DAOFactory.getSystemMenuDAO();

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		LayuiData td = new LayuiData();
		if (smdao.changeRoleModelState(id)) {
			td.code = LayuiData.SUCCESS;

			td.msg = "启用成功";

			// System.out.println(JSON.toJSON(td));
		} else {
			td.code = LayuiData.ERRR;
			td.msg = "启用失败";
		}
		out.write(JSON.toJSONString(td));
		// {"code":10001,"msg":"执行成功","result1":"......."}
		out.flush();
		out.close();
	}

}
