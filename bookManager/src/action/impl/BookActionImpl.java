package action.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import action.BookAction;
import entity.Book;
import entity.Reader;
import factory.factory;

public class BookActionImpl implements BookAction {
	private factory f = new factory();
	public ArrayList<Object> allBook() {
		ArrayList<Object> bList = f.getBookBizImpl().allBook();
		return bList;
	}
	public boolean LibBook(ArrayList<Object> bList,Reader reader){
		//TODO 可以考虑返回失败了哪些书
		boolean flag = false;
		int n = 0;
		
		for (int i = 0; i < bList.size(); i++) {
			Object book = bList.get(i);
			
			if (f.getBookBizImpl().LibBook(book,reader)) {
				n++;
			}
		}
		if (n==bList.size()) {
			flag = true;
		}
		return flag;
	}
	public ArrayList<Object> readerBookHistory(Reader reader) {
		return f.getBookBizImpl().readerHistory(reader);
	}
	public boolean ReturnBookStatus(Book book) {
		book.setStatus(1);
		return f.getBookBizImpl().changeBookStatus(book);
	}
	public boolean LibBookStatus(Book book) {
		book.setStatus(0);
		return f.getBookBizImpl().changeBookStatus(book);
	}
	public int BookLibDay(Date d1, Date d2) {
//		Date d = new Date(d2.getTime()-d1.getTime());
		java.util.Date smdate = new java.util.Date(d1.getTime());
		java.util.Date bdate = new java.util.Date(d2.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        try {
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        int day = Integer.parseInt(String.valueOf(between_days));
		return day;
	}
	public double BookLibMoney(int day) {
		double mo = 0;
		if (day>60) {
			mo = day * (day-60);
		}
		return mo;
	}

}
