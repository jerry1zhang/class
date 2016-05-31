package biz;

import java.util.ArrayList;

import entity.Book;
import entity.Reader;

public interface BookBiz {
	public ArrayList<Object> allBook();
	public boolean LibBook(Object book,Reader reader);
	public ArrayList<Object> readerHistory(Reader reader);
	public boolean changeBookStatus(Book book);
	public ArrayList<entity.bookKinds> bookKinds();
	public boolean addBook(Book book);
	public boolean changeBook(Book book);
}
