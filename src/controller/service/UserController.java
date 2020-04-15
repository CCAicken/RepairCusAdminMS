package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TUser;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.EnCriptUtil;
import util.Expression;
import util.LayuiData;
import business.dao.UserDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ����Ա�û�contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "admin")
public class UserController {
	/**
	 * ��ȡ����Ա�û��б�
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getuser")
	public void getAdminUserList(HttpServletRequest request, int page,
			int limit, String realname, Integer roleid,
			HttpServletResponse response, Model model) {

		UserDAO audao = DAOFactory.getUserDAO();
		// ��ѯ����
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("realname", realname, String.class);
			exp.orRightBraLike("userid", realname, String.class);
		}
		if (roleid != null && roleid != 0) {
			exp.andEqu("roleid", roleid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getUserAmount(opreation);

		List list = audao.selectUserByPage(opreation, page, limit);

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
	 * ʵ��һ��Ա���û��ĵ�½
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/adminlogin")
	public void AdminUserLogin(String userid, String pwd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {

		UserDAO audao = DAOFactory.getUserDAO();
		LayuiData laydata = new LayuiData();

		VUser user = new VUser();
		user.setUserid((String) userid);
		user.setUserpassword(pwd);
		VUser loginuser = audao.login(user);
		if (loginuser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", loginuser);
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��½�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��½ʧ��";
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
	 * ʵ��һ������Ա�û������
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addadminuser", method = RequestMethod.POST)
	public void addAdminUser(String jsonString, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);
		TUser user = new TUser();
		user.setUserid(jsonObject.getString("userid"));
		user.setPhotoid(jsonObject.getInteger("photoid"));
		user.setRealname(jsonObject.getString("realname"));
		user.setUsertel(jsonObject.getString("usertel"));
		user.setGender(jsonObject.getString("gender"));
		user.setRoleid(jsonObject.getInteger("roleid"));
		UserDAO audao = DAOFactory.getUserDAO();
		LayuiData laydata = new LayuiData();
		String md5Str = EnCriptUtil.fix(user.getUserid(), "123456");
		String endPwd = EnCriptUtil.getEcriptStr(md5Str, "md5");
		user.setUserpassword(endPwd);
		user.setState(false);

		if (!audao.addTUser(user).equals("")) {
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "Ա����ӳɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "Ա�����ʧ��";
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
	 * ʵ��һ���û����˳�
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
	 * ʵ��һ��Ա���û���ɾ��
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/deladminuser")
	public void delAdminUser(HttpServletRequest request,
			HttpServletResponse response, String userid, Model model)
			throws IOException {

		UserDAO adao = DAOFactory.getUserDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTUser(userid)) {
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
