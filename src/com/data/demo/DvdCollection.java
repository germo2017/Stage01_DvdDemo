package com.data.demo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.bean.demo.Dvd;


/**
 * 
 * @ClassName:	 DvdCollection.java
 * @Package:	 com.data.demo
 * @Description: Dvd����,������ʼ��Dvd,���뼸������
 *
 * @author	Administrator
 * @date	2017��11��21������7:40:57
 * @version	1.0
 */
public class DvdCollection {
	
	public DvdCollection() {
		super();
	}
	public DvdCollection(ArrayList<Dvd> ar) throws ParseException {		
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Dvd d1 = new Dvd(1, "Ф���˵ľ���", 20, true, sdf.parse("2004-10-11"));
		Dvd d2 = new Dvd(2, "���ջ���7",12,true, sdf.parse("2009-12-21"));
		Dvd d3 = new Dvd(3, "��̫ƽ��",52, false, sdf.parse("2016-08-15"));
		Dvd d4 = new Dvd(4, "���ν��4", 105, false, sdf.parse("2016-05-12"));		
		Dvd d5 = new Dvd(5, "�Ǽ��Ժ�13����Խ�ǳ�", 64, true, sdf.parse("2015-11-01"));	
		Dvd d6 = new Dvd(6, "��Ұ����", 66, false, sdf.parse("2017-05-18"));	
		ar.add(d1);
		ar.add(d2);
		ar.add(d3);
		ar.add(d4);
		ar.add(d5);
		ar.add(d6);
	}
}
