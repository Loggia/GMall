package dao;

public interface BookmarkDao 
{
	/*
	 * 즐겨찾기 관련 메서드
	 */
	int bookmarkCount(String id);

	boolean addBookmark(String id, String bis_no);

	boolean deleteBookmark(String mark_no);
}
