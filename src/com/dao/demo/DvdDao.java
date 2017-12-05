package com.dao.demo;
import java.sql.SQLException;
import com.bean.demo.Dvd;
//--数据库操作. 增删改查代码是写在这里的.

	public interface DvdDao {
		//根据DvdId 或 DvdName户获取DVD对象.(从数据库中查询出来的.)
		public Dvd getDvdByDvdIdOrDvdName(String dvdIdOrDvdName) throws SQLException;

}
