package dao;

import java.util.ArrayList;

import entity.bookKinds;

public interface BookKindsDao {
	public boolean createBookKinds(bookKinds bookKinds);
	public boolean delectBookKinds(bookKinds bookKinds);
	public boolean updateBookKinds(bookKinds bookKinds);
	public ArrayList<bookKinds> selectBookKinds();
}
