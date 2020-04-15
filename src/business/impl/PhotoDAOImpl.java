package business.impl;

import java.util.List;

import model.TPhoto;

import org.springframework.stereotype.Component;

import annotation.Log;
import business.basic.iHibBaseDAO;
import business.basic.iHibBaseDAOImpl;
import business.dao.PhotoDAO;

import common.properties.OperType;

@Component("photodao")
public class PhotoDAOImpl implements PhotoDAO {

	private iHibBaseDAO bdao;

	public PhotoDAOImpl() {
		this.bdao = new iHibBaseDAOImpl();
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����������ѯͼƬ")
	@Override
	public List<TPhoto> getTPhotoList(String opreation) {
		if (opreation != "" || !opreation.equals("")) {
			return bdao.select(opreation);
		} else {
			return null;
		}
	}

	@Log(isSaveLog = true, operationType = OperType.ADD, operationName = "���ͼƬ")
	@Override
	public int addTPhoto(TPhoto TPhoto) {
		return (int) bdao.insert(TPhoto);
	}

	@Log(isSaveLog = true, operationType = OperType.DELETE, operationName = "ɾ��ͼƬ")
	@Override
	public boolean delTPhoto(int id) {
		// TODO Auto-generated method stub
		TPhoto TPhoto = (TPhoto) bdao.findById(TPhoto.class, id);

		return bdao.delete(TPhoto);
	}

	@Log(isSaveLog = true, operationType = OperType.MODIFY, operationName = "����ͼƬ")
	@Override
	public boolean updateTPhoto(TPhoto TPhoto) {
		return bdao.update(TPhoto);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "����ͼƬid��ѯ")
	@Override
	public TPhoto getTPhotoByid(int TPhotoid) {
		// TODO Auto-generated method stub
		return (TPhoto) bdao.findById(TPhoto.class, TPhotoid);
	}

	@Log(isSaveLog = true, operationType = OperType.QUERY, operationName = "���ݷ�ҳ��ѯͼƬ��Ϣ")
	@Override
	public List<TPhoto> selectTPhotoByPage(String opretion, int page, int limit) {
		String hql = "from TPhoto";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		hql += " order by photocreatetime desc";
		return bdao.selectByPage(hql, page, limit);
	}

	@Override
	public int getTPhotoAmount(String opretion) {
		String hql = "select count(photoid) from TPhoto ";
		if (opretion != null && !opretion.equals("")) {
			hql += opretion;
		}
		return bdao.selectValue(hql);
	}
}
