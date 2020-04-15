package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Expression;
import util.LayuiData;
import business.dao.PhotoDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * 管理图片contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "photo")
public class PhotoController {
	/**
	 * 获取图片列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getphoto")
	public void getphotoList(HttpServletRequest request, int page, int limit,
			String realname, HttpServletResponse response, Model model) {

		PhotoDAO audao = DAOFactory.getPhotoDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("photoname", realname, String.class);
			exp.orRightBraLike("photoid", realname, String.class);
		}
		String opreation = exp.toString();
		int allcount = audao.getTPhotoAmount(opreation);

		List list = audao.selectTPhotoByPage(opreation, page, limit);

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
			e.printStackTrace();
		}
		// return "";
	}

	/**
	 * 实现一张图片的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delphoto")
	public void delphoto(HttpServletRequest request,
			HttpServletResponse response, Integer photoid, Model model)
			throws IOException {

		PhotoDAO adao = DAOFactory.getPhotoDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTPhoto(photoid)) {
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
