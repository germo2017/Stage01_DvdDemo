package com.daoImpl;

//�������ݿ����ݵ�ʵ����
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
		// --�ʺŽ���ռλ��.
		String sql = "select * from DVD_DVD where DVDID = ?";
		// --ͨ�����ӻ�ȡPreparedStatement����
		pStatement = mConnection.prepareStatement(sql);
		// --ͨ��PreparedStatement�����ռλ������ֵ����
		pStatement.setString(1, dvdIdOrDvdName);

		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		// executeQuery�ǲ�ѯר��
		/*
		 * �����ĵ���������������.��������Ϊnull
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
		// --�ʺŽ���ռλ��.
		ArrayList<Dvd> array = new ArrayList<>();
		String sql = "select * from DVD_DVD";
		// --ͨ�����ӻ�ȡPreparedStatement����
		pStatement = mConnection.prepareStatement(sql);
		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		rSet = pStatement.executeQuery();
		// executeQuery�ǲ�ѯר��
		pStatement.executeUpdate();
		/*
		 * �����ĵ���������������.��������Ϊnull
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
	 * �黹DVD�����ݿ��������
	 */

	public boolean returnDvdByDvdName(String dvdName) throws SQLException {
		// --�ʺŽ���ռλ��.
		String sql = "update DVD_DVD set DVDSTATUS= 1 where DVDName = ?";
		// --ͨ�����ӻ�ȡPreparedStatement����
		pStatement = mConnection.prepareStatement(sql);
		// --ͨ��PreparedStatement�����ռλ������ֵ����
		pStatement.setString(1, dvdName);

		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		// executeUpdate����
		/*
		 * �����ĵ���������������.��������Ϊnull
		 */
		rInt = pStatement.executeUpdate();// ��3����ʱ�޸���DVDName,����Ҫ�������ݿ⣬���������
		if (rInt == 1) {
			return true;
		}
		return false;
	}

	/**
	 * ����DVD�����ݿ��������
	 */
	public boolean lendDvdByDvdName(String dvdName) throws SQLException {
		String sql0 = "select * from DVD_DVD where DVDName = ?";
		pStatement = mConnection.prepareStatement(sql0);
		pStatement.setString(1, dvdName);
		rSet = pStatement.executeQuery();
		if (rSet == null) {
			return false;
		}
		// ���޴�ͼ���Ϊ���ɽ���״̬0����ֱ��return false
		//if (rSet == null || rSet.getInt("DVDStatus") == 0)--java.sql.SQLException: δ���� ResultSet.next
		
		if (!rSet.next()) {
			return false;
		} else if (rSet.getInt("DVDStatus") == 0){
			return false;
		}else {
			;
		}

		// --�ʺŽ���ռλ��.
		String sql = "update DVD_DVD set DVDSTATUS= 0, DVDLendCount = DVDLendCount + 1 where DVDName = ?";
		// --ͨ�����ӻ�ȡPreparedStatement����
		pStatement = mConnection.prepareStatement(sql);
		// --ͨ��PreparedStatement�����ռλ������ֵ����
		pStatement.setString(1, dvdName);

		// --ͨ��PreparedStatement���÷�����ִ�в�ѯ��䲢��ȡ���������
		// executeUpdate����
		/*
		 * �����ĵ���������������.��������Ϊnull
		 */
		rInt = pStatement.executeUpdate();// ��3����ʱ�޸���DVDName,����Ҫ�������ݿ⣬���������
		if (rInt == 1) {
			return true;
		}
		return false;
	}

}
