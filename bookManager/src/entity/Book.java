package entity;

import java.sql.Date;

public class Book {
	private int bid;//书籍编号
	private String name;//书籍名称
	private Date bDate;//书籍入馆时间
	private String bPress;//出版社
	private String bAuthor;//书籍作者
	private double bValue;//书籍价格
	private int bookKindsNo;//书籍类型编号
	private String bookKindsName;//书籍类型名称
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbPress() {
		return bPress;
	}
	public void setbPress(String bPress) {
		this.bPress = bPress;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public double getbValue() {
		return bValue;
	}
	public void setbValue(double bValue) {
		this.bValue = bValue;
	}
	public int getBookKindsNo() {
		return bookKindsNo;
	}
	public void setBookKindsNo(int bookKindsNo) {
		this.bookKindsNo = bookKindsNo;
	}
	public String getBookKindsName() {
		return bookKindsName;
	}
	public void setBookKindsName(String bookKindsName) {
		this.bookKindsName = bookKindsName;
	}
	
}
