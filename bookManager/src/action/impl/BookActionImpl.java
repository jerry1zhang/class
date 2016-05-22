package action.impl;

import java.util.ArrayList;

import action.BookAction;
import entity.Book;
import factory.factory;

public class BookActionImpl implements BookAction {
	private factory f = new factory();
	public ArrayList<Book> allBook() {
		ArrayList<Book> bList = f.getBookBizImpl().allBook();
		return bList;
	}

}
