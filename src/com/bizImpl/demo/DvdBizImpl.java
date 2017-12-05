package com.bizImpl.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.bean.demo.Dvd;
import com.biz.demo.DvdBiz;
import com.data.demo.DataResource;

public class DvdBizImpl implements DvdBiz{
	private DataResource dataResource;
	private ArrayList<Dvd> DvdList;
	private DvdBizImpl mInstance;//单例
	private SimpleDateFormat sdf;
	
	//构造方法也私有,test中需要用类名.newInstance方法
	private DvdBizImpl() throws ParseException {
		dataResource = new DataResource();
		DvdList = dataResource.getDvdList();
		
		//sdf = new SimpleDateFormat("yyyy-MM-dd");
		DvdList.add(new Dvd(1, "肖生克的救赎", 20, true, "2004-10-11"));//sdf.parse("2004-10-11")
		DvdList.add(new Dvd(2, "最终幻想7",12,true, "2009-12-21"));//sdf.parse("2009-12-21")
		DvdList.add(new Dvd(3, "环太平洋",52, false, "2016-08-15"));//sdf.parse("2016-08-15")
		DvdList.add(new Dvd(4, "变形金刚4", 105, false, "2016-05-12"));//sdf.parse("2016-05-12")
		DvdList.add(new Dvd(5, "星际迷航13：超越星辰", 64, true, "2015-11-01"));//sdf.parse("2015-11-01")
		DvdList.add(new Dvd(6, "荒野猎人", 66, false, "2017-05-18"));//sdf.parse("2017-05-18")
	}
	
	public DvdBizImpl newInstance() throws ParseException {
		if (mInstance == null) {
			mInstance = new DvdBizImpl();
		}
		return mInstance;
	}
	//显示可借和已借出的DVD
	@Override
	public void showDvd() {
		System.out.println("以下为已借出的DVD列表:");
		
		System.out.println("以下为可借的DVD列表:");
		
	}
	
	@Override
	public void addDvd() {
		
		
	}

	@Override
	public void searchDvd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDvd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reviseDvd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lendDvd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnDvd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showHotDvd() {
		// TODO Auto-generated method stub
		
	}

	

}
