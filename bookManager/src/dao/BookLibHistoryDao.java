package dao;

import java.util.ArrayList;

import entity.Book;
import entity.Reader;
import entity.bookLibHistory;

public interface BookLibHistoryDao {
	public boolean createBookKinds(bookLibHistory bookLibHistory,Reader reader);
	public boolean delectBookKinds(bookLibHistory bookLibHistory);
	public boolean updateBookKinds(bookLibHistory bookLibHistory);
	public bookLibHistory selectBookKinds(bookLibHistory bookLibHistory);
	public ArrayList<Object> selectAllBookHistory();
	public ArrayList<Object> selectReaderBookHistory(Reader reader);
}
