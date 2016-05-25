package action;

import java.util.ArrayList;

import entity.Book;
import entity.Reader;

public interface BookAction {
	public ArrayList<Object> allBook();
	public boolean LibBook(ArrayList<Object> bList);
	public ArrayList<Object> readerBookHistory(Reader reader);
}
