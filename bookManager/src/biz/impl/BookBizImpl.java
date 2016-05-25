package biz.impl;

import java.util.ArrayList;

import biz.BookBiz;
import entity.Book;
import entity.Reader;
import factory.factory;

public class BookBizImpl implements BookBiz {
	private factory f = new factory();
	public ArrayList<Object> allBook() {
		ArrayList<Object> bList =  f.getBookDaoImpl().selectBook();
		return bList;
	}
	public boolean LibBook(Object book) {
		boolean flag = false;
		Book b =(Book)book;
		b.setStatus(0);
		flag = f.getBookDaoImpl().updateBookStatus(b);
		return flag;
	}
	public ArrayList<Object> allHistory() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Object> readerHistory(Reader reader) {
		return f.getBookLibHistoryDaoImpl().selectReaderBookHistory(reader);
	}

}
