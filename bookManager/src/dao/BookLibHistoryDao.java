package dao;

import java.sql.Date;
import java.util.ArrayList;

import entity.Book;
import entity.Reader;
import entity.bookLibHistory;

public interface BookLibHistoryDao {
	public boolean createBookLibHistory(bookLibHistory bookLibHistory,Reader reader);
	public boolean delectBookLibHistory(bookLibHistory bookLibHistory);
	public boolean updateBookLibHistory(bookLibHistory bookLibHistory);
	public boolean updateBookLibHistory(int bno,Date LibDate);
	public bookLibHistory selectBookLibHistory(bookLibHistory bookLibHistory);
	public ArrayList<Object> selectAllBookHistory();
	public ArrayList<Object> selectReaderBookHistory(Reader reader);
}
