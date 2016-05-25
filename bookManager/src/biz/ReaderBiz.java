package biz;

import entity.Reader;

public interface ReaderBiz {
	public boolean Register(Reader reader);
	public int Login(Reader reader);
	public boolean matching(Reader reader);//∆•≈‰
	public Reader Login(String accounts);
	public boolean information(Reader reader);
}
