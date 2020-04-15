package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TCustomerCar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Expression;
import util.LayuiData;
import business.dao.CustomerDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * 客户车辆contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "customercar")
public class CustomerCarController {
	/**
	 * 获取客户车辆列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getcustomercar")
	public void getCustomerCar(HttpServletRequest request, int page, int limit,
			String realname, Integer cartypid, HttpServletResponse response,
			Model model) {

		CustomerDAO audao = DAOFactory.getCustomerDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("customername", realname, String.class);
			exp.andLike("customername", realname, String.class);
			exp.orRightBraLike("carname", realname, String.class);
		}
		if (cartypid != null && cartypid != 0) {
			exp.andEqu("cartypid", cartypid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getCustomerCarAmount(opreation);

		List list = audao.selectCustomerCarByPage(opreation, page, limit);

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
	 * 实现一个客户车辆的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addcustomercar", method = RequestMethod.POST)
	public void addcustomercar(TCustomerCar customercar,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		CustomerDAO audao = DAOFactory.getCustomerDAO();
		LayuiData laydata = new LayuiData();

		if (audao.addTCustomerCar(customercar) > 0) {
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
	 * 实现一个客户车辆的更新
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatecustomercar", method = RequestMethod.POST)
	public void updatecustomercar(TCustomerCar customercar,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		CustomerDAO audao = DAOFactory.getCustomerDAO();
		LayuiData laydata = new LayuiData();

		if (audao.updateTCustomerCar(customercar)) {
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
	 * 实现一个客户车辆的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delcustomercar")
	public void delCustomerCar(HttpServletRequest request,
			HttpServletResponse response, Integer customercarid, Model model)
			throws IOException {

		CustomerDAO adao = DAOFactory.getCustomerDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTCustomerCar(customercarid)) {
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
