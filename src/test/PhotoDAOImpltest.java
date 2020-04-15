package test;

import static org.junit.Assert.fail;
import model.TPhoto;

import org.junit.Test;

import business.dao.PhotoDAO;
import business.impl.PhotoDAOImpl;

public class PhotoDAOImpltest {

	@Test
	public void testPhotoDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTPhotoList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTPhoto() {
		PhotoDAO pDao = new PhotoDAOImpl();
		TPhoto photo = new TPhoto();
		photo.setPhotoname("test.jpg");
		photo.setState(false);
		photo.setByuser("admin");
		System.out.println(pDao.addTPhoto(photo));
	}

	@Test
	public void testDelTPhoto() {
		PhotoDAO pDao = new PhotoDAOImpl();
		System.out.println(pDao.delTPhoto(176));
	}

	@Test
	public void testUpdateTPhoto() {
		PhotoDAO pDao = new PhotoDAOImpl();
		TPhoto photo = pDao.getTPhotoByid(175);
		photo.setByuser("admin");
		System.out.println(pDao.updateTPhoto(photo));
	}

	@Test
	public void testGetTPhotoByid() {
		PhotoDAO pDao = new PhotoDAOImpl();
		TPhoto photo = new TPhoto();
		photo = pDao.getTPhotoByid(175);
		System.out.println(photo.getPhotoname());
	}

}
