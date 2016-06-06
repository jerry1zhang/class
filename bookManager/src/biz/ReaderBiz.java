package biz;

import java.util.ArrayList;

import entity.Reader;

public interface ReaderBiz {
	public boolean Register(Reader reader);
	public int Login(Reader reader);
	public boolean matching(Reader reader);//Æ¥Åä
	public Reader Login(String accounts);
	public boolean information(Reader reader);
	public Reader selectReader(Reader reader);
	public boolean changeReader(Reader reader);
	public ArrayList<Object> allReader();
}
