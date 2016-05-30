package action.impl;

import java.util.ArrayList;

import action.BookAction;
import entity.Book;
import entity.Reader;
import factory.factory;

public class BookActionImpl implements BookAction {
	private factory f = new factory();
	public ArrayList<Object> allBook() {
		ArrayList<Object> bList = f.getBookBizImpl().allBook();
		return bList;
	}
	public boolean LibBook(ArrayList<Object> bList,Reader reader){
		//TODO 可以考虑返回失败了哪些书
		boolean flag = false;
		int n = 0;
		
		for (int i = 0; i < bList.size(); i++) {
			Object book = bList.get(i);
			
			if (f.getBookBizImpl().LibBook(book,reader)) {
				n++;
			}
		}
		if (n==bList.size()) {
			flag = true;
		}
		return flag;
	}
	public ArrayList<Object> readerBookHistory(Reader reader) {
		return f.getBookBizImpl().readerHistory(reader);
	}
	public boolean ReturnBookStatus(Book book) {
		book.setStatus(1);
		return f.getBookBizImpl().changeBookStatus(book);
	}
	public boolean LibBookStatus(Book book) {
		book.setStatus(0);
		return f.getBookBizImpl().changeBookStatus(book);
	}

}
