package view;

import java.sql.Date;
import java.util.Vector;

import entity.Book;
import entity.bookLibHistory;
import factory.factory;

public class serviceUI {
	private factory f = new factory();
	private int noData = 100;
	private int F = -1;
	private int T = 1;
	public int double_bManagerLib(Vector<Vector<Object>> Data,int row){
		int flag = F;
		if (Data==null) {
			flag = noData;
		}else {
			if (f.getManagerActionImpl().ManagerLibHistoryUpdate(Integer.valueOf(Data.get(row).get(1).toString()))) {
				flag = T;
			}
		}
		return flag;
	}
	public int double_bManagerReturn(Vector<Vector<Object>> Data,int row){
		int flag = F;
		if (Data==null) {
			flag = noData;
		}else {
			int bid = Integer.valueOf(Data.get(row).get(1).toString());
			Book book = new Book();
			book.setBid(bid);
			if (f.getBookActionImpl().ReturnBookStatus(book)&&f.getManagerActionImpl().ManagerReturnHistoryUpdate(Integer.valueOf(Data.get(row).get(1).toString()))) {
				flag = T;
			}
		}
		return flag;
	}
	public int addBook(Vector<Object> v){
		int flag = F;
		java.util.Date date = new java.util.Date();
		Book book = f.getBook();
		Date d = new Date(date.getTime());
		book.setbDate(d);
		book.setName(v.get(0).toString());
		book.setBookKindsNo(Integer.valueOf(v.get(1).toString())+1);
		book.setbPress(v.get(2).toString());
		book.setbAuthor(v.get(3).toString());
		book.setbValue(Double.valueOf(v.get(4).toString()));
		if (f.getBookBizImpl().addBook(book)) {
			flag = T;
		}
		return flag;
	}
	public int changeBook(Vector<Object> v){
		int flag = F;
		Book book = f.getBook();
		book.setBid(Integer.valueOf(v.get(0).toString()));
		book.setName(v.get(1).toString());
		book.setBookKindsNo(Integer.valueOf(v.get(2).toString())+1);
		book.setbPress(v.get(3).toString());
		book.setbAuthor(v.get(4).toString());
		book.setbValue(Double.valueOf(v.get(5).toString()));
		if (f.getBookBizImpl().changeBook(book)) {
			flag = T;
		}
		return flag;
	}
}
