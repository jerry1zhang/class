package factory;

import java.util.Vector;

import action.impl.BookActionImpl;
import action.impl.ManagerActionImpl;
import action.impl.ReaderActionImpl;
import biz.impl.BookBizImpl;
import biz.impl.ManagerBizImpl;
import biz.impl.ReaderBizImpl;
import dao.impl.BookDaoImpl;
import dao.impl.BookKindsDaoImpl;
import dao.impl.BookLibHistoryDaoImpl;
import dao.impl.ManagerDaoImpl;
import dao.impl.ReaderDaoImpl;
import entity.*;
import util.DBhelper_mysql;

public class factory {
	public ReaderActionImpl getReaderActionImpl(){
		ReaderActionImpl rai = new ReaderActionImpl();
		return rai;
	}
	public ReaderBizImpl getReaderBizImpl(){
		ReaderBizImpl rbi = new ReaderBizImpl();
		return rbi;
	}
	public ReaderDaoImpl getReaderDaoImpl(){
		ReaderDaoImpl rdi = new ReaderDaoImpl();
		return rdi;
	}
	public ManagerActionImpl getManagerActionImpl(){
		ManagerActionImpl mai = new ManagerActionImpl();
		return mai;
	}
	public ManagerBizImpl getManagerBizImpl(){
		ManagerBizImpl mbi = new ManagerBizImpl();
		return mbi;
	}
	public ManagerDaoImpl getManagerDaoImpl(){
		ManagerDaoImpl mdi = new ManagerDaoImpl();
		return mdi;
	}
	public BookActionImpl getBookActionImpl(){
		BookActionImpl bai = new BookActionImpl();
		return bai;
	}
	public BookBizImpl getBookBizImpl(){
		BookBizImpl bbi = new BookBizImpl();
		return bbi;
	}
	public BookDaoImpl getBookDaoImpl(){
		BookDaoImpl bdi = new BookDaoImpl();
		return bdi;
	}
	public BookKindsDaoImpl getBookKindsDaoImpl(){
		BookKindsDaoImpl bkdi = new BookKindsDaoImpl();
		return bkdi;
	}
	public BookLibHistoryDaoImpl getBookLibHistoryDaoImpl(){
		BookLibHistoryDaoImpl blhdi = new BookLibHistoryDaoImpl();
		return blhdi;
	}
	public DBhelper_mysql getDBhelper_mysql(){
		DBhelper_mysql dbh = new DBhelper_mysql();
		return dbh;
	}
	public Reader getReader(){
		Reader r = new Reader();
		r.setRid(0);
		return r;
	}
	public Manager getManager(){
		Manager m = new Manager();
		m.setMid(0);
		return m;
	}
	public Book getBook(){
		Book b = new Book();
		return b;
	}
	public bookLibHistory getbookLibHistory(Book book,Reader reader){
		bookLibHistory b = new bookLibHistory();
		b.setBook(book);
		b.setReader(reader);
		return b;
	}
}
