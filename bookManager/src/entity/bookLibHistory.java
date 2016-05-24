package entity;

import java.sql.Date;

public class bookLibHistory {
	private int bookLibHistory;
	private Book book;
	private Reader reader;
	private Date hdate;
	private Date LibDate;
	
	public Date getHdate() {
		return hdate;
	}
	public void setHdate(Date hdate) {
		this.hdate = hdate;
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
