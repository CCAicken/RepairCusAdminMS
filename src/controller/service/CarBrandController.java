package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TBrand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Expression;
import util.LayuiData;
import business.dao.BrandDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ����Ʒ��contoller��
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "carbrand")
public class CarBrandController {
	/**
	 * ��ȡ����Ʒ���б�
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcarbrand")
	public void getCarList(HttpServletRequest request, int page, int limit,
			String realname, Integer roleid, HttpServletResponse response,
			Model model) {

		BrandDAO audao = DAOFactory.getBrandDAO();
		// ��ѯ����
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLike("brandname", realname, String.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getBrandAmount(opreation);

		List list = audao.selectBrandByPage(opreation, page, limit);

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
	 * ʵ��һ������Ʒ�Ƶ����
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcarbrand", method = RequestMethod.POST)
	public void addCar(TBrand brand, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		BrandDAO audao = DAOFactory.getBrandDAO();

		if (audao.addTBrand(brand) > 0) {
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
	 * ʵ��һ������Ʒ�Ƶı༭
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatecarbrand", method = RequestMethod.POST)
	public void edtCar(TBrand tbrand, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		BrandDAO audao = DAOFactory.getBrandDAO();

		if (audao.updateTBrand(tbrand)) {
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
	 * ʵ��һ������Ʒ�Ƶ�ɾ��
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delcarbrand")
	public void delCar(HttpServletRequest request,
			HttpServletResponse response, Integer carid, Model model)
			throws IOException {

		BrandDAO adao = DAOFactory.getBrandDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTBrand(carid)) {
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
