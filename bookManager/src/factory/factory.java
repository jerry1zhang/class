package factory;

import action.impl.BookActionImpl;
import action.impl.ManagerActionImpl;
import action.impl.ReaderActionImpl;
import biz.impl.BookBizImpl;
import biz.impl.ManagerBizImpl;
import biz.impl.ReaderBizImpl;
import dao.impl.BookDaoImpl;
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
	public DBhelper_mysql getDBhelper_mysql(){
		DBhelper_mysql dbh = new DBhelper_mysql();
		return dbh;
	}
	public Reader getReader(){
		Reader r = new Reader();
		return r;
	}
	public Manager getManager(){
		Manager m = new Manager();
		return m;
	}
	public Book getBook(){
		Book b = new Book();
		return b;
	}
}
