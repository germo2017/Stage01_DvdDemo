package com.dao.demo;
import java.sql.SQLException;
import com.bean.demo.Dvd;
//--���ݿ����. ��ɾ�Ĳ������д�������.

	public interface DvdDao {
		//����DvdId �� DvdName����ȡDVD����.(�����ݿ��в�ѯ������.)
		public Dvd getDvdByDvdIdOrDvdName(String dvdIdOrDvdName) throws SQLException;

}
