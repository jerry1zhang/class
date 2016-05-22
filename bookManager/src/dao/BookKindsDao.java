package dao;

import entity.bookKinds;

public interface BookKindsDao {
	public boolean createBookKinds(bookKinds bookKinds);
	public boolean delectBookKinds(bookKinds bookKinds);
	public boolean updateBookKinds(bookKinds bookKinds);
	public bookKinds selectBookKinds(bookKinds bookKinds);
}
