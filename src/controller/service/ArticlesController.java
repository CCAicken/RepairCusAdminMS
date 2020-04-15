package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TArticles;
import model.TArticlesContent;
import model.TArticlesType;
import model.VUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.Expression;
import util.LayuiData;
import business.dao.ArticlesContentDAO;
import business.dao.ArticlesDAO;
import business.dao.ArticlesTypeDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * 文章contoller类
 * 
 * @author jock
 *
 */
@Controller
@RequestMapping(value = "articles")
public class ArticlesController {
	/**
	 * 获取文章列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getarticles")
	public void getarticlesList(HttpServletRequest request, int page,
			int limit, String realname, Integer typeid,
			HttpServletResponse response, Model model) {

		ArticlesDAO audao = DAOFactory.getArticlesDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLeftBraLike("tite", realname, String.class);
			exp.orRightBraLike("author", realname, String.class);
		}
		if (typeid != null && !typeid.equals("")) {
			exp.andEqu("articlestypeid", typeid, Integer.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getTArticlesAmount(opreation);

		List list = audao.selectTArticlesByPage(opreation, page, limit);

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
	 * 获取文章类型列表
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getarticlestype")
	public void getarticlesTypeList(HttpServletRequest request, int page,
			int limit, String realname, HttpServletResponse response,
			Model model) {

		ArticlesTypeDAO audao = DAOFactory.getArticlesTypeDAO();
		// 查询条件
		Expression exp = new Expression();

		if (realname != null && !realname.equals("")) {

			exp.andLike("articlestypename", realname, String.class);
		}
		String opreation = exp.toString();
		// System.out.println(opreation);
		int allcount = audao.getTArticlesAmount(opreation);

		List list = audao.selectTArticlesTypeByPage(opreation, page, limit);

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
	 * 根据文章id获取文章信息
	 * 
	 * @param request
	 * @param forumid
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("getforum")
	public String getForumTitle(HttpServletRequest request, int forumid,
			HttpServletResponse response, Model model) {
		ArticlesDAO fdao = DAOFactory.getArticlesDAO();
		TArticles forum = fdao.getTArticlesByid(forumid);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		model.addAttribute("forum", forum);
		return "html/addForumcontent";
	}

	/**
	 * 根据文章id获取文章内容
	 * 
	 * 
	 * @param page
	 * @param limit
	 * @param realname
	 * @param roleid
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "getarticlescontent")
	public void getArticlesContentList(HttpServletRequest request, int page,
			int limit, Integer articlesid, HttpServletResponse response,
			Model model) {

		ArticlesContentDAO audao = DAOFactory.getArticlesContentDAO();

		List list = audao.getVArticlesContentByParentid(articlesid);

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		LayuiData laydata = new LayuiData();
		laydata.code = LayuiData.SUCCESS;
		laydata.msg = "执行成功";
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
	 * 实现一个文章的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addarticles", method = RequestMethod.POST)
	public void addarticles(TArticles articles, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesDAO audao = DAOFactory.getArticlesDAO();
		HttpSession session = request.getSession();
		LayuiData laydata = new LayuiData();
		VUser loginuserUser = (VUser) session.getAttribute("loginuser");
		articles.setAuthor(loginuserUser.getUserid());
		articles.setState(false);
		if (audao.addTArticles(articles) > 0) {
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
	 * 实现一个文章类型的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addarticlestype", method = RequestMethod.POST)
	public void addarticlesType(TArticlesType articlestype,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesTypeDAO audao = DAOFactory.getArticlesTypeDAO();
		LayuiData laydata = new LayuiData();
		if (audao.addTArticlesType(articlestype) > 0) {
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
	 * 实现一个文章内容的添加
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/addarticlestcontent", method = RequestMethod.POST)
	public void addarticlesContent(TArticlesContent articlestypecontent,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesContentDAO audao = DAOFactory.getArticlesContentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.addTArticlesContent(articlestypecontent) > 0) {
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
	 * 实现一个文章的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delarticles")
	public void delarticles(HttpServletRequest request,
			HttpServletResponse response, Integer articlesid, Model model)
			throws IOException {

		ArticlesDAO adao = DAOFactory.getArticlesDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTArticles(articlesid)) {
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
	 * 实现一个文章类型的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delarticlestype")
	public void delarticlesType(HttpServletRequest request,
			HttpServletResponse response, Integer articlestypeid, Model model)
			throws IOException {

		ArticlesTypeDAO adao = DAOFactory.getArticlesTypeDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTArticlesType(articlestypeid)) {
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
	 * 实现一个文章内容的删除
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/delarticlescontent")
	public void delArticlesContent(HttpServletRequest request,
			HttpServletResponse response, Integer articlescontentid, Model model)
			throws IOException {

		ArticlesContentDAO adao = DAOFactory.getArticlesContentDAO();
		LayuiData laydata = new LayuiData();
		if (adao.delTArticlesContent(articlescontentid)) {
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
	 * 实现一个文章的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatearticles", method = RequestMethod.POST)
	public void updateArticles(TArticles articles, HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesDAO audao = DAOFactory.getArticlesDAO();
		LayuiData laydata = new LayuiData();
		if (audao.updateTArticles(articles)) {
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
	 * 实现一个文章类型的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatearticlestype", method = RequestMethod.POST)
	public void updateArticlesType(TArticlesType articlestype,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesTypeDAO audao = DAOFactory.getArticlesTypeDAO();
		LayuiData laydata = new LayuiData();
		if (audao.updateTArticlesType(articlestype)) {
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
	 * 实现一个文章内容的修改
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatearticlescontent", method = RequestMethod.POST)
	public void updateArticlesContent(TArticlesContent articlescontent,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException {
		// JSONObject jsonObject = (JSONObject) JSON.parse(jsonString);

		ArticlesContentDAO audao = DAOFactory.getArticlesContentDAO();
		LayuiData laydata = new LayuiData();
		if (audao.updateTArticlesContent(articlescontent)) {
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

}
