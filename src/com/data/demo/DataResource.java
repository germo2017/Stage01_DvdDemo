package com.data.demo;
import java.util.ArrayList;
import com.bean.demo.Dvd;


public class DataResource {
		/**
		 * 保存DVd的集合
		 */
		private ArrayList<Dvd> DvdList;
		
		/**
		 * 完成成员变量的实例化操作
		 */
		
		public DataResource() {			
			DvdList = new ArrayList<>();
		}

		public ArrayList<Dvd> getDvdList() {
			return DvdList;
		}

		
		
}
