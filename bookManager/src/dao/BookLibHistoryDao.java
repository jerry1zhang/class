package dao;

import java.sql.Date;
import java.util.ArrayList;

import entity.Book;
import entity.Reader;
import entity.bookLibHistory;

public interface BookLibHistoryDao {
	public boolean createbookLibHistory(bookLibHistory bookLibHistory,Reader reader);
	public boolean delectbookLibHistory(bookLibHistory bookLibHistory);
	public boolean updatebookLibHistory(bookLibHistory bookLibHistory);
	public boolean updatebookLibHistory(int bookLibHistoryNo,Date LibDate);
	public bookLibHistory selectbookLibHistory(bookLibHistory bookLibHistory);
	public ArrayList<Object> selectAllBookHistory();
	public ArrayList<Object> selectReaderBookHistory(Reader reader);
}
