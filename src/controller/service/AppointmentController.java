package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TAppointment;
import model.TCustomerApp;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Expression;
import util.LayuiData;
import business.dao.AppointmentDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;
import common.properties.AppointmentType;

/**
 * 预约单contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "appointment")
public class AppointmentController {
	/**
	 * 获取客户预约单列表
	 * 
	 * 
	 * @param page
	 *            当前页
	 * @param limit
	 *            每页数量
	 * @param realname
	 *            查询条件
	 * @param apptype
	 *            类型
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getallappointment")
	public void getAllAppList(HttpServletRequest request, int page, int limit,
			String realname, String apptype, HttpServletResponse response,
			Model model) {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("appointmentname", realname, String.class);
			exp.orLike("createby", realname, String.class);
			exp.orRightBraLike("remark", realname, String.class);
		}
		if (apptype != null && !apptype.equals("")) {
			exp.andEqu("appointmenttype", apptype, String.class);
		}

		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getCustomAppAmount(opreation);

		List list = audao.selectCustomAppByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 获取维修预约单列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getreappointment")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String realname, HttpServletResponse response,
			Model model) {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("appointmentname", realname, String.class);
			exp.orLike("createby", realname, String.class);
			exp.orRightBraLike("remark", realname, String.class);
		}
		exp.andEqu("appointmenttype", AppointmentType.Repair, String.class);
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getAppRepairAmount(opreation);

		List list = audao.selectAppRepairByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 获取保养预约单列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getmaappointment")
	public void getMaAppointment(HttpServletRequest request, int page,
			int limit, String realname, Integer roleid,
			HttpServletResponse response, Model model) {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		// 查询条件
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("appointmentname", realname, String.class);
			exp.orLike("createby", realname, String.class);
			exp.orRightBraLike("remark", realname, String.class);
		}
		exp.andEqu("appointmenttype", AppointmentType.Maintain, String.class);
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getAppMainAmount(opreation);

		List list = audao.selectAppMainByPage(opreation, page, limit);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
		laydata.count = allcount;
		laydata.data = list;
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(laydata));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 实现一个预约单的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addappointment", method = RequestMethod.POST)
	public void addAdminUser(TAppointment appointment,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		HttpSession session = request.getSession();
		appointment.setCreateby(((VUser) session.getAttribute("loginuser"))
				.getUserid());
		appointment.setState(true);
		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.addTAppointment(appointment) > 0) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "添加成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "添加失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个预约单的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateappointment", method = RequestMethod.POST)
	public void updateAppointment(TAppointment appointment,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.updateTAppointment(appointment)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "更新成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "更新失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个预约单的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delappointment")
	public void delAdminUser(HttpServletRequest request,
			HttpServletResponse response, Integer id, Model model)
			throws IOException {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.delTAppointment(id)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个客户预约单的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcustomerapp", method = RequestMethod.POST)
	public void addCustomerApp(TCustomerApp customerapp,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.addCustomerApp(customerapp)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "更新成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "更新失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个客户预约单的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatecustomerapp", method = RequestMethod.POST)
	public void updateCustomerApp(TCustomerApp customerapp,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.updateCustomerApp(customerapp)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "更新成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "更新失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * 实现一个预约单的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delcustomerapp")
	public void delCustomerApp(HttpServletRequest request,
			HttpServletResponse response, Integer id, Model model)
			throws IOException {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.delCustomerApp(id)) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "删除成功";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "删除失败";
		}

		// 回传json字符串
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}
}
