package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCarType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Expression;
import util.LayuiData;
import business.dao.CarTypeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ��������contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "cartype")
public class CarTypeController {
	/**
	 * ��ȡ���������б�
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcartype")
	public void getCarList(HttpServletRequest request, int page, int limit,
			String realname, Integer roleid, HttpServletResponse response,
			Model model) {

		CarTypeDAO audao = DAOFactory.getCarTypeDAO();
		// ��ѯ����
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLike("cartypename", realname, String.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getTCarTypeAmount(opreation);

		List list = audao.selectCarTypeByPage(opreation, page, limit);

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
	 * ʵ��һ���������͵����
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcartype", method = RequestMethod.POST)
	public void addCar(TCarType type, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		CarTypeDAO audao = DAOFactory.getCarTypeDAO();

		if (audao.addTCarType(type) > 0) {
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
	 * ʵ��һ���������͵ı༭
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatecartype", method = RequestMethod.POST)
	public void edtCar(TCarType ttype, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		CarTypeDAO audao = DAOFactory.getCarTypeDAO();

		if (audao.updateTCarType(ttype)) {
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
	 * ʵ��һ���������͵�ɾ��
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delcartype")
	public void delCar(HttpServletRequest request,
			HttpServletResponse response, Integer carid, Model model)
			throws IOException {

		CarTypeDAO adao = DAOFactory.getCarTypeDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTCarType(carid)) {
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
