package controller.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TPhoto;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import util.LayuiData;
import business.dao.PhotoDAO;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

/**
 * ����������jsp�ϴ��ļ��Ŀ����� 1�������ϴ��ļ� 2�������ļ��ڷ������ϵĴ洢·�� 3�������ļ���·����
 * 4����T_photo���д���ͼƬ��Դ��¼������ø�ͼƬ��¼id 5�����ؽ����jspҳ��
 * 
 * @author zhang jin sheng
 *
 */
@WebServlet("/fileuploadservlet.do")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����һ�����ڷ���ֵ��json���Ͷ���
		LayuiData respjson = new LayuiData();

		String fileName = null;// �ϴ���servlet���ļ���

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json");

		// ����ļ������·����������Ƭһ������realPath�����·���У�
		// ���realaPathͨ�����ܵĲ������ǲ�����userid
		// String relaPath = request.getParameter("path");

		// ����ϴ����ǲ��ĵ�ͼƬ�ļ������titleid��Ϊ�ڲ���Ŀ¼�µ���Ŀ¼����
		// String titleid = request.getParameter("titleid");

		// ��path��titleid���һ�����·��
		// ���titleid��Ϊ�գ����ϴ����ǲ���ͼƬ��·��Ϊ<�û���>\<����id>
		// ���titleidΪ�գ����ϴ����ǲ���ͼƬ��·����Ϊ<�û���>\
		// if (titleid != null && !titleid.equals("")) {
		// relaPath = relaPath + "\\" + titleid;
		// }

		// �����ҳ�������������������µ�ѭ��������������һ����ȡ����
		Enumeration em = request.getParameterNames();
		while (em.hasMoreElements()) {
			String s = (String) em.nextElement();
		}

		ServletFileUpload upload = new ServletFileUpload(
				new DiskFileItemFactory());// ���� //�����ϴ��ļ�����

		try {
			// itemList�����д�jsp�л�ȡ������ͼƬ��ȫ·������
			List itemList = upload.parseRequest(request); // ����������л�ö����б�
			for (Iterator it = itemList.iterator(); it.hasNext();) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField())// ����ǷǱ�����
				{
					if (item.getName().length() <= 0)
						return;// ��ʾ������ļ���û��ѡ���ļ�

					// ��ʽ���������ļ����������������ļ�
					// ͳһLinux��windows��·���ָ���
					fileName = item.getName().replace("/", "\\");
					// c:\\xxx\\xxx.jpg
					if (fileName.lastIndexOf("\\") != -1) { // ���ȡ�����ļ���ַӵ��Ŀ¼·������Ŀ¼·��ȥ��
						fileName = fileName.substring(fileName
								.lastIndexOf("\\"));
					}

					// ��Ŀ�ڷ������ϵ�·��,��Ϊ�ϴ��ļ���Ҫ�����ڷ�����·����
					String path = "";
					// if (relaPath == null || relaPath.equals("")) {
					// path = "F:\\biyesheji\\image\\";
					// } else {
					// path = "F:\\biyesheji\\image\\" + relaPath + "\\";
					// }
					path = "F:\\biyesheji\\image\\";
					// ����·�����ļ�������·�����ļ�
					File f = new File(path, fileName);
					f.getParentFile().mkdirs();// ��֤·������

					InputStream ins = item.getInputStream();
					OutputStream ous = new FileOutputStream(f);
					byte[] tmp = new byte[1024];
					int len = -1;
					// ���ϴ��ļ������ж�ȡ���ݣ���д�뵽�����ķ������ļ���
					while ((len = ins.read(tmp)) != -1) {
						ous.write(tmp, 0, len);
					}
					ous.close();
					ins.close();

					// ͼƬ��Դ�ϴ��ɹ��󣬽���T_Photo���д���һ��ͼƬ��Դ�Ĺ����¼
					PhotoDAO pdao = DAOFactory.getPhotoDAO();
					TPhoto photo = new TPhoto();
					photo.setPhotoname("..\\images\\" + fileName);
					photo.setState(true);
					int photoid = pdao.addTPhoto(photo);

					respjson.code = LayuiData.SUCCESS; // ��ȡ���ݳɹ�
					respjson.msg = "�ļ��ϴ��ɹ�";
					respjson.result = "" + photoid; // ����ͼƬ��Դid
					respjson.result2 = "..\\images\\" + fileName;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			respjson.code = LayuiData.ERRR; // ��ȡ����ʧ��
			respjson.msg = "�ļ��ϴ�ʧ��";
		}

		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		// System.out.println(JSON.toJSONString(respjson));
		out.write(JSON.toJSONString(respjson));
	}

	public String getRootPath(String path) {
		String rootpath;
		int pos = path.lastIndexOf("\\");
		rootpath = path.substring(0, pos);
		pos = rootpath.lastIndexOf("\\");
		rootpath = rootpath.substring(0, pos + 1);
		return rootpath;
	}
}
