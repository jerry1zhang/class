package entity;

import java.sql.Date;

public class bookLibHistory {
	private int bookLibHistory;
	private Book book;
	private Reader reader;
	private Date LibDate;
	private Date ReturnDate;
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	private int status;//该记录是否有效 0=T 1=F
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLibDate() {
		return LibDate;
	}
	public void setLibDate(Date libDate) {
		LibDate = libDate;
	}
	public int getBookLibHistory() {
		return bookLibHistory;
	}
	public void setBookLibHistory(int bookLibHistory) {
		this.bookLibHistory = bookLibHistory;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}

	
}
