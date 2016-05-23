package biz;

import java.util.ArrayList;

import entity.Book;

public interface BookBiz {
	public ArrayList<Object> allBook();
	public boolean LibBook(Object book);
}
