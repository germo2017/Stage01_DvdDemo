package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.demo.Dvd;
import com.dao.demo.DvdDao;

public class DvdDaoImpl implements DvdDao{

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;	
	private DBHelper mDB;
	private int rInt;
	
	public DvdDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
		rSet = null;
	}
	
	
	@Override
	public Dvd getDvdByDvdIdOrDvdName(String dvdIdOrDvdName) throws SQLException {
		//--问号叫做占位符.
		String sql = "select * from DVD_DVD where DVDID = ?";
		//--通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
				//--通过PreparedStatement对象给占位符做赋值操作
				mStatement.setString(1, dvdIdOrDvdName);
				
				//--通过PreparedStatement调用方法来执行查询语句并获取结果集对象
				//executeQuery  是查询专用
				/*
				 * 如果查的到则结果集中有数据.否则结果集为null
				 */
				rSet = mStatement.executeQuery();
				if (rSet == null) {
					return null;
				}
				Dvd dvd = null;
				while (rSet.next()) {
					dvd = new Dvd();
					dvd.setDvdId(rSet.getInt("DVDID"));	
					dvd.setDvdName(rSet.getString("DVDNAME"));	
					dvd.setDvdLendDate(rSet.getString("dvdLendDate"));
					dvd.setDvdStatus((rSet.getInt("DVDStatus")==1)?true:false);
					dvd.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
					System.out.println(dvd);
				}		
				return dvd;
		
	}

}
