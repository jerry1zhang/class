package biz;

import java.util.ArrayList;

import entity.Book;
import entity.Reader;

public interface BookBiz {
	public ArrayList<Object> allBook();
	public boolean LibBook(Object book);
	public ArrayList<Object> readerHistory(Reader reader);
}
