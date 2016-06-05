package biz.impl;

import java.util.ArrayList;
import java.util.Date;

import biz.BookBiz;
import entity.Book;
import entity.Reader;
import entity.bookLibHistory;
import factory.factory;

public class BookBizImpl implements BookBiz {
	private factory f = new factory();
	public ArrayList<Object> allBook() {
		ArrayList<Object> bList =  f.getBookDaoImpl().selectBook();
		return bList;
	}
	public boolean LibBook(Object book,Reader reader) {
		boolean flag = false;
		Book b =(Book)book;
		b.setStatus(0);
		flag = f.getBookDaoImpl().updateBookStatus(b);
		bookLibHistory bookLibHistory = f.getbookLibHistory(b, reader);
		java.util.Date date = new Date();
		java.sql.Date d = new java.sql.Date(date.getTime());
		bookLibHistory.setHdate(d);
		f.getBookLibHistoryDaoImpl().createBookLibHistory(bookLibHistory, reader);
		return flag;
	}
	public ArrayList<Object> allHistory() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Object> readerHistory(Reader reader) {
		return f.getBookLibHistoryDaoImpl().selectReaderBookHistory(reader);
	}
	public boolean changeBookStatus(Book book) {
		return f.getBookDaoImpl().updateBookStatus(book);
	}
	public ArrayList<entity.bookKinds> bookKinds() {
		return f.getBookKindsDaoImpl().selectBookKinds();
	}
	public boolean addBook(Book book) {
		return f.getBookDaoImpl().createBook(book);
	}
	public boolean changeBook(Book book) {
		return f.getBookDaoImpl().updateBook(book);
	}

}
