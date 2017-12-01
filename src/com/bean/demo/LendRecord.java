package com.bean.demo;
import java.util.Date;

public class LendRecord implements Comparable<LendRecord>{
	private int lrId;
	private String IrNumber;
	private int dvdId;
	private String dvdName;
	private Date lendDate;
	private Date returnDate;
	private int userId;
	private boolean liStatus;
	
	public int getLrId() {
		return lrId;
	}
	public void setLrId(int lrId) {
		this.lrId = lrId;
	}
	public String getIrNumber() {
		return IrNumber;
	}
	public void setIrNumber(String irNumber) {
		IrNumber = irNumber;
	}
	
	
/*	public int getDvdId() {
		return dvdId;
	}
	public void setDvdId(Dvd d) {
		this.dvdId = d.getDvdId();
	}
	
	
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(Dvd d) {
		this.dvdName = d.getDvdName();
	}
	
*/	
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
/*
	public int getUserId() {
		return userId;
	}
	public void setUserId(User u) {
		this.userId = u.getUserId();
	}
	
*/	
	
	public boolean isLiStatus() {
		return liStatus;
	}
	public void setLiStatus(boolean liStatus) {
		this.liStatus = liStatus;
	}
	
	public LendRecord(Dvd d, User u, int lrId, String irNumber, Date lendDate, Date returnDate,
			boolean liStatus) {
		super();
		this.lrId = lrId;
		IrNumber = irNumber;
		this.dvdId = d.getDvdId();
		this.dvdName = d.getDvdName();
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.userId = u.getUserId();
		this.liStatus = liStatus;
	}
	
	public LendRecord() {
		super();
	}
	
	public LendRecord(Dvd d, User u, String irNumber, Date lendDate, Date returnDate, boolean liStatus) {
		super();
		IrNumber = irNumber;
		this.dvdId = d.getDvdId();
		this.dvdName = d.getDvdName();
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.userId = u.getUserId();
		this.liStatus = liStatus;
	}
	
	@Override
	public String toString() {
		return "LendRecord [lrId=" + lrId + ", IrNumber=" + IrNumber + ", dvdId=" + dvdId + ", dvdName=" + dvdName
				+ ", lendDate=" + lendDate + ", returnDate=" + returnDate + ", userId=" + userId + ", liStatus="
				+ liStatus + "]";
	}
	/*
	@Override
	public int compareTo(Object o) {
		LendRecord lr = (LendRecord)o;
		if(this.lendDate.after(lr.lendDate)) {
			return 1;
		}else if(this.lendDate.before(lr.lendDate)){
			return -1;
		}else {
			return 0;
		}
	}
	*/
	@Override
	public int compareTo(LendRecord o) {
		return this.lendDate.compareTo(o.lendDate);
		
	}
	
	
	
	
}
