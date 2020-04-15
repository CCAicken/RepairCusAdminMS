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

import util.LayuiData;
import business.dao.ArticlesTypeDAO;
import business.dao.BrandDAO;
import business.dao.CarTypeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ϵͳ���������
 * 
 * @author Aicken
 *
 */
@Controller
@RequestMapping(value = "select")
public class SelectController {

	/**
	 * ��ȡ��������
	 * 
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getarticlestype")
	public void getarticlesTypeList(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		ArticlesTypeDAO audao = DAOFactory.getArticlesTypeDAO();

		List list = audao.getTArticlesTypeList("");

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	 * ��ȡƷ������
	 * 
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcarbrand")
	public void getCarBrand(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		BrandDAO audao = DAOFactory.getBrandDAO();

		List list = audao.getTBrandList("");

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "ִ�гɹ�";
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
	 * ʵ�ֳ������͵Ĳ�ѯ
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectcartype")
	public void addCar(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {

		LayuiData laydata = new LayuiData();
		CarTypeDAO audao = DAOFactory.getCarTypeDAO();
		List<TCarType> cartypelist = audao.getTCarTypeList("");
		if (cartypelist != null) {
			laydata.data = cartypelist;
			laydata.code = LayuiData.SUCCESS;
			laydata.msg = "��ѯ�ɹ�";
		} else {
			laydata.code = LayuiData.ERRR;
			laydata.msg = "��ѯʧ��";
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
