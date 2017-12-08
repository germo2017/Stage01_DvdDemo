package com.daoImpl;

//操作数据库数据的实现类
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.demo.Dvd;
import com.dao.demo.DvdDao;

public class DvdDaoImpl implements DvdDao {

	private Connection mConnection;
	private PreparedStatement pStatement;
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
		// --问号叫做占位符.
		String sql = "select * from DVD_DVD where DVDID = ?";
		// --通过连接获取PreparedStatement对象
		pStatement = mConnection.prepareStatement(sql);
		// --通过PreparedStatement对象给占位符做赋值操作
		pStatement.setString(1, dvdIdOrDvdName);

		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		// executeQuery是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rSet = pStatement.executeQuery();
		if (rSet == null) {
			return null;
		}
		Dvd dvd = null;
		while (rSet.next()) {
			dvd = new Dvd();
			dvd.setDvdId(rSet.getInt("DVDID"));
			dvd.setDvdName(rSet.getString("DVDNAME"));
			dvd.setDvdLendDate(rSet.getString("dvdLendDate"));
			dvd.setDvdStatus((rSet.getInt("DVDStatus") == 1) ? true : false);
			dvd.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
			// System.out.println(dvd);
		}
		return dvd;
	}

	public ArrayList<Dvd> showDVD() throws SQLException {
		// --问号叫做占位符.
		ArrayList<Dvd> array = new ArrayList<>();
		String sql = "select * from DVD_DVD";
		// --通过连接获取PreparedStatement对象
		pStatement = mConnection.prepareStatement(sql);
		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		rSet = pStatement.executeQuery();
		// executeQuery是查询专用
		pStatement.executeUpdate();
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		if (rSet == null) {
			return null;
		}
		Dvd dvd = null;
		while (rSet.next()) {
			dvd = new Dvd();
			dvd.setDvdId(rSet.getInt("DVDID"));
			dvd.setDvdName(rSet.getString("DVDNAME"));
			dvd.setDvdLendDate(rSet.getString("dvdLendDate"));
			dvd.setDvdStatus((rSet.getInt("DVDStatus") == 1) ? true : false);
			dvd.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
			array.add(dvd);
		}
		return array;
	}

	/**
	 * 归还DVD的数据库操作方法
	 */

	public boolean returnDvdByDvdName(String dvdName) throws SQLException {
		// --问号叫做占位符.
		String sql = "update DVD_DVD set DVDSTATUS= 1 where DVDName = ?";
		// --通过连接获取PreparedStatement对象
		pStatement = mConnection.prepareStatement(sql);
		// --通过PreparedStatement对象给占位符做赋值操作
		pStatement.setString(1, dvdName);

		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		// executeUpdate更新
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rInt = pStatement.executeUpdate();// ★3若临时修改了DVDName,则需要重启数据库，否则卡在这儿
		if (rInt == 1) {
			return true;
		}
		return false;
	}

	/**
	 * 借阅DVD的数据库操作方法
	 */
	public boolean lendDvdByDvdName(String dvdName) throws SQLException {
		String sql0 = "select * from DVD_DVD where DVDName = ?";
		pStatement = mConnection.prepareStatement(sql0);
		pStatement.setString(1, dvdName);
		rSet = pStatement.executeQuery();
		if (rSet == null) {
			return false;
		}
		// 若无此图书或为不可借阅状态0，则直接return false
		//if (rSet == null || rSet.getInt("DVDStatus") == 0)--java.sql.SQLException: 未调用 ResultSet.next
		
		if (!rSet.next()) {
			return false;
		} else if (rSet.getInt("DVDStatus") == 0){
			return false;
		}else {
			;
		}

		// --问号叫做占位符.
		String sql = "update DVD_DVD set DVDSTATUS= 0, DVDLendCount = DVDLendCount + 1 where DVDName = ?";
		// --通过连接获取PreparedStatement对象
		pStatement = mConnection.prepareStatement(sql);
		// --通过PreparedStatement对象给占位符做赋值操作
		pStatement.setString(1, dvdName);

		// --通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		// executeUpdate更新
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rInt = pStatement.executeUpdate();// ★3若临时修改了DVDName,则需要重启数据库，否则卡在这儿
		if (rInt == 1) {
			return true;
		}
		return false;
	}

}
