package com.data.demo;
import java.util.ArrayList;
import com.bean.demo.Dvd;


public class DataResource {
		/**
		 * ����DVd�ļ���
		 */
		private ArrayList<Dvd> DvdList;
		
		/**
		 * ��ɳ�Ա������ʵ��������
		 */
		
		public DataResource() {			
			DvdList = new ArrayList<>();
		}

		public ArrayList<Dvd> getDvdList() {
			return DvdList;
		}

		
		
}
