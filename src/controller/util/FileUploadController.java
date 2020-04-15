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

		// ʹ��UUID��ͼƬ����������ȥ���ĸ���-��
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// ��ȡ�ļ�����չ��
		String ext = FilenameUtils.getExtension(pictureFile
				.getOriginalFilename());
		// ����ͼƬ�ϴ�·��
		String url = request.getSession().getServletContext()
				.getRealPath("/upload");
		System.out.println(url);
		// �Ծ���·���������������ͼƬ
		pictureFile.transferTo(new File(url + "/" + name + "." + ext));
		// ��ͼƬ�洢·�����浽���ݿ�
		// user.setImageURL("upload/" + name + "." + ext);
		LayuiData layui = new LayuiData();
		try {
			// ͼƬ��Դ�ϴ��ɹ��󣬽���T_Photo���д���һ��ͼƬ��Դ�Ĺ����¼
			String filename2 = "upload/" + name + "." + ext;
			PhotoDAO pdao = DAOFactory.getPhotoDAO();
			TPhoto photo = new TPhoto();
			photo.setPhotoname(filename2);
			photo.setState(true);
			int photoid = pdao.addTPhoto(photo);
			layui.code = LayuiData.SUCCESS;
			layui.count = photoid;
			layui.result = filename2;
			layui.msg = "�ϴ��ɹ�";
		} catch (Exception e) {
			layui.code = LayuiData.ERRR;
			layui.msg = "�ļ��ϴ�����������";
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
		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// һ�α��������ļ�
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String name = UUID.randomUUID().toString()
							.replaceAll("-", "");
					// ��ȡͼƬ����
					// String imageName = file.getOriginalFilename();

					// ��ȡ�ļ�����չ��
					String ext = FilenameUtils.getExtension(file
							.getOriginalFilename());
					// ����ͼƬ�ϴ�·��
					String filePath = "F:/biyesheji/image";

					String filename = filePath + "/" + name + "." + ext;
					// String exPath = "image/" + name + "." + ext;
					// System.out.println(filename);
					// �ϴ�
					try {
						// �Ծ���·���������������ͼƬ
						file.transferTo(new File(filename));
						// ͼƬ��Դ�ϴ��ɹ��󣬽���T_Photo���д���һ��ͼƬ��Դ�Ĺ����¼
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
						layui.msg = "�ϴ��ɹ�";
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "�ļ��ϴ�����������";
						e.printStackTrace();
					}
				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "�ļ��ϴ�����������";
				}
			}
		}
		// long endTime = System.currentTimeMillis();
		// System.out.println("������������ʱ�䣺" + String.valueOf(endTime - startTime)+
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

		// ����ǰ�����ĳ�ʼ���� CommonsMutipartResolver ���ಿ�ֽ�������
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(

		request.getSession().getServletContext());
		// ���form���Ƿ���enctype="multipart/form-data"
		// ��Ϣ��ʾ
		LayuiData layui = new LayuiData();
		if (multipartResolver.isMultipart(request)) {
			// ��request��ɶಿ��request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// ��ȡmultiRequest �����е��ļ���
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// һ�α��������ļ�
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = "M:/JSP/csmsSpringMVC/csmsSpringMVC/WebRoot/upload/file/"
							+ file.getOriginalFilename();
					// �ϴ�
					try {
						file.transferTo(new File(path));
						layui.code = LayuiData.SUCCESS;
						layui.msg = path;
					} catch (Exception e) {
						layui.code = LayuiData.ERRR;
						layui.msg = "�ļ��ϴ�����������";
					}
				} else {
					layui.code = LayuiData.ERRR;
					layui.msg = "�ļ��ϴ�����������";
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("������������ʱ�䣺" + String.valueOf(endTime - startTime)
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
