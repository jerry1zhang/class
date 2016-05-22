package dao;

import java.util.ArrayList;

import entity.Book;

public interface BookDao {
	public boolean createBook(Book book);
	public boolean delectBook(Book book);
	public boolean updateBook(Book  book);
	public Book selectBook(Book  book);
	public ArrayList<Book> selectBook();
}
