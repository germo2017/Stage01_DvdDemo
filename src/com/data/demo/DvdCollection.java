package com.data.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.bean.demo.Dvd;


/**
 * 
 * @ClassName:	 DvdCollection.java
 * @Package:	 com.data.demo
 * @Description: Dvd集合,用来初始化Dvd,输入几条数据
 *
 * @author	Administrator
 * @date	2017年11月21日下午7:40:57
 * @version	1.0
 */
public class DvdCollection {
	
	public DvdCollection() {
		super();
	}
	public DvdCollection(ArrayList<Dvd> ar) throws ParseException {		
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Dvd d1 = new Dvd(1, "肖生克的救赎", 20, true, sdf.parse("2004-10-11"));
		Dvd d2 = new Dvd(2, "最终幻想7",12,true, sdf.parse("2009-12-21"));
		Dvd d3 = new Dvd(3, "环太平洋",52, false, sdf.parse("2016-08-15"));
		Dvd d4 = new Dvd(4, "变形金刚4", 105, false, sdf.parse("2016-05-12"));		
		Dvd d5 = new Dvd(5, "星际迷航13：超越星辰", 64, true, sdf.parse("2015-11-01"));	
		Dvd d6 = new Dvd(6, "荒野猎人", 66, false, sdf.parse("2017-05-18"));	
		ar.add(d1);
		ar.add(d2);
		ar.add(d3);
		ar.add(d4);
		ar.add(d5);
		ar.add(d6);
	}
}
