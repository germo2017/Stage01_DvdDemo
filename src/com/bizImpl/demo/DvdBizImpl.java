package com.bizImpl.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.demo.Dvd;
import com.biz.demo.DvdBiz;
import com.dao.demo.DvdDao;
import com.daoImpl.DvdDaoImpl;
import com.data.demo.DataResource;
import com.view.demo.DvdView;

public class DvdBizImpl implements DvdBiz{
	private DataResource dataResource;
	private ArrayList<Dvd> DvdList;
	private static DvdBizImpl mInstance;//����
	private SimpleDateFormat sdf;
	DvdDaoImpl dd;//
	
	//���췽��Ҳ˽��,test����Ҫ������.newInstance����
	private DvdBizImpl() throws ParseException {
		dataResource = new DataResource();
		DvdList = dataResource.getDvdList();
		dd = new DvdDaoImpl();//�贴��DvdDaoImpl����
		
		//sdf = new SimpleDateFormat("yyyy-MM-dd");
/*		DvdList.add(new Dvd(1, "Ф���˵ľ���", 20, true, "2004-10-11"));//sdf.parse("2004-10-11")
		DvdList.add(new Dvd(2, "���ջ���7",12,true, "2009-12-21"));//sdf.parse("2009-12-21")
		DvdList.add(new Dvd(3, "��̫ƽ��",52, false, "2016-08-15"));//sdf.parse("2016-08-15")
		DvdList.add(new Dvd(4, "���ν��4", 105, false, "2016-05-12"));//sdf.parse("2016-05-12")
		DvdList.add(new Dvd(5, "�Ǽ��Ժ�13����Խ�ǳ�", 64, true, "2015-11-01"));//sdf.parse("2015-11-01")
		DvdList.add(new Dvd(6, "��Ұ����", 66, false, "2017-05-18"));//sdf.parse("2017-05-18")
*/	
	}
	
	public static DvdBizImpl newInstance() throws ParseException {
		if (mInstance == null) {
			mInstance = new DvdBizImpl();
		}
		return mInstance;
	}
	
	//��ʾ�ɽ���ѽ����DVD
	@Override
	public void showDvd() {			
		try {
			DvdList = dd.showDVD();//��2 dd�޷�.showDVD()
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("����Ϊ�ѽ����DVD�б�");
		for (Dvd dvd : DvdList) {
			if(!dvd.isDvdStatus()) {
				System.out.println(dvd.toString());
			}
		}
		System.out.println("����Ϊ�ѽ����DVD�б�");
		for (Dvd dvd : DvdList) {
			if(dvd.isDvdStatus()) {
				System.out.println(dvd.toString());
			}
		}
	
	}
	//����ԱȨ��
	@Override
	public void addDvd() {
		
		
	}
	
	@Override
	public void searchDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ�DVDID:");
		
		try {
			String dvdIdOrDvdName = sc.next();
			if (dvdIdOrDvdName == null ||dvdIdOrDvdName.length() == 0) {
				System.out.println("�Բ���,������ǿ�����!");
			}
			Dvd di = dd.getDvdByDvdIdOrDvdName(dvdIdOrDvdName);//��ָ��
			System.out.println("����Ϊ��������DVD��Ϣ:");
			System.out.println(di.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	
	}
	//����ԱȨ��
	@Override
	public void deleteDvd() {
		// TODO Auto-generated method stub
		
	}
	//�޸�DVD������ԱȨ��
	@Override
	public void reviseDvd() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void lendDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ���ĵ�DVD����:");
		String dvdName = sc.next();
		if (dvdName == null || dvdName.length() == 0) {
			System.out.println("�Բ���,������ǿ�����!");
		}
		try {
			if(dd.lendDvdByDvdName(dvdName)) {
				System.out.println("����DVD�ɹ���");
			}else {
				System.out.println("��DVD�ѽ�������ɽ��ģ����������DVD�������󣬽���ʧ�ܣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		//sc.close();

	}

	@Override
	public void returnDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ�黹��DVD����:");
		String dvdName = sc.next();
		if (dvdName == null || dvdName.length() == 0) {
			System.out.println("�Բ���,������ǿ�����!");
		}
		try {
			if(dd.returnDvdByDvdName(dvdName)) {
				System.out.println("�黹DVD�ɹ���");
			}else {
				System.out.println("�������DVD�������󣬹黹ʧ�ܣ����DVD�ѹ黹�ڿ⣬����黹��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		sc.close();
	
	}

	@Override
	public void showHotDvd() {
		try {
			DvdList = dd.showDVD();//��2 dd�޷�.showDVD()
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
