package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;

@Service
public class HDServiceImpl implements HDService{
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Product> primList() {
		boardDao.primList();
		return null;
	}

	@Override
	public List<Product> newList() {
		boardDao.newList();
		return null;
	}

	@Override
	public List<Product> popuList() {
		boardDao.popuList();
		return null;
	}

	@Override
	public List<Product> interList(String inter) {
		return boardDao.interList(inter);
	}

}
