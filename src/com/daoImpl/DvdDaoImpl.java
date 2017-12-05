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
		//--�ʺŽ���ռλ��.
		String sql = "select * from DVD_DVD where DVDID = ?";
		//--ͨ�����ӻ�ȡPreparedStatement����
		mStatement = mConnection.prepareStatement(sql);
				//--ͨ��PreparedStatement�����ռλ������ֵ����
				mStatement.setString(1, dvdIdOrDvdName);
				
				//--ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
				//executeQuery  �ǲ�ѯר��
				/*
				 * �����ĵ���������������.��������Ϊnull
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
