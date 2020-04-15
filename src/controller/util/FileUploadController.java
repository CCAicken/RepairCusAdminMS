package controller.util;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TPhoto;
import model.VUser;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import util.LayuiData;
import business.dao.PhotoDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "file")
public class FileUploadController {

	@RequestMapping(value = "/addUser")
	public void addUser(HttpServletRequest request, MultipartFile pictureFile)
			throws Exception {

		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 获取文件的扩展名
		String ext = FilenameUtils.getExtension(pictureFile
				.getOriginalFilename());
		// 设置图片上传路径
		String url = request.getSession().getServletContext()
				.getRealPath("/upload");
		System.out.println(url);
		// 以绝对路径保存重名命后的图片
		pictureFile.transferTo(new File(url + "/" + name + "." + ext));
		// 把图片存储路径保存到数据库
		// user.setImageURL("upload/" + name + "." + ext);
		LayuiData layui = new LayuiData();
		try {
			// 图片资源上传成功后，将在T_Photo表中创建一条图片资源的管理记录
			String filename2 = "upload/" + name + "." + ext;
			PhotoDAO pdao = DAOFactory.getPhotoDAO();
			TPhoto photo = new TPhoto();
			photo.setPhotoname(filename2);
			photo.setState(true);
			int photoid = pdao.addTPhoto(photo);
			layui.code = LayuiData.SUCCESS;
			layui.count = photoid;
			layui.result = filename2;
			layui.msg = "上传成功";
		} catch (Exception e) {
			layui.code = LayuiData.ERRR;
			layui.msg = "文件上传错误，请重试";
			e.printStackTrace();
		}

	}

	@RequestMapping("springupload")
	public void springUpload(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws IllegalStateException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// long startTime = System.currentTimeMillis();
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		// 消息提示
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String name = UUID.randomUUID().toString()
							.replaceAll("-", "");
					// 获取图片名称
					// String imageName = file.getOriginalFilename();

					// 获取文件的扩展名
					String ext = FilenameUtils.getExtension(file
							.getOriginalFilename());
					// 设置图片上传路径
					String filePath = "F:/biyesheji/image";

					String filename = filePath + "/" + name + "." + ext;
					// String exPath = "image/" + name + "." + ext;
					// System.out.println(filename);
					// 上传
					try {
						// 以绝对路径保存重名命后的图片
						file.transferTo(new File(filename));
						// 图片资源上传成功后，将在T_Photo表中创建一条图片资源的管理记录
						String filename2 = "/images/" + name + "." + ext;
						PhotoDAO pdao = DAOFactory.getPhotoDAO();
						TPhoto photo = new TPhoto();
						HttpSession session = request.getSession();
						VUser user = (VUser) session.getAttribute("loginuser");
						photo.setPhotoname(filename2);
						photo.setByuser(user.getUserid());
						photo.setState(true);
						int photoid = pdao.addTPhoto(photo);
						layui.code = LayuiData.SUCCESS;
						layui.count = photoid;
						layui.result = filename2;
						layui.msg = "上传成功";
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "文件上传错误，请重试";
						e.printStackTrace();
					}
				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "文件上传错误，请重试";
				}
			}
		}
		// long endTime = System.currentTimeMillis();
		// System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime)+
		// "ms");
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(layui));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("springimport")
	public void springImport(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws IllegalStateException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		long startTime = System.currentTimeMillis();

		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(

		request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		// 消息提示
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/file/"
							+ file.getOriginalFilename();
					// 上传
					try {
						file.transferTo(new File(path));
						layui.code = LayuiData.SUCCESS;
						layui.msg = path;
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "文件上传错误，请重试";
					}
				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "文件上传错误，请重试";
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime)
				+ "ms");
		Writer out;
		try {
			out = response.getWriter();
			out.write(JSON.toJSONString(layui));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
