package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TCustomer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import business.dao.CustomerDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ����Ա�ͻ�contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "customer")
public class CustomerController {
	/**
	 * ��ȡ����Ա�ͻ��б�
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcustomer")
	public void getcustomList(HttpServletRequest request, int page, int limit,
			String realname, HttpServletResponse response, Model model) {

		CustomerDAO audao = DAOFactory.getCustomerDAO();
		// ��ѯ����
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("customername", realname, String.class);
			exp.andLike("gender", realname, String.class);
			exp.orRightBraLike("customeraccount", realname, String.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getCustomerAmount(opreation);

		List list = audao.selectCustomerByPage(opreation, page, limit);

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
	 * ʵ��һ������Ա�ͻ������
	 * 
	 * @param
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public void addcustom(TCustomer customer, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		CustomerDAO audao = DAOFactory.getCustomerDAO();
		LayuiData laydata = new LayuiData();
		String md5Str = EnCriptUtil
				.fix(customer.getCustomeraccount(), "123456");
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		customer.setPasword(endPwd);
		customer.setState(false);

		if (!audao.addTCustomer(customer).equals("")) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "�ͻ���ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "�ͻ����ʧ��";
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
	 * ʵ��һ���ͻ����˳�
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/logoutsystem")
	public void logoutsystem(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		HttpSession session = request.getSession();

		session.removeAttribute("loginuser");
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "�˳��ɹ�";
		// �ش�json�ַ���
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(laydata));
		out.flush();
		out.close();

	}

	/**
	 * ʵ��һ���ͻ���ɾ��
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delcustomer")
	public void delcustom(HttpServletRequest request,
			HttpServletResponse response, String id, Model model)
			throws IOException {

		CustomerDAO adao = DAOFactory.getCustomerDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTCustomer(id)) {
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
