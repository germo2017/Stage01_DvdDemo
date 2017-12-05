package com.bean.demo;

import java.util.Date;

/**
 * 
 * @ClassName:	 Dvd.java
 * @Package:	 com.bean.demo
 * @Description: TODO
 *
 * @author	Administrator
 * @date	2017年11月16日下午7:30:43
 * @version	1.0
 */
public class Dvd {
	
	private int dvdId;
	private String dvdName;
	private int dvdLendCount;
	//private String dvdLendDate;
	private boolean dvdStatus;
	private String dvdLendDate;
	
	public int getDvdId() {
		return dvdId;
	}
	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public int getDvdLendCount() {
		return dvdLendCount;
	}
	public void setDvdLendCount(int dvdLendCount) {
		this.dvdLendCount = dvdLendCount;
	}
	public boolean isDvdStatus() {
		return dvdStatus;
	}
	public void setDvdStatus(boolean dvdStatus) {
		this.dvdStatus = dvdStatus;
	}
	
	public String getDvdLendDate() {
		return dvdLendDate;
	}
	public void setDvdLendDate(String string) {
		this.dvdLendDate = string;
	}
	
	public Dvd(int dvdId, String dvdName, int dvdLendCount, boolean dvdStatus, String dvdLendDate) {
		super();
		this.dvdId = dvdId;
		this.dvdName = dvdName;
		this.dvdLendCount = dvdLendCount;
		this.dvdStatus = dvdStatus;
		this.dvdLendDate = dvdLendDate;
	}
	public Dvd() {
		super();
	}	
	
	public Dvd(String dvdName, int dvdLendCount, boolean dvdStatus, String dvdLendDate) {
		super();
		this.dvdName = dvdName;
		this.dvdLendCount = dvdLendCount;
		this.dvdStatus = dvdStatus;
		this.dvdLendDate = dvdLendDate;
	}
	
	@Override
	public String toString() {
		return "Dvd [dvdID=" + dvdId + ", dvdName=" + dvdName + ", dvdLendCount=" + dvdLendCount + ", dvdStatus="
				+ dvdStatus + ", dvdLendDate=" + dvdLendDate + "]";
	}
	
	
	
	

}
