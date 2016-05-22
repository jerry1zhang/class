package entity;

import java.sql.Date;

public class bookLibHistory {
	private int bookLibHistory;
	private Book book;
	private Reader reader;
	private Date date;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
