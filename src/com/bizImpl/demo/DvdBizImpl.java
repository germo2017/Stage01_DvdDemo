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
	private static DvdBizImpl mInstance;//单例
	private SimpleDateFormat sdf;
	DvdDaoImpl dd;//
	
	//构造方法也私有,test中需要用类名.newInstance方法
	private DvdBizImpl() throws ParseException {
		dataResource = new DataResource();
		DvdList = dataResource.getDvdList();
		dd = new DvdDaoImpl();//需创建DvdDaoImpl对象
		
		//sdf = new SimpleDateFormat("yyyy-MM-dd");
/*		DvdList.add(new Dvd(1, "肖生克的救赎", 20, true, "2004-10-11"));//sdf.parse("2004-10-11")
		DvdList.add(new Dvd(2, "最终幻想7",12,true, "2009-12-21"));//sdf.parse("2009-12-21")
		DvdList.add(new Dvd(3, "环太平洋",52, false, "2016-08-15"));//sdf.parse("2016-08-15")
		DvdList.add(new Dvd(4, "变形金刚4", 105, false, "2016-05-12"));//sdf.parse("2016-05-12")
		DvdList.add(new Dvd(5, "星际迷航13：超越星辰", 64, true, "2015-11-01"));//sdf.parse("2015-11-01")
		DvdList.add(new Dvd(6, "荒野猎人", 66, false, "2017-05-18"));//sdf.parse("2017-05-18")
*/	
	}
	
	public static DvdBizImpl newInstance() throws ParseException {
		if (mInstance == null) {
			mInstance = new DvdBizImpl();
		}
		return mInstance;
	}
	
	//显示可借和已借出的DVD
	@Override
	public void showDvd() {			
		try {
			DvdList = dd.showDVD();//★2 dd无法.showDVD()
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("以下为已借出的DVD列表：");
		for (Dvd dvd : DvdList) {
			if(!dvd.isDvdStatus()) {
				System.out.println(dvd.toString());
			}
		}
		System.out.println("以下为已借出的DVD列表：");
		for (Dvd dvd : DvdList) {
			if(dvd.isDvdStatus()) {
				System.out.println(dvd.toString());
			}
		}
	
	}
	//管理员权限
	@Override
	public void addDvd() {
		
		
	}
	
	@Override
	public void searchDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要查找的DVDID:");
		
		try {
			String dvdIdOrDvdName = sc.next();
			if (dvdIdOrDvdName == null ||dvdIdOrDvdName.length() == 0) {
				System.out.println("对不起,请输入非空内容!");
			}
			Dvd di = dd.getDvdByDvdIdOrDvdName(dvdIdOrDvdName);//空指针
			System.out.println("以下为您搜索的DVD信息:");
			System.out.println(di.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	
	}
	//管理员权限
	@Override
	public void deleteDvd() {
		// TODO Auto-generated method stub
		
	}
	//修改DVD，管理员权限
	@Override
	public void reviseDvd() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void lendDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要借阅的DVD名称:");
		String dvdName = sc.next();
		if (dvdName == null || dvdName.length() == 0) {
			System.out.println("对不起,请输入非空内容!");
		}
		try {
			if(dd.lendDvdByDvdName(dvdName)) {
				System.out.println("借阅DVD成功！");
			}else {
				System.out.println("此DVD已借出，不可借阅，或您输入的DVD名称有误，借阅失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		//sc.close();

	}

	@Override
	public void returnDvd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要归还的DVD名称:");
		String dvdName = sc.next();
		if (dvdName == null || dvdName.length() == 0) {
			System.out.println("对不起,请输入非空内容!");
		}
		try {
			if(dd.returnDvdByDvdName(dvdName)) {
				System.out.println("归还DVD成功！");
			}else {
				System.out.println("您输入的DVD名称有误，归还失败，或此DVD已归还在库，无需归还！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		sc.close();
	
	}

	@Override
	public void showHotDvd() {
		try {
			DvdList = dd.showDVD();//★2 dd无法.showDVD()
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
