package action;

import java.util.ArrayList;

import entity.Book;
import entity.Reader;

public interface BookAction {
	public ArrayList<Object> allBook();
	public boolean LibBook(ArrayList<Object> bList,Reader reader);
	public ArrayList<Object> readerBookHistory(Reader reader);
	public boolean ReturnBookStatus(Book book);
	public boolean LibBookStatus(Book book);
}
