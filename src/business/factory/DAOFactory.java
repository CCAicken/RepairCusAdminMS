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
	 * 返回一个用于操作预约单的appointmentdao对象
	 * 
	 * @return AppointmentDAO
	 */
	public static AppointmentDAO getAppointmentDAO() {
		return (AppointmentDAO) ctx.getBean("appointmentdao");
	}

	/**
	 * 返回一个用于操作文章内容的articlescontentdao对象
	 * 
	 * @return ArticlesContentDAO
	 */
	public static ArticlesContentDAO getArticlesContentDAO() {
		return (ArticlesContentDAO) ctx.getBean("articlescontentdao");
	}

	/**
	 * 返回一个用于操作文章 的articlesdao对象
	 * 
	 * @return ArticlesDAO
	 */
	public static ArticlesDAO getArticlesDAO() {
		return (ArticlesDAO) ctx.getBean("articlesdao");
	}

	/**
	 * 返回一个用于操作文章类型的articlestypedao对象
	 * 
	 * @return ArticlesTypeDAO
	 */
	public static ArticlesTypeDAO getArticlesTypeDAO() {
		return (ArticlesTypeDAO) ctx.getBean("articlestypedao");
	}

	/**
	 * 返回一个用于操作品牌的BrandDAO对象
	 * 
	 * @return BrandDAO
	 */
	public static BrandDAO getBrandDAO() {
		return (BrandDAO) ctx.getBean("branddao");
	}

	/**
	 * 返回一个用于操作车辆的CarDAO对象
	 * 
	 * @return CarDAO
	 */
	public static CarDAO getCarDAO() {
		return (CarDAO) ctx.getBean("cardao");
	}

	/**
	 * 返回一个用于操作车辆类型的CarTypeDAO对象
	 * 
	 * @return CarTypeDAO
	 */
	public static CarTypeDAO getCarTypeDAO() {
		return (CarTypeDAO) ctx.getBean("cartypedao");
	}

	/**
	 * 返回一个用于操作客户的CustomerDAO对象
	 * 
	 * @return CustomerDAO
	 */
	public static CustomerDAO getCustomerDAO() {
		return (CustomerDAO) ctx.getBean("customerdao");
	}

	/**
	 * 返回一个用于操作图片资源的PhotoDAO对象
	 * 
	 * @return PhotoDAO
	 */
	public static PhotoDAO getPhotoDAO() {
		return (PhotoDAO) ctx.getBean("photodao");
	}

	/**
	 * 返回一个用于操作角色的RoleDAO对象
	 * 
	 * @return RoleDAO
	 */
	public static RoleDAO getRoleDAO() {
		return (RoleDAO) ctx.getBean("roledao");
	}

	/**
	 * 返回一个用于操作角色菜单关系的RoleSysModelDAO对象
	 * 
	 * @return RoleSysModelDAO
	 */
	public static RoleSysModelDAO getRoleSysModelDAO() {
		return (RoleSysModelDAO) ctx.getBean("rolesysmodeldao");
	}

	/**
	 * 得到一个用于系统日志的SystemLogDAO实现类对象
	 * 
	 * @return SystemLogDAO
	 */
	public static SystemLogDAO getSystemLogDAO() {
		return (SystemLogDAO) ctx.getBean("systemlogdao");
	}

	/**
	 * 得到一个用于系统菜单的SystemMenuDAO实现类对象
	 * 
	 * @return SystemMenuDAO
	 */
	public static SystemMenuDAO getSystemMenuDAO() {
		return (SystemMenuDAO) ctx.getBean("systemmenudao");
	}

	/**
	 * 返回一个用于对用户信息操作的UserDAO对象
	 * 
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO() {
		return (UserDAO) ctx.getBean("userdao");
	}

	/**
	 * 返回一个用于对用户类型操作的UserTypeDAO对象
	 * 
	 * @return UserTypeDAO
	 */
	public static UserTypeDAO getUserTypeDAO() {
		return (UserTypeDAO) ctx.getBean("usertypedao");
	}

}
