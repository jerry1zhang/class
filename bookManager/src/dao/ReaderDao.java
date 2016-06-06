package dao;

import java.util.ArrayList;

import entity.Reader;

public interface ReaderDao {
	public boolean createReader(Reader reader);
	public boolean delectReader(Reader reader);
	public boolean updateReader(Reader reader);
	public Reader selectReader(Reader reader);
	public boolean easyUpdateReader(Reader reader);
	public ArrayList<Object> allReader();
}
