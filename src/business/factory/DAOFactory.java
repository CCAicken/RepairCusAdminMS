package business.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.AppointmentDAO;
import business.dao.ArticlesContentDAO;
import business.dao.ArticlesDAO;
import business.dao.ArticlesTypeDAO;
import business.dao.BrandDAO;
import business.dao.CarDAO;
import business.dao.CarTypeDAO;
import business.dao.CustomerDAO;
import business.dao.PhotoDAO;
import business.dao.RoleDAO;
import business.dao.RoleSysModelDAO;
import business.dao.SystemLogDAO;
import business.dao.SystemMenuDAO;
import business.dao.UserDAO;
import business.dao.UserTypeDAO;

public class DAOFactory {
	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
	}

	/**
	 * ����һ�����ڲ���ԤԼ����appointmentdao����
	 * 
	 * @return AppointmentDAO
	 */
	public static AppointmentDAO getAppointmentDAO() {
		return (AppointmentDAO) ctx.getBean("appointmentdao");
	}

	/**
	 * ����һ�����ڲ����������ݵ�articlescontentdao����
	 * 
	 * @return ArticlesContentDAO
	 */
	public static ArticlesContentDAO getArticlesContentDAO() {
		return (ArticlesContentDAO) ctx.getBean("articlescontentdao");
	}

	/**
	 * ����һ�����ڲ������� ��articlesdao����
	 * 
	 * @return ArticlesDAO
	 */
	public static ArticlesDAO getArticlesDAO() {
		return (ArticlesDAO) ctx.getBean("articlesdao");
	}

	/**
	 * ����һ�����ڲ����������͵�articlestypedao����
	 * 
	 * @return ArticlesTypeDAO
	 */
	public static ArticlesTypeDAO getArticlesTypeDAO() {
		return (ArticlesTypeDAO) ctx.getBean("articlestypedao");
	}

	/**
	 * ����һ�����ڲ���Ʒ�Ƶ�BrandDAO����
	 * 
	 * @return BrandDAO
	 */
	public static BrandDAO getBrandDAO() {
		return (BrandDAO) ctx.getBean("branddao");
	}

	/**
	 * ����һ�����ڲ���������CarDAO����
	 * 
	 * @return CarDAO
	 */
	public static CarDAO getCarDAO() {
		return (CarDAO) ctx.getBean("cardao");
	}

	/**
	 * ����һ�����ڲ����������͵�CarTypeDAO����
	 * 
	 * @return CarTypeDAO
	 */
	public static CarTypeDAO getCarTypeDAO() {
		return (CarTypeDAO) ctx.getBean("cartypedao");
	}

	/**
	 * ����һ�����ڲ����ͻ���CustomerDAO����
	 * 
	 * @return CustomerDAO
	 */
	public static CustomerDAO getCustomerDAO() {
		return (CustomerDAO) ctx.getBean("customerdao");
	}

	/**
	 * ����һ�����ڲ���ͼƬ��Դ��PhotoDAO����
	 * 
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO() {
		return (PhotoDAO) ctx.getBean("photodao");
	}

	/**
	 * ����һ�����ڲ�����ɫ��RoleDAO����
	 * 
	 * @return RoleDAO
	 */
	public static RoleDAO getRoleDAO() {
		return (RoleDAO) ctx.getBean("roledao");
	}

	/**
	 * ����һ�����ڲ�����ɫ�˵���ϵ��RoleSysModelDAO����
	 * 
	 * @return RoleSysModelDAO
	 */
	public static RoleSysModelDAO getRoleSysModelDAO() {
		return (RoleSysModelDAO) ctx.getBean("rolesysmodeldao");
	}

	/**
	 * �õ�һ������ϵͳ��־��SystemLogDAOʵ�������
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * �õ�һ������ϵͳ�˵���SystemMenuDAOʵ�������
	 * 
	 * @return SystemMenuDAO
	 */
	public static SystemMenuDAO getSystemMenuDAO() {
		return (SystemMenuDAO) ctx.getBean("systemmenudao");
	}

	/**
	 * ����һ�����ڶ��û���Ϣ������UserDAO����
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

	/**
	 * ����һ�����ڶ��û����Ͳ�����UserTypeDAO����
	 * 
	 * @return UserTypeDAO
	 */
	public static UserTypeDAO getUserTypeDAO() {
		return (UserTypeDAO) ctx.getBean("usertypedao");
	}

}
