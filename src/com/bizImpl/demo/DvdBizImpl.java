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
	private DvdBizImpl mInstance;//����
	private SimpleDateFormat sdf;
	
	//���췽��Ҳ˽��,test����Ҫ������.newInstance����
	private DvdBizImpl() throws ParseException {
		dataResource = new DataResource();
		DvdList = dataResource.getDvdList();
		
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		DvdList.add(new Dvd(1, "Ф���˵ľ���", 20, true, sdf.parse("2004-10-11")));
		DvdList.add(new Dvd(2, "���ջ���7",12,true, sdf.parse("2009-12-21")));
		DvdList.add(new Dvd(3, "��̫ƽ��",52, false, sdf.parse("2016-08-15")));
		DvdList.add(new Dvd(4, "���ν��4", 105, false, sdf.parse("2016-05-12")));
		DvdList.add(new Dvd(5, "�Ǽ��Ժ�13����Խ�ǳ�", 64, true, sdf.parse("2015-11-01")));
		DvdList.add(new Dvd(6, "��Ұ����", 66, false, sdf.parse("2017-05-18")));
	}
	
	public DvdBizImpl newInstance() throws ParseException {
		if (mInstance == null) {
			mInstance = new DvdBizImpl();
		}
		return mInstance;
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
	public void showDvd() {
		// TODO Auto-generated method stub
		
	}

}
