package biz.impl;

import java.util.ArrayList;

import biz.BookBiz;
import entity.Book;
import factory.factory;

public class BookBizImpl implements BookBiz {
	private factory f = new factory();
	public ArrayList<Book> allBook() {
		ArrayList<Book> bList =  f.getBookDaoImpl().selectBook();
		return bList;
	}

}
