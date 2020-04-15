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
 * ԤԼ��contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "appointment")
public class AppointmentController {
	/**
	 * ��ȡ�ͻ�ԤԼ���б�
	 * 
	 * 
	 * @param page
	 *            ��ǰҳ
	 * @param limit
	 *            ÿҳ����
	 * @param realname
	 *            ��ѯ����
	 * @param apptype
	 *            ����
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getallappointment")
	public void getAllAppList(HttpServletRequest request, int page, int limit,
			String realname, String apptype, HttpServletResponse response,
			Model model) {

		AppointmentDAO audao = DAOFactory.getAppointmentDAO();
		// ��ѯ����
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
		laydata.msg = "ִ�гɹ�";
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
	 * ��ȡά��ԤԼ���б�
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
		// ��ѯ����
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
		laydata.msg = "ִ�гɹ�";
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
	 * ��ȡ����ԤԼ���б�
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
		// ��ѯ����
		// ��ѯ����
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
		laydata.msg = "ִ�гɹ�";
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
	 * ʵ��һ��ԤԼ�������
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
			laydata.msg = "��ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "���ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ��ԤԼ�����޸�
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
			laydata.msg = "���³ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ��ԤԼ����ɾ��
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
			laydata.msg = "ɾ���ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ���ͻ�ԤԼ�������
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
			laydata.msg = "���³ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ���ͻ�ԤԼ�����޸�
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
			laydata.msg = "���³ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "����ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ��ԤԼ����ɾ��
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
			laydata.msg = "ɾ���ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "ɾ��ʧ��";
		}

		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}
}
